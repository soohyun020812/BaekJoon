package _11;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 24313 알고리즘 수업 - 점근적 표기 1
public class Main24313 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 : a1, a0 입력받기
        String[] line1 = br.readLine().split(" ");
        int a1 = Integer.parseInt(line1[0]);
        int a0 = Integer.parseInt(line1[1]);

        // 두 번째 줄 : c 입력받기
        int c = Integer.parseInt(br.readLine());

        // 세 번째 줄 : n0 입력받기
        int n0 = Integer.parseInt(br.readLine());

        if (isBigO(a1, a0, c, n0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    // O(n) 정의를 만족하는지 확인하는 함수
    public static boolean isBigO(int a1, int a0, int c, int n0) {
        // a1 > c인 경우 부등식이 성립하지 않음
        if (a1 > c) {
            return false;
        }

        // n0 이상에서 부등식이 성립하는지 확인
        // 문제에서 n의 최대 범위가 100까지로 제한됨
        for (int n = n0; n <= 100; n++) { 
            if ((a1 - c) * n + a0 > 0) {
            	// 한 번이라도 부등식이 성립하지 않으면 false 반환
            	return false; 
            }
        }

        // 모든 n에서 부등식이 성립하면 true 반환
        return true; 
    }
}
