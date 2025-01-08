package four;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 5597 과제 안 내신 분..?
public class Main5597 {
	public static void main(String[] args) throws IOException {
        // 1번~30번 학생, 0번은 사용하지 않음
        boolean[] submitted = new boolean[31];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 28명의 제출자 번호 입력 
        for (int i = 0; i < 28; i++) {
            int studentNumber = Integer.parseInt(br.readLine());
            // 제출한 학생의 번호를 true로 표시
            submitted[studentNumber] = true; 
        }

        // 제출하지 않은 학생 번호 출력
        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) { 
                System.out.println(i);
            }
        }
    }
}
