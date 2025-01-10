package five;
import java.io.IOException;

// 5622 다이얼
public class Main5622 {
	public static void main(String[] args) throws IOException {
		// 총 소요 시간을 저장할 변수
		int count = 0; 
		 // 입력받은 문자의 ASCII 값을 저장할 변수
        int value; 

        while (true) {
        	// 문자를 한 글자씩 읽음 (ASCII 값)
            value = System.in.read();

            if (value == '\n') { 
                break;
            }

            // 다이얼 번호에 따라 소요 시간을 계산
            if (value < 68) count += 3;
            else if (value < 71) count += 4; 
            else if (value < 74) count += 5; 
            else if (value < 77) count += 6; 
            else if (value < 80) count += 7; 
            else if (value < 84) count += 8; 
            else if (value < 87) count += 9; 
            else count += 10; 
             /*
              	'ABC' → 2 → 3초
         	    'DEF' → 3 → 4초
             	'GHI' → 4 → 5초
             	'JKL' → 5 → 6초
             	'MNO' → 6 → 7초
             	'PQRS' → 7 → 8초
             	'TUV' → 8 → 9초
             	'WXYZ' → 9 → 10초
              */
        }

        // 총 소요 시간 출력
        System.out.print(count); 
    }
}
