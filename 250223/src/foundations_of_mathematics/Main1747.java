package foundations_of_mathematics;
import java.io.*;

// 1747 소수&팰린드롬 
public class Main1747 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (true) {
        	// N이 소수이고 팰린드롬이면 출력하고 종료
            if (isPrime(N) && isPalindrome(N)) {
                System.out.println(N);
                break;
            }
            // 조건을 만족하지 않으면 N을 증가시키며 탐색 
            N++;
        }
    }
	
	/*
     * 소수 판별 함수
     * @param num : 검사할 숫자
     * @return true이면 소수, false이면 소수가 아님
     */

    public static boolean isPrime(int num) {
    	// 1 이하는 소수가 아님
        if (num < 2) return false;
        // 2부터 sqrt(num)까지 검사
        for (int i = 2; i * i <= num; i++) {
        	// 나누어 떨어지면 소수가 아님 
            if (num % i == 0) return false;
        }
        // 위 조건을 통과 시 소수 
        return true;
    }
    
    /*
     * 팰린드롬 판별 함수
     * @param num : 검사할 숫자
     * @return true이면 팰린드롬, false이면 팰린드롬이 아님
     */

    public static boolean isPalindrome(int num) {
    	// 정수를 문자열로 변환
    	String str = Integer.toString(num); 
    	// 문자열을 뒤집음
        String reversedStr = new StringBuilder(str).reverse().toString(); 
        // 원본 문자열과 뒤집은 문자열이 같은지 확인
        return str.equals(reversedStr); 
    }
}
