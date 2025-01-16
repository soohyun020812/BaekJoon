package nine;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 5086 배수와 약수
public class Main5086 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            
            // 0 0이면 종료
            if (A == 0 && B == 0) {
                break;
            }
            
            // A가 B의 약수일 경우
            if (B % A == 0) {
                System.out.println("factor");
            }
            // A가 B의 배수일 경우
            else if (A % B == 0) {
                System.out.println("multiple");
            }
            // 둘 다 아니라면 neither
            else {
                System.out.println("neither");
            }
        }
    }
}
