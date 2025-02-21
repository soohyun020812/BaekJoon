package data_structure;
import java.io.*;
import java.util.*;

// 2800 괄호 제거 
public class Main2800 {
	// 입력받은 수식을 저장할 변수
	static String expression;
	// 괄호 쌍의 위치를 저장할 리스트
	static List<int[]> brackets = new ArrayList<>();
    // 중복을 방지하고 사전 순 정렬을 위한 TreeSet 사용
    static Set<String> results = new TreeSet<>(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expression = br.readLine();

        // 여는 괄호 '(' 의 위치를 저장할 스택
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
            	// 여는 괄호 '(' 위치 저장            	
                stack.push(i);
            } else if (ch == ')') {
            	// 닫는 괄호 ')'을 만나면 짝을 지어 리스트에 저장
                brackets.add(new int[]{stack.pop(), i}); 
            }
        }

        // 모든 괄호 조합 생성
        generateExpressions(0, new boolean[brackets.size()]);

        // TreeSet을 사용해 자동 정렬됨
        for (String res : results) {
            System.out.println(res);
        }
    }

    /*
 	* 백트래킹을 이용하여 괄호를 제거하는 모든 경우의 수를 탐색
	* @param index : 현재 탐색 중인 괄호 쌍의 인덱스
	* @param remove : 어떤 괄호를 제거할 것인지 저장하는 배열
	* true: 제거, false: 유지
	*/
    
    private static void generateExpressions(int index, boolean[] remove) {
        if (index == brackets.size()) {
        	// 적어도 하나의 괄호를 제거했는지 확인
            boolean hasRemoved = false;
            for (boolean b : remove) {
                if (b) {
                    hasRemoved = true;
                    break;
                }
            }
            // 하나도 제거하지 않았다면 결과 저장하지 않음
            if (!hasRemoved) return;

            // 새로운 수식 만들기
            StringBuilder sb = new StringBuilder();
            Set<Integer> removeIndexes = new HashSet<>();

            for (int i = 0; i < brackets.size(); i++) {
                if (remove[i]) {
                	// '(' 제거
                    removeIndexes.add(brackets.get(i)[0]); 
                    // ')' 제거
                    removeIndexes.add(brackets.get(i)[1]); 
                }
            }

            for (int i = 0; i < expression.length(); i++) {
                if (!removeIndexes.contains(i)) {
                    sb.append(expression.charAt(i));
                }
            }

            results.add(sb.toString());
            return;
        }

        // 현재 괄호 쌍을 제거하지 않는 경우
        generateExpressions(index + 1, remove);

        // 현재 괄호 쌍을 제거하는 경우
        remove[index] = true;
        generateExpressions(index + 1, remove);
        // 백트래킹 
        remove[index] = false;
    }
}
