package six;

// 25083 새싹
public class Main25083 {
	public static void main(String[] args) {
		String s = "         ,r'\"7\n" +
				"r`-_   ,'  ,/\n" + 
				" \\. \". L_r'\n" +
				"   `~\\/\n" + 
				"      |\n" + 	
				"      |";
		
		/*
		 * \", \n 이 제어문자
		 * \n 이 제어문자
		 * \\, \", \n 이 제어문자
		 * \\, \n 이 제어문자
		 * \n 이 제어문자
		 */

		System.out.print(s);
	}
}
