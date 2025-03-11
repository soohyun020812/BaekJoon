package greedy;
import java.io.*;

// 20365 블로그2 
public class Main20365 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main20365().solution();
    }

    public void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String problem = br.readLine();
        int bCnt = 0, rCnt = 0;
        // 이전 문자 초기화
        char prev = ' '; 
        
        for (int i = 0; i < n; i++) {
            char cur = problem.charAt(i);
            // 새로운 색 그룹 시작
            if (cur != prev) { 
                if (cur == 'R') rCnt++;
                else bCnt++;
            }
            prev = cur;
        }
        
        // 최소 횟수 계산
        System.out.println(Math.min(rCnt, bCnt) + 1); 
    }
}
