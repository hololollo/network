package exam2;

import java.io.FileOutputStream;
import java.io.IOException;

public class Exam2_1 {
	public static void main(String[] args) {
		output1();
	}
	public static void output1() {
		try {
			FileOutputStream fos = null;
			fos = new FileOutputStream("test2.txt");
			String str = "점심뭐먹어?";
			byte[] utf8Bytes = str.getBytes("UTF-8"); // UTF-8로 인코딩된 바이트 배열 생성
			for(int i = 0; i < utf8Bytes.length; i++) {
				// fos.write(str.charAt(i));
				fos.write(utf8Bytes[i]); // 파일에 각 바이트 쓰기
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

/*
FileOutputStream은 파일을 열고 쓰기 작업을 수행하는 객체입니다. 파일을 열고 작업을 마친 후에는 파일을 닫아야 합니다. 
파일을 닫지 않으면 파일 핸들이 여전히 열려 있게 되어 다른 프로세스에서 해당 파일을 사용할 수 없게 될 수 있습니다. 따라서 파일을 다 사용한 후에는 파일 핸들을 닫아야 합니다.
코드가 현재 예외가 발생하지 않는다고 해서 항상 그렇다고 가정해서는 안 됩니다. 
만약 나중에 코드가 변경되어 예외가 발생하게 되면 finally 블록이 없으면 리소스가 제대로 해제되지 않을 수 있습니다.
*/
