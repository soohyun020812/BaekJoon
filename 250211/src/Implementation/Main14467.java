package Implementation;
import java.io.*;
import java.util.*;

// 14467 소가 길을 건너간 이유 
public class Main14467 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    // 관찰 횟수 N
	    int N = Integer.parseInt(br.readLine());
	    
	    // 각 소의 마지막 위치를 저장하기 위한 배열 (소 번호는 1~10번)
	    int[][] arr = new int[11][1];
	    
	    // 소가 길을 건넌 횟수 카운트
	    int count = 0;

	    // 모든 소의 위치를 -1로 초기화 (소들의 첫 번째 위치를 설정하기 전)
	    for (int i = 1; i < 11; i++) {
	    	// 첫 관찰 전 위치는 설정되지 않았으므로 -1로 설정
	    	arr[i][0] = -1; 
	    }

	    // 관찰 결과 처리
	    StringTokenizer st;
	    for (int i = 0; i < N; i++) {
	        // 각 관찰에서 소 번호와 위치를 읽음
	        st = new StringTokenizer(br.readLine(), " ");
	        // 소 번호
	        int a = Integer.parseInt(st.nextToken());
	        // 소의 위치 (0 또는 1)
	        int b = Integer.parseInt(st.nextToken()); 

	        // 처음으로 해당 소를 관찰하는 경우
	        if (arr[a][0] == -1) {
	        	// 해당 소의 위치를 기록
	        	arr[a][0] = b; 
	        } else {
	            // 이미 관찰된 소의 위치가 이전과 다르면 길을 건넌 것으로 판단
	            if (arr[a][0] != b) {
	            	// 길을 건넌 횟수 증가
	            	count++; 
	            	// 소의 위치를 갱신
	                arr[a][0] = b; 
	            }
	        }
	    }

	    System.out.println(count);
	}
}
