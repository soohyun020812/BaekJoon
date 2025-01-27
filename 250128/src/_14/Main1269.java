package _14;
import java.io.*;
import java.util.*;

// 1269 대칭 차집합
public class Main1269 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집합 A와 B의 원소 개수
        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        // 집합 A 입력
        Set<Integer> setA = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeA; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        // 집합 B 입력 및 대칭 차집합 계산
        Set<Integer> setB = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeB; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (setA.contains(num)) {
            	// 공통 원소 제거
            	setA.remove(num); 
            } else {
            	// B에만 있는 원소 추가
                setB.add(num); 
            }
        }

        // 대칭 차집합의 원소 개수 : setA와 setB의 원소 개수 합
        System.out.println(setA.size() + setB.size());
    }
}
