package file.explorer;


import java.io.File;
import java.util.ArrayList;

public class FileExplor {
	ArrayList files = new ArrayList<>();
    public FileExplor(){
   
    }

    public void searchAllFile(File fileList){
        File[] list = fileList.listFiles();

        if(list==null)
            return;
        for(File file : list){
        	System.out.println(file.getName());
            if(file.isDirectory()){      // 폴더인가?
                // ... 폴더 일때 할일
            	searchAllFile(file);
            	//file.c
            }
            // Example : zip 파일을 찾을때
            if(file.getName().endsWith(".zip")){
                // ... zip 파일일때 할일
            	files.add(file.getName());
            }
        }
    }
    public void getFiles() {
    	for(int i=0;i<files.size();i++) {
    		System.out.println((String)files.get(i));

    	}
    }
    
    public static void main(String [] args) {
    	FileExplor a = new FileExplor();
    	//a.searchAllFile("");
    	File cDrive = new File("c:\\");
    	System.out.println(cDrive.getPath());
    	a.searchAllFile(cDrive);
    	System.out.println("이제getFile시작");
    	a.getFiles();
    }
}
