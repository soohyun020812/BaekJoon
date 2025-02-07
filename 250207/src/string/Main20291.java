package string;
import java.io.*;
import java.util.*;

// 20291 파일 정리 
public class Main20291 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // HashMap 대신 TreeMap을 사용하여 자동 정렬
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String fileName = br.readLine();
            // 확장자 추출
            String extension = fileName.substring(fileName.lastIndexOf('.') + 1); 

            // map에 확장자 개수 저장
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        // 확장자와 개수 출력
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	result.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        
        System.out.print(result);
    }
}
