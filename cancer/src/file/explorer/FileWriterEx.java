package file.explorer;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterEx {

	public static void main(String[] args) {
		byte b [] = {7,51,3,4,-1,24};
		try {
			FileOutputStream fout = new FileOutputStream("c:/Temp/test.out");
			for(int i = 0;i<b.length;i++) {
				fout.write(b[i]);
			}
			fout.close();
		}catch (IOException e) {
			System.out.println("오류");
			return;
		}
		System.out.println("성공");

	}

}
