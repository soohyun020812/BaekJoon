package implementation;
import java.io.*;
import java.util.*;

// 20207 달력 
public class Main20207 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 달력 배열 (1~365일)
        int[] calendar = new int[366]; 

        // 일정 정보 입력받아 달력에 표시
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
            	// 해당 날짜에 일정 추가
            	calendar[j]++; 
            }
        }

        // 코팅지 면적
        int totalArea = 0; 
        // 현재 연속된 구간의 너비
        int width = 0;
        // 현재 연속된 구간의 최대 높이
        int maxHeight = 0; 

        for (int i = 1; i <= 365; i++) {
        	// 일정이 있는 날
        	if (calendar[i] > 0) { 
                width++;
                maxHeight = Math.max(maxHeight, calendar[i]);
            // 연속된 구간이 끝난 경우
        	} else if (width > 0) { 
                totalArea += width * maxHeight;
                width = 0;
                maxHeight = 0;
            }
        }

        // 마지막 남은 구간 추가
        if (width > 0) {
            totalArea += width * maxHeight;
        }

        System.out.println(totalArea);
    }
}
