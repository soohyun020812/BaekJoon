package _13;
import java.io.*;
import java.util.*;

// 18870 좌표 압축
public class Main18870 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 : N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 줄 : 좌표들 입력받기
        String[] input = br.readLine().split(" ");
        
        // 좌표들을 정수 배열로 변환
        int[] X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(input[i]);
        }
        
        // 중복 제거 후 정렬하기 위해 Set을 사용
        Set<Integer> sortedSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            sortedSet.add(X[i]);
        }
        
        // 좌표 압축을 위한 맵
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        
        // 정렬된 Set에 대해 순위를 매김
        for (int value : sortedSet) {
            rankMap.put(value, rank++);
        }
        
        // 원래 입력 순서대로 순위를 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rankMap.get(X[i])).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}
