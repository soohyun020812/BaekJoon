package five;
import java.util.Scanner;

// 27866 문자와 문자열
public class Main27866 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 단어 입력
        String S = sc.next();
        
        // 정수 입력
        int i = sc.nextInt();
        
        // 인덱스는 1부터 시작하므로 i-1 사용
        System.out.println(S.charAt(i - 1));
        
        sc.close(); 
	}
}
