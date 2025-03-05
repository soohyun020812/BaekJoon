package brute_force;
import java.io.*;

// A와 B 2
public class Main12919 {
	static String S, T;
	// 변환 가능 여부
    static boolean isPossible = false; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        // T에서 시작하여 S로 변환 가능한지 탐색
        dfs(T); 

        System.out.println(isPossible ? 1 : 0);
    }

    static void dfs(String t) {
    	// 목표 문자열 S에 도달하면 종료
    	if (t.equals(S)) { 
            isPossible = true;
            
            return;
        }
    	// 길이가 더 짧아지거나 이미 가능하면 종료
        if (t.length() <= S.length() || isPossible) return; 

        // 경우 1 : 마지막이 'A'인 경우 → 'A' 제거 후 재귀 호출
        if (t.charAt(t.length() - 1) == 'A') {
            dfs(t.substring(0, t.length() - 1));
        }
        // 경우 2 : 마지막이 'B'인 경우 → 'B' 제거 후 뒤집기
        if (t.charAt(0) == 'B') {
            dfs(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }
}
