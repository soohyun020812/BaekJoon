package _13;
import java.io.*;
import java.util.*;

// 나이순 정렬
public class Main10814 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 : 회원 수 N
        int n = Integer.parseInt(br.readLine());
        
        // 회원 정보를 저장할 리스트
        List<Member> members = new ArrayList<>();
        
        // N개의 줄에 걸쳐 나이와 이름을 입력받아 리스트에 추가
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            members.add(new Member(age, name));
        }
        
        // 나이 순, 나이가 같으면 가입 순서대로 정렬
        members.sort(new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
            	// 나이 순으로 오름차순 정렬
            	return m1.age - m2.age; 
            }
        });
        
        // 정렬된 회원 목록 출력
        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    // Member 클래스 : 나이와 이름을 저장하는 클래스
    static class Member {
        int age;
        String name;
        
        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
