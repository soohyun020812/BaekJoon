package eight;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 2720 세탁소 사장 동혁 
public class Main2720 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
        	 // 거스름돈
            int C = Integer.parseInt(br.readLine());

            // 쿼터 개수
            int quarters = C / 25; 
            // 나머지 금액
            C %= 25;

            // 다임 개수
            int dimes = C / 10; 
            C %= 10; 

            // 니켈 개수
            int nickels = C / 5; 
            C %= 5;

            // 페니 개수
            int pennies = C;

            // 결과 저장
            sb.append(quarters).append(" ").append(dimes).append(" ")
              .append(nickels).append(" ").append(pennies).append("\n");
        }

        System.out.print(sb);
    }
}
