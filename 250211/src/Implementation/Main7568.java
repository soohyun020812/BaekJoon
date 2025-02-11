package Implementation;
import java.io.*;
import java.util.*;

// 7568 덩치 
public class Main7568 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수 입력
        int N = Integer.parseInt(br.readLine());
        // 몸무게, 키 저장
        int[][] people = new int[N][2]; 

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 몸무게
            people[i][0] = Integer.parseInt(st.nextToken()); 
            // 키
            people[i][1] = Integer.parseInt(st.nextToken()); 
        }

        // 덩치 등수 계산
        int[] ranks = new int[N];
        // 기본 등수를 1로 설정
        Arrays.fill(ranks, 1); 

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) { 
                    // i번 사람이 j번 사람보다 덩치가 작다면 등수 증가
                    if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                        ranks[i]++;
                    }
                }
            }
        }

        for (int rank : ranks) {
            System.out.print(rank + " ");
        }
    }
}
