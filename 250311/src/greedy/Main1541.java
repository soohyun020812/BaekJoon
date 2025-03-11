package greedy;
import java.io.*;

// 1541 잃어버린 괄호 
public class Main1541 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // '-' 기준으로 분리
        String[] subGroups = br.readLine().split("-"); 

        // 첫 번째 그룹은 그대로 사용
        int result = sum(subGroups[0]); 
        for (int i = 1; i < subGroups.length; i++) {
        	// 이후 그룹들은 모두 빼기
        	result -= sum(subGroups[i]); 
        }

        System.out.println(result);
    }

    private static int sum(String expr) {
    	// '+' 기준으로 분리
        String[] numbers = expr.split("\\+"); 
        int total = 0;
        for (String num : numbers) {
            total += Integer.parseInt(num);
        }
        
        return total;
    }
}
