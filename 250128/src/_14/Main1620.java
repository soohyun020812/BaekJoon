package _14;
import java.io.*;
import java.util.*;

// 1620 나는야 포켓몬 마스터 이다솜
public class Main1620 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 포켓몬의 개수 N, 문제의 개수 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 번호 → 이름 매핑
        ArrayList<String> pokemonList = new ArrayList<>(N + 1);
        // 1-based indexing 사용
        pokemonList.add(""); 

        // 이름 → 번호 매핑
        Map<String, Integer> pokemonMap = new HashMap<>();

        // 포켓몬 입력 처리
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            // 번호 → 이름
            pokemonList.add(name); 
            // 이름 → 번호
            pokemonMap.put(name, i); 
        }

        // 문제 처리
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            // 숫자라면 번호 → 이름 출력
            if (Character.isDigit(query.charAt(0))) {
                int number = Integer.parseInt(query);
                sb.append(pokemonList.get(number)).append("\n");
            }
            // 문자라면 이름 → 번호 출력
            else {
                sb.append(pokemonMap.get(query)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
