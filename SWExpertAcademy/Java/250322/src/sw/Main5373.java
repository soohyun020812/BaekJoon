package sw;
import java.io.*;
import java.util.*;

public class Main5373 {
    static int tc; 
    // 큐브의 각 면 상태를 저장할 배열 (55개 크기)
    static char[] cube = new char[55]; 

    // 큐브 초기화 : 각 면의 색상 설정
    static void color() {
        // 큐브 색상 순서 : 'w' -> 'r' -> 'g' -> 'o' -> 'b' -> 'y'
        char[] colorArr = new char[]{'w', 'r', 'g', 'o', 'b', 'y'};
        // 6개의 면에 대해
        for (int i = 0; i < 6; i++) 
            // 각 면의 9개의 칸에 색을 지정
            for (int j = 1; j <= 9; j++) 
                cube[i * 9 + j] = colorArr[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine()); 
        StringBuilder sb = new StringBuilder(); 

        // 각 테스트 케이스 처리
        for (int i = 0; i < tc; i++) {
            // 큐브 초기화
            color(); 
            // 회전 명령의 수
            int n = Integer.parseInt(br.readLine()); 
            // 명령 입력
            StringTokenizer st = new StringTokenizer(br.readLine()); 

            while (st.hasMoreTokens()) {
                // 각 회전 명령 (예 : "U+" 또는 "D-")
                String str = st.nextToken(); 
                // 방향 (U, D, F, B, L, R)
                char dir = str.charAt(0); 
                // 시계방향(+) 또는 반시계방향(-)
                char clock = str.charAt(1); 
                // 반시계방향은 3번 회전 (90도 * 3)
                int cnt = (clock == '-') ? 3 : 1; 

                // 방향에 따른 회전 함수 호출
                for (int j = 0; j < cnt; j++) {
                    switch (dir) {
                        // 위 면 회전
                        case 'U': U(); break; 
                        // 아래 면 회전
                        case 'D': D(); break; 
                        // 앞 면 회전
                        case 'F': F(); break; 
                        // 뒤 면 회전
                        case 'B': B(); break; 
                        // 왼쪽 면 회전
                        case 'L': L(); break; 
                        // 오른쪽 면 회전
                        case 'R': R(); break; 
                    }
                }
            }

            // 큐브 상태 출력 (윗면만 출력)
            for (int j = 1; j <= 9; j++) {
                sb.append(cube[j]);
                // 3칸마다 줄 바꿈
                if (j % 3 == 0) sb.append('\n'); 
            }
        }

        System.out.println(sb);
    }

    // 각 면을 시계방향으로 90도 회전하는 함수들
    static void U() {
        char[] tmp = new char[21];
        // 윗면 회전 후 상태 저장
        tmp[0] = cube[34]; tmp[1] = cube[35]; tmp[2] = cube[36];
        tmp[3] = cube[21]; tmp[4] = cube[1]; tmp[5] = cube[2]; tmp[6] = cube[3]; tmp[7] = cube[37];
        tmp[8] = cube[24]; tmp[9] = cube[4]; tmp[10] = cube[5]; tmp[11] = cube[6]; tmp[12] = cube[40];
        tmp[13] = cube[27]; tmp[14] = cube[7]; tmp[15] = cube[8]; tmp[16] = cube[9]; tmp[17] = cube[43];
        tmp[18] = cube[10]; tmp[19] = cube[11]; tmp[20] = cube[12];

        // 회전된 상태로 큐브 업데이트
        cube[37] = tmp[0]; cube[40] = tmp[1]; cube[43] = tmp[2];
        cube[36] = tmp[3]; cube[3] = tmp[4]; cube[6] = tmp[5]; cube[9] = tmp[6]; cube[12] = tmp[7];
        cube[35] = tmp[8]; cube[2] = tmp[9]; cube[8] = tmp[11]; cube[11] = tmp[12];
        cube[34] = tmp[13]; cube[1] = tmp[14]; cube[4] = tmp[15]; cube[7] = tmp[16]; cube[10] = tmp[17];
        cube[21] = tmp[18]; cube[24] = tmp[19]; cube[27] = tmp[20];
    }

    static void D() {
        char[] tmp = new char[21];
        // 아래 면 회전 후 상태 저장
        tmp[0] = cube[30]; tmp[1] = cube[29]; tmp[2] = cube[28];
        tmp[3] = cube[39]; tmp[4] = cube[46]; tmp[5] = cube[47]; tmp[6] = cube[48]; tmp[7] = cube[19];
        tmp[8] = cube[42]; tmp[9] = cube[49]; tmp[10] = cube[50]; tmp[11] = cube[51]; tmp[12] = cube[22];
        tmp[13] = cube[45]; tmp[14] = cube[52]; tmp[15] = cube[53]; tmp[16] = cube[54]; tmp[17] = cube[25];
        tmp[18] = cube[18]; tmp[19] = cube[17]; tmp[20] = cube[16];

        // 회전된 상태로 큐브 업데이트
        cube[19] = tmp[0]; cube[22] = tmp[1]; cube[25] = tmp[2];
        cube[28] = tmp[3]; cube[48] = tmp[4]; cube[51] = tmp[5]; cube[54] = tmp[6]; cube[16] = tmp[7];
        cube[29] = tmp[8]; cube[47] = tmp[9]; cube[53] = tmp[11]; cube[17] = tmp[12];
        cube[30] = tmp[13]; cube[46] = tmp[14]; cube[49] = tmp[15]; cube[52] = tmp[16]; cube[18] = tmp[17];
        cube[39] = tmp[18]; cube[42] = tmp[19]; cube[45] = tmp[20];
    }

    static void F() {
        char[] tmp = new char[21];
        // 앞 면 회전 후 상태 저장
        tmp[0] = cube[7]; tmp[1] = cube[8]; tmp[2] = cube[9];
        tmp[3] = cube[27]; tmp[4] = cube[10]; tmp[5] = cube[11]; tmp[6] = cube[12]; tmp[7] = cube[43];
        tmp[8] = cube[26]; tmp[9] = cube[13]; tmp[10] = cube[14]; tmp[11] = cube[15]; tmp[12] = cube[44];
        tmp[13] = cube[25]; tmp[14] = cube[16]; tmp[15] = cube[17]; tmp[16] = cube[18]; tmp[17] = cube[45];
        tmp[18] = cube[54]; tmp[19] = cube[53]; tmp[20] = cube[52];

        // 회전된 상태로 큐브 업데이트
        cube[43] = tmp[0]; cube[44] = tmp[1]; cube[45] = tmp[2];
        cube[9] = tmp[3]; cube[12] = tmp[4]; cube[15] = tmp[5]; cube[18] = tmp[6]; cube[52] = tmp[7];
        cube[8] = tmp[8]; cube[11] = tmp[9]; cube[17] = tmp[11]; cube[53] = tmp[12];
        cube[7] = tmp[13]; cube[10] = tmp[14]; cube[13] = tmp[15]; cube[16] = tmp[16]; cube[54] = tmp[17];
        cube[27] = tmp[18]; cube[26] = tmp[19]; cube[25] = tmp[20];
    }

    static void B() {
        char[] tmp = new char[21];
        // 뒤 면 회전 후 상태 저장
        tmp[0] = cube[48]; tmp[1] = cube[47]; tmp[2] = cube[46];
        tmp[3] = cube[19]; tmp[4] = cube[28]; tmp[5] = cube[29]; tmp[6] = cube[30]; tmp[7] = cube[39];
        tmp[8] = cube[20]; tmp[9] = cube[31]; tmp[10] = cube[32]; tmp[11] = cube[33]; tmp[12] = cube[38];
        tmp[13] = cube[21]; tmp[14] = cube[34]; tmp[15] = cube[35]; tmp[16] = cube[36]; tmp[17] = cube[37];
        tmp[18] = cube[1]; tmp[19] = cube[2]; tmp[20] = cube[3];

        // 회전된 상태로 큐브 업데이트
        cube[39] = tmp[0]; cube[38] = tmp[1]; cube[37] = tmp[2];
        cube[46] = tmp[3]; cube[30] = tmp[4]; cube[33] = tmp[5]; cube[36] = tmp[6]; cube[3] = tmp[7];
        cube[47] = tmp[8]; cube[29] = tmp[9]; cube[35] = tmp[11]; cube[2] = tmp[12];
        cube[48] = tmp[13]; cube[28] = tmp[14]; cube[31] = tmp[15]; cube[34] = tmp[16]; cube[1] = tmp[17];
        cube[19] = tmp[18]; cube[20] = tmp[19]; cube[21] = tmp[20];
    }

    static void L() {
        char[] tmp = new char[21];
        // 왼쪽 면 회전 후 상태 저장
        tmp[0] = cube[28]; tmp[1] = cube[31]; tmp[2] = cube[34];
        tmp[3] = cube[48]; tmp[4] = cube[19]; tmp[5] = cube[20]; tmp[6] = cube[21]; tmp[7] = cube[1];
        tmp[8] = cube[51]; tmp[9] = cube[22]; tmp[10] = cube[23]; tmp[11] = cube[24]; tmp[12] = cube[4];
        tmp[13] = cube[54]; tmp[14] = cube[25]; tmp[15] = cube[26]; tmp[16] = cube[27]; tmp[17] = cube[7];
        tmp[18] = cube[16]; tmp[19] = cube[13]; tmp[20] = cube[10];

        // 회전된 상태로 큐브 업데이트
        cube[1] = tmp[0]; cube[4] = tmp[1]; cube[7] = tmp[2];
        cube[34] = tmp[3]; cube[21] = tmp[4]; cube[24] = tmp[5]; cube[27] = tmp[6]; cube[10] = tmp[7];
        cube[31] = tmp[8]; cube[20] = tmp[9]; cube[26] = tmp[11]; cube[13] = tmp[12];
        cube[28] = tmp[13]; cube[19] = tmp[14]; cube[22] = tmp[15]; cube[25] = tmp[16]; cube[16] = tmp[17];
        cube[48] = tmp[18]; cube[51] = tmp[19]; cube[54] = tmp[20];
    }

    static void R() {
        char[] tmp = new char[21];
        // 오른쪽 면 회전 후 상태 저장
        tmp[0] = cube[36]; tmp[1] = cube[33]; tmp[2] = cube[30];
        tmp[3] = cube[3]; tmp[4] = cube[37]; tmp[5] = cube[38]; tmp[6] = cube[39]; tmp[7] = cube[46];
        tmp[8] = cube[6]; tmp[9] = cube[40]; tmp[10] = cube[41]; tmp[11] = cube[42]; tmp[12] = cube[49];
        tmp[13] = cube[9]; tmp[14] = cube[43]; tmp[15] = cube[44]; tmp[16] = cube[45]; tmp[17] = cube[52];
        tmp[18] = cube[12]; tmp[19] = cube[15]; tmp[20] = cube[18];

        // 회전된 상태로 큐브 업데이트
        cube[46] = tmp[0]; cube[49] = tmp[1]; cube[52] = tmp[2];
        cube[30] = tmp[3]; cube[39] = tmp[4]; cube[42] = tmp[5]; cube[45] = tmp[6]; cube[18] = tmp[7];
        cube[33] = tmp[8]; cube[38] = tmp[9]; cube[44] = tmp[11]; cube[15] = tmp[12];
        cube[36] = tmp[13]; cube[37] = tmp[14]; cube[40] = tmp[15]; cube[43] = tmp[16]; cube[12] = tmp[17];
        cube[3] = tmp[18]; cube[6] = tmp[19]; cube[9] = tmp[20];
    }
}

// 다시 풀어볼 것, 다른 사람 코드 사용
