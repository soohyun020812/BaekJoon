package brute_force;
import java.io.*;

// 16637 괄호 추가하기 
public class Main16637 {
	static int N;
    static int[] numbers;
    static char[] operators;
    // 최댓값 저장
    static int maxResult = Integer.MIN_VALUE; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        N = Integer.parseInt(br.readLine());
        String expression = br.readLine();

        // 숫자의 개수
        int numCount = (N + 1) / 2; 
        numbers = new int[numCount];
        operators = new char[numCount - 1];

        // 숫자와 연산자 분리
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) numbers[i / 2] = expression.charAt(i) - '0';
            else operators[i / 2] = expression.charAt(i);
        }

        // 백트래킹 시작, 초기 값 : 첫 번째 숫자, 인덱스 0
        dfs(0, numbers[0]);

        // 최댓값 출력
        System.out.println(maxResult);
    }

/*
 * 백트래킹 탐색 (DFS)
 * @param index 현재 계산할 연산자의 인덱스
 * @param curValue 현재까지 계산된 값
*/
    
    public static void dfs(int index, int curValue) {
        // 마지막 숫자까지 계산한 경우, 최댓값 갱신
        if (index == numbers.length - 1) {
            maxResult = Math.max(maxResult, curValue);
            return;
        }

        // 현재 연산자를 사용하여 계산
        int nextValue = calculate(curValue, numbers[index + 1], operators[index]);
        dfs(index + 1, nextValue);

        // 괄호를 사용하여 다음 연산을 먼저 계산한 후 진행 (괄호 추가 가능할 때만)
        if (index + 1 < operators.length) {
        	// 괄호 연산
            int bracketValue = calculate(numbers[index + 1], numbers[index + 2], operators[index + 1]); 
            int newCurValue = calculate(curValue, bracketValue, operators[index]);
            // 다음 연산자로 이동
            dfs(index + 2, newCurValue); 
        }
    }

/*
 * 연산을 수행하는 함수
 * @param a 첫 번째 숫자
 * @param b 두 번째 숫자
 * @param op 연산자 (+, -, *)
 * @return 연산 결과
*/
    
    public static int calculate(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;

        return a * b;
    }
}
