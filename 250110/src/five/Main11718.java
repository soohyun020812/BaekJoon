package five;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 11718 그대로 출력하기
public class Main11718{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // EOF 처리 (End of File, 데이터 소스로부터 더 이상 읽을 수 있는 데이터가 없음)
        while ((line = br.readLine()) != null) { 
        	 // 입력받은 줄 그대로 출력
        	System.out.println(line); 
        }
    }
}
