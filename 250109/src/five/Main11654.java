package five;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11654 아스키 코드
public class Main11654 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 한 줄 입력받아 첫 번째 문자 가져오기
        char ch = br.readLine().charAt(0);
        
        // 아스키 코드 값 출력
        System.out.println((int) ch);
    }
}
