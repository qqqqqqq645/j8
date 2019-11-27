package ch08.riview;
import java.util.Scanner;
import java.io.*;
public class Ex8mon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		FileWriter filewriter = null;
		int c;
		try {
			filewriter = new FileWriter("c:\\Users\\313\\desktop\\phone.txt");
			System.out.println("전화번호 입력 프로그램입니다.");
			
			
			while(true) {
				System.out.print("이름 전화번호 >> ");
				String asdf = scanner.nextLine();
				if(asdf.equals("그만")) {
					break;
				}
				filewriter.write(asdf,0,asdf.length());
				filewriter.write("\r\n",0,2);
			}
			filewriter.close();
		} catch(IOException e) {
			System.out.println("입출력 오류");
		}
		scanner.close();
	}

}
