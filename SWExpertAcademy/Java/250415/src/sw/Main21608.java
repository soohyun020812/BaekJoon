package sw;
import java.io.*;
import java.util.*;

// 상어 초등학교 
public class Main21608 {
	static int N;
    static int[][] classroom;
    static Map<Integer, Set<Integer>> studentLikes = new HashMap<>();
    // 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classroom = new int[N][N];
        List<Integer> order = new ArrayList<>();

        // 학생 정보 입력 및 저장
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            order.add(student);
            Set<Integer> likes = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                likes.add(Integer.parseInt(st.nextToken()));
            }
            studentLikes.put(student, likes);
        }

        // 학생 배치
        for (int student : order) {
            placeStudent(student);
        }

        // 만족도 계산
        System.out.println(calculateSatisfaction());
    }

    // 학생을 규칙에 따라 자리에 배치하는 함수
    private static void placeStudent(int student) {
        int maxLike = -1;
        int maxEmpty = -1;
        int finalRow = -1;
        int finalCol = -1;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 이미 자리가 차 있으면 무시
                if (classroom[r][c] != 0) continue;

                int likeCnt = 0;
                int emptyCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (isInBounds(nr, nc)) {
                        if (classroom[nr][nc] == 0) emptyCnt++;
                        else if (studentLikes.get(student).contains(classroom[nr][nc])) likeCnt++;
                    }
                }

                // 조건 1, 2, 3 순으로 우선순위 판단
                if (likeCnt > maxLike ||
                    (likeCnt == maxLike && emptyCnt > maxEmpty) ||
                    (likeCnt == maxLike && emptyCnt == maxEmpty && (r < finalRow || (r == finalRow && c < finalCol)))) {
                    maxLike = likeCnt;
                    maxEmpty = emptyCnt;
                    finalRow = r;
                    finalCol = c;
                }
            }
        }

        // 최종 선택된 자리 배치
        classroom[finalRow][finalCol] = student;
    }

    // 만족도 계산 함수
    private static int calculateSatisfaction() {
        int total = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int student = classroom[r][c];
                int likeCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (isInBounds(nr, nc) && studentLikes.get(student).contains(classroom[nr][nc])) {
                        likeCnt++;
                    }
                }

                if (likeCnt > 0) total += Math.pow(10, likeCnt - 1);
            }
        }
        return total;
    }

    // 인덱스 범위 체크
    private static boolean isInBounds(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
