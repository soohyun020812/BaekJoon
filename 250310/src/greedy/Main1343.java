package greedy;
import java.io.*;

// 1343 폴리오미노 
public class Main1343 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();
        StringBuilder result = new StringBuilder();

        // 연속된 'X' 개수를 세기 위한 변수
        int count = 0; 

        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);

            if (c == 'X') {
                count++;
            } else {
                if (!fillPolyomino(result, count)) {
                    
                	System.out.println("-1");
                    return;
                }
                // '.' 유지
                result.append('.'); 
                count = 0;
            }
        }

        // 마지막 'X' 덮기
        if (!fillPolyomino(result, count)) {
            System.out.println("-1");
            return;
        }

        System.out.println(result.toString());
    }

    private static boolean fillPolyomino(StringBuilder result, int count) {
    	// 변환할 'X'가 없으면 그대로 유지
    	if (count == 0) return true; 

    	// 홀수 개의 'X'는 덮을 수 없음
        if (count % 2 != 0) return false; 

        // 'AAAA'를 최대한 먼저 배치하고, 남은 2개는 'BB'로 채움
        while (count >= 4) {
            result.append("AAAA");
            count -= 4;
        }
        if (count == 2) {
            result.append("BB");
        }

        return true;
    }
}
