package _13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// 2587 대표값2
public class Main2587 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[5];
        int sum = 0;

        // 입력받아 배열에 저장 및 합 계산
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }

        // 평균 계산
        int average = sum / 5;

        // 배열 정렬
        Arrays.sort(numbers);

        // 중앙값 계산
        // 정렬된 배열에서 세 번째 값
        int median = numbers[2]; 

        System.out.println(average);
        System.out.println(median);
    }
}
