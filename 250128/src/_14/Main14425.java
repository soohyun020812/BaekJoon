package _14;
import java.io.*;
import java.util.*;

// 14425 문자열 집합
public class Main14425 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 : N과 M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 집합 S 입력받기
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        // 검사 문자열 입력받으며 포함 여부 확인
        int count = 0;
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (set.contains(query)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
