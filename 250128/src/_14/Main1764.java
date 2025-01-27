package _14;
import java.io.*;
import java.util.*;

// 1764 듣보잡
public class Main1764 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 번째 줄 : 듣도 못한 사람 수 (N)과 보도 못한 사람 수 (M)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람 명단 저장 (Set)
        Set<String> unheard = new HashSet<>();
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        // 듣보잡 명단 찾기
        List<String> unheardUnseen = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {
                unheardUnseen.add(name);
            }
        }

        // 사전순 정렬
        Collections.sort(unheardUnseen);

        sb.append(unheardUnseen.size()).append("\n");
        for (String name : unheardUnseen) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}
