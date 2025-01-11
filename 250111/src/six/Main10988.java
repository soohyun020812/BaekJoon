package six;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 10988 팰린드롬인지 확인하기
public class Main10988 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); 

        // 입력 문자열을 뒤집은 결과와 비교
        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equals(reversed)) {
            System.out.println(1); 
        } else {
            System.out.println(0); 
        }
    }
}
