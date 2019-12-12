package file.explorer;
import java.io.*;
public class BlockBinaryCopyEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File src = new File("C:\\Users\\dreg5\\Downloads\\0A367796-0BB2-48F3-AF34-E672A72669C0.jpg");
		File dest = new File ("C:\\Users\\dreg5\\Desktop\\test.jpg");
		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte [] buf = new byte [1024*10];
			while(true) {
				int n = fi.read(buf);
				fo.write(buf, 0, n);
				if(n<buf.length) {
					break;
				}
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath()+"를"+dest.getPath()+"로 복사함");
		} catch(IOException e) {
			System.out.println("실패");
		}
	}

}
