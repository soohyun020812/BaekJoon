package two_pointer;
import java.io.*;
import java.util.*;

// 21921 블로그 
public class Main21921 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitors = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 초기 윈도우 합 구하기
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += visitors[i];
        }

        int maxSum = sum; // 최댓값 저장
        int count = 1; // 최댓값이 나온 횟수

        // 2. 슬라이딩 윈도우 이동
        for (int i = X; i < N; i++) {
            sum = sum - visitors[i - X] + visitors[i]; // 윈도우 이동 (이전 값 빼고, 새로운 값 추가)

            if (sum > maxSum) {  // 새로운 최댓값 발견
                maxSum = sum;
                count = 1;
            } else if (sum == maxSum) {  // 같은 최댓값이 나온 경우
                count++;
            }
        }

        if (maxSum == 0) {
        	
            System.out.println("SAD");
        } else {
        	
            System.out.println(maxSum);
            System.out.println(count);
        }
    }
}
