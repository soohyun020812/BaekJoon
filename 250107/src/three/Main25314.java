package three;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 25314 코딩은 체육과목 입니다
public class Main25314 {
	public static void main(String[] args) throws IOException {
		// BufferedReader 객체 생성 : 입력을 효율적으로 처리하기 위해 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력된 숫자를 읽고 정수로 변환 (입력은 바이트 크기)
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n/4; i++) {
			// "long" 키워드 출력 (공백 포함)
			System.out.print("long ");
		}
		System.out.println("int");
	}
}
