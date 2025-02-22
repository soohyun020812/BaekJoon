package foundations_of_mathematics;
import java.io.*;
import java.util.*;

// 5618 공약수 
public class Main5618 {
	// 최대공약수(GCD) 구하는 함수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        // 두 개의 숫자의 GCD 계산
        int gcdValue = gcd(num1, num2);

        // 세 번째 숫자가 있다면 추가로 GCD 계산
        if (n == 3) {
            int num3 = Integer.parseInt(st.nextToken());
            gcdValue = gcd(gcdValue, num3);
        }

        // 1부터 gcdValue의 제곱근까지 확인 (공약수 찾기)
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= gcdValue; i++) {
            if (gcdValue % i == 0) {
                divisors.add(i);
                // 중복 방지
                if (i != gcdValue / i) { 
                    divisors.add(gcdValue / i);
                }
            }
        }

        // 오름차순 정렬 후 출력
        Collections.sort(divisors);
        for (int divisor : divisors) {
        	
            System.out.println(divisor);
        }
    }
}
