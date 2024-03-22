package exam1;

import java.io.FileWriter;
import java.io.IOException;

public class Exam1_comp {

	public static void main(String[] args) {
		output1();
	}
	public static void output1() {
		FileWriter fos = null;
		try {
			fos = new FileWriter("test10.txt");
			String str = "안녕하세요!";
			for(int i = 0; i < str.length(); i++) {
				fos.write(str.charAt(i));
			}
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
 
charAt 메서드는 Java의 String 클래스에서 사용되는 메서드입니다. 이 메서드는 문자열 내의 지정된 인덱스에 해당하는 문자를 반환합니다.

charAt 메서드는 문자열에서 특정 위치의 문자를 읽기 위해 사용됩니다. 일반적으로 문자열을 반복하거나 특정 인덱스에 있는 문자를 검색하는 데 사용됩니다.

예를 들어, 다음은 charAt 메서드를 사용하여 문자열의 각 문자를 출력하는 간단한 예제입니다:

java
Copy code
String str = "Hello";
for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
    System.out.println("Character at index " + i + " is: " + c);
}
이 코드는 "Hello" 문자열의 각 문자를 반복하고 각 문자와 해당 인덱스를 출력합니다.

따라서 charAt 메서드는 주로 문자열에서 특정 위치의 문자를 읽기 위해 사용됩니다.
 */