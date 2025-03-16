package sw;
import java.io.*;
import java.util.*;

// 13458 시험 감독 
public class Main13458 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 시험장 개수
        int N = Integer.parseInt(br.readLine()); 
        // 각 시험장 응시자 수
        int[] A = new int[N]; 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        // 총감독관 감시 가능 인원
        int B = Integer.parseInt(st.nextToken()); 
        // 부감독관 감시 가능 인원
        int C = Integer.parseInt(st.nextToken()); 
        // 총 필요한 감독관 수
        long totalSupervisors = 0; 
        
        for (int i = 0; i < N; i++) {
            int students = A[i];

            // 1. 총감독관 1명 배치
            students -= B;
            totalSupervisors++;

            // 2. 부감독관 배치
            if (students > 0) {
            	// 올림 계산
                totalSupervisors += (students + C - 1) / C; 
            }
        }

        System.out.println(totalSupervisors);
    }
}
