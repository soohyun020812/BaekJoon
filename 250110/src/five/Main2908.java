package five;
import java.io.IOException;

// 2908 상수
public class Main2908 {
	public static void main(String[] args) throws IOException {
		int A = 0;
		int B = 0;
		
		// A를 거꾸로 읽어 저장 (ASCII Code 48대신 '0'으로 대입해도 됨)
		// 1의 자리
		A += System.in.read() - 48;
		// 10의 자리
		A += (System.in.read() - 48)*10;
		// 100의 자리
		A += (System.in.read() - 48)*100;
		
		// A와 B 사이 공백 문자를 읽어 무시
		System.in.read();
		
		B += System.in.read() - 48;
		B += (System.in.read() - 48)*10;
		B += (System.in.read() - 48)*100;
		
		// A와 B 중 더 큰 숫자를 출력 (삼항 연산자 사용)
		System.out.println(A > B ? A : B);
	}
}
