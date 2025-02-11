package Implementation;
import java.io.*;
import java.util.*;

// 21918 전구 
public class Main21918 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 전구의 개수 N과 명령어 개수 M을 읽음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 두 번째 줄에서 초기 전구 상태를 읽음
        int[] bulbs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bulbs[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 명령어 번호
            int a = Integer.parseInt(st.nextToken()); 
            // 첫 번째 인자
            int b = Integer.parseInt(st.nextToken()); 
            // 두 번째 인자
            int c = Integer.parseInt(st.nextToken()); 
            
            switch (a) {
                case 1:
                    // 1번 명령어 : b번째 전구의 상태를 c로 설정
                    bulbs[b - 1] = c;
                    break;
                case 2:
                    // 2번 명령어 : b번부터 c번까지의 전구 상태를 반전
                    for (int j = b - 1; j < c; j++) {
                        bulbs[j] = 1 - bulbs[j];
                    }
                    break;
                case 3:
                    // 3번 명령어 : b번부터 c번까지의 전구를 끄기
                    for (int j = b - 1; j < c; j++) {
                        bulbs[j] = 0;
                    }
                    break;
                case 4:
                    // 4번 명령어 : b번부터 c번까지의 전구를 켜기
                    for (int j = b - 1; j < c; j++) {
                        bulbs[j] = 1;
                    }
                    break;
            }
        }
        
        // 전구의 상태
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(bulbs[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
