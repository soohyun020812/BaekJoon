package string;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 4659 비밀번호 발음하기 
public class Main4659 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password;
        
        while (true) {
            password = br.readLine();
            
            // 'end'이면 종료
            if (password.equals("end")) {
                break;
            }
            
            // isValidPassword : 패스워드가 유효한지 체크하는 메서드
            if (isValidPassword(password)) {
                System.out.println("<" + password + "> is acceptable.");
            } else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }
    }

    // 패스워드 유효성 검사
    private static boolean isValidPassword(String password) {
        // containsVowel : 주어진 패스워드에 모음이 포함되어 있는지 확인하는 메서드
        if (!containsVowel(password)) {
            return false;
        }
        
        // hasThreeConsecutiveVowelsOrConsonants : 주어진 패스워드에서 연속된 모음 3개 또는 자음 3개가 있는지 확인
        if (hasThreeConsecutiveVowelsOrConsonants(password)) {
            return false;
        }
        
        // 연속된 동일 문자 체크
        if (hasConsecutiveSameCharacter(password)) {
            return false;
        }
        
        return true;
    }

    // 모음이 포함되어 있는지 확인
    private static boolean containsVowel(String password) {
        String vowels = "aeiou";
        for (int i = 0; i < password.length(); i++) {
            if (vowels.indexOf(password.charAt(i)) != -1) {
                return true;
            }
        }
        return false;
    }

    // 연속된 모음 또는 자음이 3개 이상 있는지 확인
    private static boolean hasThreeConsecutiveVowelsOrConsonants(String password) {
        String vowels = "aeiou";
        int vowelCount = 0;
        int consonantCount = 0;
        
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (vowels.indexOf(c) != -1) {
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }
            
            // 연속된 모음 3개 또는 자음 3개 발견 시
            if (vowelCount == 3 || consonantCount == 3) {
                return true;
            }
        }
        return false;
    }

    // hasConsecutiveSameCharacter : 연속된 같은 문자가 있는지 확인 (단, ee, oo는 예외로 허용)
    private static boolean hasConsecutiveSameCharacter(String password) {
        for (int i = 1; i < password.length(); i++) {
            char current = password.charAt(i);
            char previous = password.charAt(i - 1);
            
            if (current == previous && !(current == 'e' && previous == 'e') && !(current == 'o' && previous == 'o')) {
                return true;
            }
        }
        
        return false;
    }
}
