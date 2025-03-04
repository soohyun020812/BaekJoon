package brute_force;
import java.io.*;
import java.util.*;

// 14888 연산자 끼워넣기 
public class Main14888 {
	static int N;
    static int[] numbers;
    // +, -, *, /
    static int[] operators = new int[4]; 
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(numbers[0], 1);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    // 백트래킹 : 현재까지의 결과(current)와 다음 숫자의 인덱스(index)를 매개변수로 사용
    static void backtrack(int current, int index) {
        if (index == N) { // 모든 연산자가 사용된 경우
            maxResult = Math.max(maxResult, current);
            minResult = Math.min(minResult, current);
            return;
        }

        for (int i = 0; i < 4; i++) {
        	// 해당 연산자가 남아있다면 사용
        	if (operators[i] > 0) { 
                operators[i]--;

                int next = calculate(current, numbers[index], i);
                backtrack(next, index + 1);

                // 백트래킹 (원상 복구)
                operators[i]++; 
            }
        }
    }

    // 연산 수행
    static int calculate(int a, int b, int op) {
        switch (op) {
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            // 나눗셈은 정수 나눗셈
            case 3: return a / b; 
            default: return 0;
        }
    }
}
