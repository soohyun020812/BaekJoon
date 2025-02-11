package Implementation;
import java.io.*;
import java.util.*;

// 🐜 기적의 매매법 🐜
public class Main20546 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 자본
        int cash = Integer.parseInt(br.readLine());

        // 14일 동안의 주가
        int[] prices = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        // BNP 전략 수행
        int jCash = cash;
        int jStock = 0;
        for (int i = 0; i < 14; i++) {
            if (jCash >= prices[i]) {
            	// 최대한 살 수 있는 개수
                int buy = jCash / prices[i]; 
                jStock += buy;
                // 매수 후 남은 현금
                jCash -= buy * prices[i]; 
            }
        }
        // 최종 자산
        int jAsset = jCash + jStock * prices[13]; 

        // TIMING 전략 수행
        int sCash = cash;
        int sStock = 0;
        for (int i = 3; i < 14; i++) {
            // 3일 연속 하락 시 매수
            if (prices[i - 3] > prices[i - 2] && prices[i - 2] > prices[i - 1] && sCash >= prices[i]) {
                int buy = sCash / prices[i];
                sStock += buy;
                sCash -= buy * prices[i];
            }
            // 3일 연속 상승 시 매도
            else if (prices[i - 3] < prices[i - 2] && prices[i - 2] < prices[i - 1] && sStock > 0) {
                sCash += sStock * prices[i];
                sStock = 0;
            }
        }
        // 최종 자산
        int sAsset = sCash + sStock * prices[13]; 

        if (jAsset > sAsset) {
            System.out.println("BNP");
        } else if (jAsset < sAsset) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}
