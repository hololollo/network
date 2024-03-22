package exam1;

import java.io.FileWriter;
import java.io.IOException;

public class Comp1 {
	public static void main(String[] args) {
		output1();
	}
	public static void output1() {
		FileWriter fos = null;
		try {
			fos = new FileWriter("test9.txt");
			String str = "안녕하세요!";
			fos.write(str);
			// for(int i = 0; i < str.length(); i++) {
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
/*
 charAt 메서드는 문자열에서 특정 인덱스에 해당하는 문자를 읽어옵니다. 이것은 문자열을 문자 단위로 처리하는 것입니다. 반면에 FileWriter는 파일에 문자열을 쓰는 데 사용되며, 이것은 데이터를 바이트 단위로 처리합니다.

따라서 charAt과 FileWriter를 함께 사용하여 문자열을 파일에 출력하면 각 문자가 개별적으로 파일에 쓰여집니다. 이것은 문자열을 문자 단위로 파일에 출력하는 것입니다. 한편, 바이트 단위로 파일에 출력하는 경우에는 문자열이 바이트로 변환되어 파일에 쓰여집니다.

문자 단위로 파일에 출력하는 경우에는 문자의 인코딩 방식에 따라 파일에 저장되는 방식이 달라질 수 있습니다. 예를 들어, UTF-8 인코딩을 사용하는 경우에는 한 문자가 1바이트에서 최대 4바이트까지 차지할 수 있습니다. 따라서 FileWriter를 사용하여 문자열을 출력할 때는 해당 문자열의 인코딩 방식에 주의해야 합니다.

반면에 바이트 단위로 파일에 출력하는 경우에는 문자열이 바이트로 변환되어 파일에 직접 쓰여지므로 인코딩에 대한 신경 쓸 필요가 없습니다. 하지만 텍스트 파일로 저장되는 경우에는 인코딩 설정에 주의해야 합니다.

요약하자면, charAt 메서드는 문자열을 문자 단위로 처리하고, FileWriter는 파일에 문자열을 바이트 단위로 처리합니다. 두 가지 접근 방식은 서로 다른 용도에 사용됩니다.
*/
