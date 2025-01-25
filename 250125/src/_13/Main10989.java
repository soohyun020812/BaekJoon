package _13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 10989 수 정렬하기 3
public class Main10989 {
	public static void main(String[] args) throws IOException {
        // 수의 범위 (0 ~ 10000) 사실상 0은 제외하고 1부터 10000까지 사용
        int[] cnt = new int[10001];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 숫자의 개수 N을 입력 받음
        int N = Integer.parseInt(reader.readLine());

        // 숫자 입력받아서 cnt 배열에 해당 숫자의 빈도수를 기록
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            // 입력받은 숫자를 카운팅
            cnt[Integer.parseInt(reader.readLine())]++;
        }

        // 입력을 마친 후 BufferedReader를 닫음
        reader.close();

        // 출력 버퍼를 사용하여 문자열을 빠르게 연결
        StringBuilder resultBuilder = new StringBuilder();

        // 1부터 10000까지 순차적으로 확인
        for (int i = 1; i < 10001; i++) {
            // cnt[i]의 값이 0이 아니면 그 숫자를 출력
            // 해당 숫자의 빈도수만큼 출력
            while (cnt[i]-- > 0) {
            	resultBuilder.append(i).append('\n');
            }
        }

        // 최종적으로 StringBuilder에 저장된 결과를 출력
        System.out.print(resultBuilder);
    }
}
