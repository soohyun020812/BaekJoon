package ten;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 27323 직사각형
public class Main27323 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // A 입력받기
        int A = Integer.parseInt(br.readLine());
        
        // B 입력받기
        int B = Integer.parseInt(br.readLine());
        
        // 넓이 계산
        int area = A * B;
        
        System.out.println(area);
    }
}
