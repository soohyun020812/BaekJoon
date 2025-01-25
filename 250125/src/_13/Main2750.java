package _13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// 2750 수 정렬하기
public class Main2750 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수의 개수 N (1 ≤ N ≤ 1,000)
        int N = Integer.parseInt(br.readLine()); 
        // 숫자들을 저장할 배열
        int[] numbers = new int[N]; 

        // 숫자 입력
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // Arrays 클래스의 sort 메서드를 사용하여 배열 정렬
        Arrays.sort(numbers); 

        for (int num : numbers) {
        	// 정렬된 숫자를 한 줄씩 출력
            System.out.println(num); 
        }
    }
}
