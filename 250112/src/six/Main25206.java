package six;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 25206 너의 평점은
public class Main25206 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 등급-평점 매핑
        Map<String, Double> gradeToPoint = new HashMap<>();
        gradeToPoint.put("A+", 4.5);
        gradeToPoint.put("A0", 4.0);
        gradeToPoint.put("B+", 3.5);
        gradeToPoint.put("B0", 3.0);
        gradeToPoint.put("C+", 2.5);
        gradeToPoint.put("C0", 2.0);
        gradeToPoint.put("D+", 1.5);
        gradeToPoint.put("D0", 1.0);
        gradeToPoint.put("F", 0.0);

        // (학점 × 과목평점)의 합
        double totalPoints = 0.0; 
        // 총 학점
        double totalCredits = 0.0; 

        for (int i = 0; i < 20; i++) {
            String[] input = br.readLine().split(" ");
            // 등급
            String grade = input[2]; 
            // 학점
            double credit = Double.parseDouble(input[1]); 

            // P는 계산에서 제외
            if (!grade.equals("P")) { 
            	// 총 학점에 더함
            	totalCredits += credit; 
            	// 학점 × 과목평점
                totalPoints += credit * gradeToPoint.get(grade); 
            }
        }

        // 전공평점 계산 및 출력
        double majorGPA = totalPoints / totalCredits;
        System.out.printf("%.6f\n", majorGPA);
    }
}
