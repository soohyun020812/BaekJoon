package greedy;
import java.io.*;

// 21314 민겸 수 
public class Main21314 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder maxNum = new StringBuilder();
        StringBuilder minNum = new StringBuilder();

        // 최대값 계산
        int mCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'M') {
                mCount++;
            // 'K'가 나왔을 때
            } else { 
                if (mCount > 0) {
                    // M을 전부 "1" + "0...(mCount-1개)"로 변환
                    maxNum.append("5");
                    maxNum.append("0".repeat(mCount));
                    mCount = 0;
                } else {
                    maxNum.append("5");
                }
            }
        }
        if (mCount > 0) {
            // 남은 M이 있다면 "111..." 형태로 변환
            maxNum.append("1".repeat(mCount));
        }

        // 최소값 계산
        mCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'M') {
                mCount++;
            // 'K'가 나왔을 때
            } else { 
                if (mCount > 0) {
                    minNum.append("1");
                    minNum.append("0".repeat(mCount - 1));
                    mCount = 0;
                }
                minNum.append("5");
            }
        }
        if (mCount > 0) {
            minNum.append("1");
            minNum.append("0".repeat(mCount - 1));
        }

        System.out.println(maxNum);
        System.out.println(minNum);
    }
}
