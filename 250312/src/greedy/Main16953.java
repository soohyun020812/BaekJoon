package greedy;
import java.io.*;
import java.util.*;

// 16953 A → B
public class Main16953 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int count = 1;
        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break;
            }
            count++;
        }
        
        System.out.println(B == A ? count : -1);
    }
}
