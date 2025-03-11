package greedy;
import java.io.*;
import java.util.*;

// 11508 2+1 세일
public class Main11508 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            prices.add(Integer.parseInt(br.readLine()));
        }

        // 내림차순 정렬 (비싼 순서)
        prices.sort(Collections.reverseOrder());

        int totalCost = 0;
        for (int i = 0; i < N; i++) {
        	// 3번째 제품은 무료
        	if (i % 3 != 2) { 
                totalCost += prices.get(i);
            }
        }

        System.out.println(totalCost);
    }
}
