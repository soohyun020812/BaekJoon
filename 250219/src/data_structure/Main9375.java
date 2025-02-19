package data_structure;
import java.io.*;
import java.util.*;

// 9375 패션왕 신해빈 
public class Main9375 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
        	// 의상의 개수
            int n = Integer.parseInt(br.readLine()); 
            Map<String, Integer> clothes = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                // 의상의 이름은 무시
                st.nextToken(); 
                // 의상의 종류
                String type = st.nextToken(); 

                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int count : clothes.values()) {
            	// 각 종류 개수 + 1
            	result *= (count + 1); 
            }

            // 알몸 제외
            sb.append(result - 1).append("\n"); 
        }

        System.out.print(sb);
    }
}
