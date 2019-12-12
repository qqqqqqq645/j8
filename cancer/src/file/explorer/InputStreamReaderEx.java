package file.explorer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {

	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		String s = "";
		try {
			fin = new FileInputStream("C:\\Users\\dreg5\\Desktop\\abcd.txt");
			in = new InputStreamReader(fin,"utf8");
			
			int c;
			System.out.println("인코딩 문자 집합 : "+in.getEncoding());
			while((c = in.read())!=-1) {
				System.out.print((char)c);
				s+=(char)c;
				
			}
			System.out.print(s);
			in.close();
			fin.close();
		} catch(IOException e) {
			System.out.println("오류");
			}

	}

}
