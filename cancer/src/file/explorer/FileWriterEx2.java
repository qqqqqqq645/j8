package file.explorer;

import java.io.*;
import java.io.IOException;

public class FileWriterEx2 {

	public static void main(String[] args) {
		//byte b [] = {7,51,3,4,-1,24};
		String str;
		java.util.Scanner scan = new java.util.Scanner(System.in);
		str = scan.nextLine();
		try {
			//FileOutputStream fout = new FileOutputStream("c:/Temp/test.out");
			FileWriter fout = new FileWriter("c:/Temp/test2.txt",true);
			fout.write(str);
			fout.close();
			scan.close();
		}catch (IOException e) {
			System.out.println("오류");
			return;
		}
		System.out.println("성공");

	}

}
