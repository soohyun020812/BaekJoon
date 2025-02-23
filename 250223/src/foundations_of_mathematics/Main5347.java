package foundations_of_mathematics;
import java.io.*;
import java.util.*;

// 5347 LCM
public class Main5347 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            // int → long 변경
            long a = Long.parseLong(st.nextToken()); 
            long b = Long.parseLong(st.nextToken());

            long gcd = getGCD(a, b);
            // overflow 방지를 위해 long 사용
            long lcm = (a * b) / gcd; 

            sb.append(lcm).append("\n");
        }
        System.out.print(sb);
    }

    // 최대공약수(GCD) 계산 
	// int → long 변경
    private static long getGCD(long a, long b) { 
        while (b != 0) {
        	// int → long 변경
            long temp = a; 
            a = b;
            b = temp % b;
        }

        return a;
    }
}
