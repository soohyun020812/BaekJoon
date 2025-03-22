package sw;
import java.io.*;
import java.util.*;

// 16235 나무 재테크 
public class Main16235 {
	// 땅의 크기, 초기 나무 개수, 시뮬레이션 연도 수
	static int N, M, K; 
	// 추가되는 양분과 현재 땅의 양분 상태
	static int[][] nutrients, land; 
	// 살아있는 나무 리스트 (우선순위 큐 사용으로 정렬 최적화)
	static PriorityQueue<Tree> trees; 
	// 가을 번식을 위한 이동 방향 (행)    
	static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; 
	// 가을 번식을 위한 이동 방향 (열)
	static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1}; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력값 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 겨울마다 추가되는 양분 정보
        nutrients = new int[N][N]; 
        // 현재 땅의 양분 상태
        land = new int[N][N]; 
        // 나이가 어린 순으로 자동 정렬
        trees = new PriorityQueue<>(Comparator.comparingInt(t -> t.age)); 
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nutrients[i][j] = Integer.parseInt(st.nextToken());
                // 초기 양분 값은 5
                land[i][j] = 5; 
            }
        }
        
        // 나무 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }
        
        // K년 동안 시뮬레이션 실행
        for (int year = 0; year < K; year++) {
            simulateYear();
        }
        
        System.out.println(trees.size());
    }
    
    static void simulateYear() {
    	// 살아남은 나무 리스트
        Queue<Tree> aliveTrees = new LinkedList<>(); 
        // 죽은 나무 리스트
        List<Tree> deadTrees = new ArrayList<>(); 
        // 번식할 나무 리스트
        List<Tree> newTrees = new ArrayList<>(); 
        
        // 봄 : 나무가 자신의 나이만큼 양분을 먹고 성장
        while (!trees.isEmpty()) {
            Tree tree = trees.poll();
            if (land[tree.x][tree.y] >= tree.age) {
                land[tree.x][tree.y] -= tree.age;
                tree.age++;
                aliveTrees.add(tree);
                if (tree.age % 5 == 0) newTrees.add(tree);
            } else {
                deadTrees.add(tree);
            }
        }
        
        // 여름 : 죽은 나무가 양분으로 변환
        for (Tree tree : deadTrees) {
            land[tree.x][tree.y] += tree.age / 2;
        }
        
        // 가을 : 번식
        for (Tree tree : newTrees) {
            for (int d = 0; d < 8; d++) {
                int nx = tree.x + dx[d], ny = tree.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    aliveTrees.add(new Tree(nx, ny, 1));
                }
            }
        }
        
        // 살아남은 나무 및 새로 번식한 나무 큐에 추가
        trees.addAll(aliveTrees); 
        
        // 겨울 : 땅에 양분 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                land[i][j] += nutrients[i][j];
            }
        }
    }
    
    // 나무 클래스
    static class Tree {
    	// 나무의 위치(x, y)와 나이(age)
    	int x, y, age; 
        
        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }
}
