package data_structure;
import java.io.*;
import java.util.*;

// 2910 빈도 정렬 
public class Main2910 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 메시지 길이
        int n = Integer.parseInt(st.nextToken()); 
        // 숫자의 최댓값
        int c = Integer.parseInt(st.nextToken()); 

        st = new StringTokenizer(br.readLine());
        // 숫자별 빈도 저장
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // 숫자 최초 등장 인덱스
        Map<Integer, Integer> firstIndexMap = new HashMap<>(); 
        // 원본 숫자 배열
        List<Integer> numbers = new ArrayList<>(); 

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers.add(num);
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            // 처음 등장한 인덱스 저장
            firstIndexMap.putIfAbsent(num, i); 
        }

        // 빈도 높은 순 > 등장 순서 빠른 순 정렬
        numbers.sort((a, b) -> {
            if (frequencyMap.get(b).equals(frequencyMap.get(a))) {
            	// 등장 순서 기준 오름차순
            	return firstIndexMap.get(a) - firstIndexMap.get(b); 
            }
            // 빈도 기준 내림차순
            return frequencyMap.get(b) - frequencyMap.get(a); 
        });

        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
