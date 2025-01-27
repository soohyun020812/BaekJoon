package _14;
import java.util.*;

// 11478 서로 다른 부분 문자열의 개수
public class Main11478 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        // 서로 다른 부분 문자열을 저장할 HashSet
        Set<String> substrings = new HashSet<>();

        // 부분 문자열을 하나씩 생성하여 HashSet에 저장
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }

        // 서로 다른 부분 문자열의 개수 출력
        System.out.println(substrings.size());
    }
}
