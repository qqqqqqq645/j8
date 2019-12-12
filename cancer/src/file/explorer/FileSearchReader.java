package file.explorer;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileSearchReader {
    ArrayList files;
    String testString;
    public FileSearchReader(){
        /*try {
            FileInputStream fread = new FileInputStream("src\\file\\explorer\\log");
            InputStreamReader in = new InputStreamReader(fread, "UTF-8");
            StringBuffer temp = new StringBuffer(fread.available());
            int c;
            while((c=fread.read())!=-1){
                temp.append((char) c);
            }
            System.out.println(temp);
            testString = temp.toString();
            fread.close();
            in.close();
        } catch(IOException e) {
            System.out.print("err");
        }*/
        
    
    }

public String [] frac (){
	try {
		return testString.split("\n");
	} catch(NullPointerException e) {
		return null;
	}
	
}
	
    public static void main(String args[]) {
    	FileSearchReader aa = new FileSearchReader();
    	System.out.println(aa.testString);
    	String [] testss = aa.frac();
    	System.out.println("여기부터");
    	for(int i=0;i<testss.length;i++)
    	System.out.print(testss[i]);
    }
}
