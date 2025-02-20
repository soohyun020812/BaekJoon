package data_structure;
import java.io.*;
import java.util.*;

// 2304 창고 다각형 
public class Main2304 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Column[] columns = new Column[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            columns[i] = new Column(location, height);
        }

        // 1 기둥들을 위치(location) 기준으로 정렬
        Arrays.sort(columns);

        // 2 가장 높은 기둥 찾기 (Pivot)
        int pivotIndex = 0;
        for (int i = 1; i < n; i++) {
            if (columns[i].height > columns[pivotIndex].height) {
                pivotIndex = i;
            }
        }

        int area = 0;

        // 3 왼쪽에서 pivot까지 탐색
        int leftMaxIndex = 0;
        for (int i = 0; i <= pivotIndex; i++) {
            if (columns[i].height >= columns[leftMaxIndex].height) {
                area += (columns[i].location - columns[leftMaxIndex].location) * columns[leftMaxIndex].height;
                leftMaxIndex = i;
            }
        }

        // 4 오른쪽에서 pivot까지 탐색
        int rightMaxIndex = n - 1;
        for (int i = n - 1; i >= pivotIndex; i--) {
            if (columns[i].height >= columns[rightMaxIndex].height) {
                area += (columns[rightMaxIndex].location - columns[i].location) * columns[rightMaxIndex].height;
                rightMaxIndex = i;
            }
        }

        // 5 pivot 기둥의 넓이 추가
        area += columns[pivotIndex].height;

        System.out.println(area);
    }
}

// Column : 기둥의 위치(location)와 높이(height)를 저장하는 클래스
// Comparable 인터페이스를 구현하여 정렬 기준을 정의
class Column implements Comparable<Column> {
	// 기둥의 위치 (x 좌표)
    int location;
    // 기둥의 높이 (y 값)
    int height;

    // 생성자 : 기둥의 위치와 높이를 최소화
    public Column(int location, int height) {
        this.location = location;
        this.height = height;
    }

    // compareTo : 정렬 기준을 설정 (위치를 기준으로 오름차순 정렬)
    @Override
    public int compareTo(Column o) {
        return Integer.compare(this.location, o.location);
    }
}
