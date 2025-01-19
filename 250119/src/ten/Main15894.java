package ten;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 15894 수학은 체육과목 입니다
public class Main15894 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        
        // 둘레 계산
        long perimeter = 4 * n;
        
        System.out.println(perimeter);
    }
}
