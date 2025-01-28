package _15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 1934 최소공배수
public class Main1934 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수 읽기
        int t = Integer.parseInt(br.readLine());

        // 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            // 각 테스트 케이스의 두 숫자 읽기
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            // 최소공배수 계산
            int lcm = (a * b) / gcd(a, b);

            // 결과를 저장
            sb.append(lcm).append("\n");
        }

        System.out.print(sb.toString());
    }

    // 최대공약수를 구하는 유클리드 호제법
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
