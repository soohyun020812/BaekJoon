package data_structure;
import java.io.*;
import java.util.*;

// 21939 문제 추천 시스템 Version 1
public class Main21939 {
	// 문제 정보를 저장하는 HashMap (문제번호 - 난이도)
    private static Map<Integer, Integer> problemMap = new HashMap<>();

    // 문제를 정렬하여 저장하는 TreeSet (난이도 오름차순, 문제번호 오름차순)
    private static TreeSet<int[]> problemSet = new TreeSet<>((a, b) -> {
    	// 난이도가 같으면 문제 번호 작은 순
    	if (a[0] == b[0]) return a[1] - b[1]; 
    	// 난이도 기준 오름차순 정렬
    	return a[0] - b[0]; 
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 첫 줄 : 문제 개수 N
        int N = Integer.parseInt(br.readLine());

        // N개의 문제 (문제 번호 P, 난이도 L) 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 문제 번호
            int P = Integer.parseInt(st.nextToken()); 
            // 난이도
            int L = Integer.parseInt(st.nextToken()); 

            addProblem(P, L);
        }

        // 다음 줄 : 명령 개수 M
        int M = Integer.parseInt(br.readLine());

        // M개의 명령 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(recommendProblem(x)).append("\n");
            } else if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                addProblem(P, L);
            } else if (command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                removeProblem(P);
            }
        }

        System.out.print(sb);
    }

    // 문제 추가 함수
    private static void addProblem(int P, int L) {
    	// TreeSet에 추가
    	problemSet.add(new int[]{L, P}); 
    	// 문제 정보 저장
    	problemMap.put(P, L); 
    }

    // 추천 문제 함수
    private static int recommendProblem(int x) {
    	// 가장 어려운 문제 찾기
    	if (x == 1) { 
    		// TreeSet의 마지막 원소 (난이도 가장 큼)
            return problemSet.last()[1]; 
        // 가장 쉬운 문제 찾기
    	} else { 
    		// TreeSet의 첫 번째 원소 (난이도 가장 작음)
            return problemSet.first()[1]; 
        }
    }

    // 문제 제거 함수
    private static void removeProblem(int P) {
    	// 해당 문제의 난이도 조회
    	int L = problemMap.get(P); 
    	// TreeSet에서 제거
        problemSet.remove(new int[]{L, P}); 
        // HashMap에서도 제거
        problemMap.remove(P); 
    }
}

/* 
 * 기존 코드는 98% 정답 처리됨
 * 
 * 1. solved 명령어 삭제 오류  
 * - TreeSet에서 new Problem(p, l) 객체를 생성해 삭제했으나
 *   equals() 및 hashCode() 미구현으로 정확한 비교가 되지 않음  
 * = TreeSet을 int[]로 변경하고 remove(new int[]{L, P}) 방식 적용  

 * 2. TreeSet 정렬 기준 문제  
 * - o1.p - o2.p 방식으로 정렬했으나
 *   equals() 미구현 시 TreeSet에서 같은 값으로 인식되지 않을 가능성 존재  
 * = TreeSet을 int[] {난이도, 문제번호} 형태로 저장하여 정렬 유지  

 * 3. recommend 연산 속도 문제  
 * - ts.last(), ts.first() 사용 시 기존 Problem 객체 기반 TreeSet 구조로 인해 비효율 발생 가능  
 * = TreeSet을 int[] 기반으로 변경하여 first(), last() 호출 시 O(1) 성능 보장  
*/