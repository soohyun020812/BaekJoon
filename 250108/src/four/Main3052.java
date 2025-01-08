package four;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// HashSet : 중복된 값을 자동으로 제거하는 특성을 지님
import java.util.HashSet;

// 3052 나머지
public class Main3052 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 나머지 값을 저장할 HashSet 생성
        HashSet<Integer> remainderSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine()); 
            // 42로 나눈 나머지를 HashSet에 추가
            remainderSet.add(num % 42); 
        }

        System.out.println(remainderSet.size());
    }
}
