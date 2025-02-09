package string;
import java.io.*;

// 2506 점수계산 
public class Main2506 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 문자열
        String str = br.readLine(); 
        // 폭발 문자열
        String bomb = br.readLine(); 
        int bombLen = bomb.length();
        
        // 스택 역할을 하는 StringBuilder
        StringBuilder sb = new StringBuilder(); 

        for (char c : str.toCharArray()) { 
        	// 한 글자씩 추가
        	sb.append(c); 
            
            // 폭발 문자열 길이 이상이 되었을 때 확인
            if (sb.length() >= bombLen) {
                // sb.substring()으로 끝부분이 폭발 문자열과 일치하는지 확인
                if (sb.substring(sb.length() - bombLen).equals(bomb)) {
                    // 같다면 sb.delete()로 제거
                    sb.delete(sb.length() - bombLen, sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
