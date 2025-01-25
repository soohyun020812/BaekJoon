package _13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// 2751 수 정렬하기 2
public class Main2751 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 입력 : N
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 줄부터 N개의 수 입력
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        
        // 오름차순 정렬
        Arrays.sort(numbers);
        
        // 정렬 결과
        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }
}
