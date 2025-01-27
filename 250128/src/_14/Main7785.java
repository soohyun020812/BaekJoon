package _14;
import java.io.*;
import java.util.*;

// 7785 회사에 있는 사람
public class Main7785 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 번째 줄 : 로그의 수 n
        int n = Integer.parseInt(br.readLine());

        // 출입 기록을 처리할 HashSet
        Set<String> people = new HashSet<>();

        // 로그 처리
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter")) {
            	// 출근 기록
            	people.add(name); 
            } else if (action.equals("leave")) {
            	// 퇴근 기록
            	people.remove(name); 
            }
        }

        // 현재 회사에 있는 사람을 리스트로 변환
        List<String> currentPeople = new ArrayList<>(people);
        
        // 사전 역순으로 정렬
        currentPeople.sort(Collections.reverseOrder());

        for (String name : currentPeople) {
            sb.append(name).append("\n");
        }

        System.out.println(sb.toString());
    }
}
