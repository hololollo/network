package exam2;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 문제2. 철수는 자바프로그램에서 외부로 파일을 출력하는 코드를 작성하였다. test.txt 파일에 '점심뭐먹어?' 라는 글을 쓰고 실행하였더니 
오른쪽 그림처럼 출력되었다. 정상 출력과 코드 품질 향상을 위하여 문제점으로 꼽을 수 있는 원인과 조치내용을 모두 작성하시오. 
(패키지 경로 구문 및 import 구문은 문제와 관계없음)


IOService => Test2.png 참조

test.txt => test.txt내용2.jpg 참조
 */
public class Exam2 {
	public static void main(String[] args) {
		output1();
	}
	public static void output1() {
		try {
			FileOutputStream fos = null;
			fos = new FileOutputStream("test2.txt");
			String str = "점심뭐먹어?";
			for(int i = 0; i < str.length(); i++) {
				fos.write(str.charAt(i));
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}