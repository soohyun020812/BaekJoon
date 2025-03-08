package two_pointer;
import java.io.*;
import java.util.*;

// 회전 초밥 
public class Main2531 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 접시의 수
        int N = Integer.parseInt(st.nextToken()); 
        // 초밥의 가짓수
        int d = Integer.parseInt(st.nextToken()); 
        // 연속해서 먹는 접시 수
        int k = Integer.parseInt(st.nextToken()); 
        // 쿠폰 번호
        int c = Integer.parseInt(st.nextToken()); 

        // 벨트 배열 생성
        int[] belt = new int[N];

        // 초밥 입력 받기 
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine().trim());
        }

        // 슬라이딩 윈도우 로직 수행
        System.out.println(getMaxSushiVarieties(N, d, k, c, belt));
    }

    // 최대 초밥 가짓수 구하는 함수
    private static int getMaxSushiVarieties(int N, int d, int k, int c, int[] belt) {
    	// 초밥 개수 카운트 배열
    	int[] count = new int[d + 1]; 
    	// 현재 다른 초밥 종류 수
    	int kind = 0; 

        // 초기 윈도우 세팅
        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) kind++;
            count[belt[i]]++;
        }

        int maxKind = kind;

        // 슬라이딩 윈도우 탐색
        for (int i = 0; i < N; i++) {
        	// 제거될 초밥
        	int removeIdx = belt[i]; 
        	// 추가될 초밥 (원형)
        	int addIdx = belt[(i + k) % N]; 

            // 초밥 제거
            count[removeIdx]--;
            if (count[removeIdx] == 0) kind--;

            // 초밥 추가
            if (count[addIdx] == 0) kind++;
            count[addIdx]++;

            // 쿠폰 초밥 추가 여부 확인
            if (count[c] == 0) {
                maxKind = Math.max(maxKind, kind + 1);
            } else {
                maxKind = Math.max(maxKind, kind);
            }
        }

        return maxKind;
    }
}
