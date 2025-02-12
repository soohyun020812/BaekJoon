package implementation;
import java.io.*;
import java.util.*;

// 1138 한 줄로 서기
public class Main1138 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 사람의 수
        int N = Integer.parseInt(br.readLine()); 
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        // 줄을 설 배열 (초기값 0)
        int[] result = new int[N]; 

        // 키가 1인 사람부터 N까지 차례대로 배치
        for (int i = 0; i < N; i++) {
        	// 왼쪽에 있어야 하는 큰 사람 수
        	int count = arr[i]; 
        	// 삽입할 위치
        	int position = 0; 

            // count만큼 빈자리 지나치기
            for (int j = 0; j < N; j++) {
            	// 빈 자리일 경우
            	if (result[j] == 0) { 
                    if (count == 0) {
                    	// 올바른 위치를 찾음
                    	position = j; 
                        break;
                    }
                    // 지나친 빈 자리 수 감소
                    count--; 
                }
            }
            // 키 (1~N) 삽입
            result[position] = i + 1; 
        }

        for (int num : result) {
        	System.out.print(num + " ");
        }
    }
}
