package foundations_of_mathematics;
import java.io.*;

// 3474 교수가 된 현우 
public class Main3474 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(countTrailingZeros(N)).append("\n");
        }

        System.out.print(sb);
    }

    // N!에서 5의 배수 개수를 세어 0의 개수를 구하기 
    public static int countTrailingZeros(int N) {
        int count = 0;
        while (N >= 5) {
            count += N / 5;
            N /= 5;
        }
        
        return count;
    }
}
