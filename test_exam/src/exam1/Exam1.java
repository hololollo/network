package exam1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 문제1. 철수는 자바프로그램에서 외부로 파일을 출력하는 코드를 작성하였다. test.txt 파일에 '안녕하세요!' 라는 글을 쓰고 실행하였더니
 오른쪽 그림처럼 출력되었다. 정상 출력과 코드 품질 향상을 위하여 문제점으로 꼽을 수 있는 원인과 조치내용을 모두 작성하시오. 
(패키지 경로 구문 및 import 구문은 문제와 관계없음)

IOService => Test1.png 참조

test.txt => test.txt내용.jpg 참조

InputStream은 데이터를 읽어오는데 사용되는 스트림입니다.
코드에서 InputStream이 필요한 경우는 파일을 읽어올 때나 네트워크로부터 데이터를 읽어올 때 등 데이터를 읽어오는 작업을 수행할 때입니다. 
주어진 코드에서는 데이터를 파일에 쓰는 작업만 수행하고 있으므로 InputStream은 필요하지 않습니다.

해당 코드에서는 FileOutputStream과 OutputStreamWriter를 사용하여 파일에 문자열을 씁니다. 
먼저 FileOutputStream을 사용하여 바이트 스트림으로 파일에 쓰고, 이를 OutputStreamWriter로 래핑하여 문자 스트림으로 변환한 후 문자열을 파일에 씁니다. 
따라서 데이터를 파일에 쓰는 작업에는 InputStream이 필요하지 않습니다.

 */
public class Exam1 {
	public static void main(String[] args) {
		output1();
	}
	public static void output1() {
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		/*
		 여기서 FileOutputStream은 "test.txt" 파일을 열어서 쓰기 위한 파일 출력 스트림을 생성하고, 
		 OutputStreamWriter는 이 파일 출력 스트림을 이용하여 문자를 쓰기 위한 문자 출력 스트림을 생성합니다.
			즉, 위 코드에서 파일 스트림은 FileOutputStream과 OutputStreamWriter 객체를 생성하는 부분에 있습니다.
		 */
		try {
			fos = new FileOutputStream("test.txt");
			osw = new OutputStreamWriter(fos, "UTF-8"); // UTF-8 인코딩으로 설정
			/*
			 osw.write(str)은 OutputStreamWriter를 사용하여 문자열을 파일에 쓰는 역할을 합니다. 
			 따라서 osw.write(str)을 사용하지 않으면 문자열이 파일에 쓰이지 않으며, 파일에 아무 내용도 기록되지 않습니다.
			 */
			String str = "안녕하세요!";
			osw.write(str);
			/*
			for(int i = 0; i < str.length(); i++) {
				osw.write(str.charAt(i)); // 배열의 인덱스 만큼.
			}
			주어진 코드에서 for 루프 부분은 기존에 OutputStreamWriter를 사용하여 "안녕하세요!" 문자열을 파일에 쓴 후에, 
			해당 문자열을 다시 파일에 쓰는 부분입니다. 이 코드는 문자열을 두 번씩 파일에 쓰는 작업을 수행하고 있습니다.
			이 부분이 왜 필요한지에 대한 이유는 명확하지 않습니다. 
			왜냐하면 이미 앞에서 osw.write(str)를 사용하여 "안녕하세요!" 문자열을 파일에 성공적으로 썼기 때문입니다. 
			이후에 또 같은 문자열을 파일에 쓰는 것은 중복된 작업이며, 파일에 두 번 출력되는 결과를 낳습니다.
			따라서 이 코드의 for 루프 부분은 필요하지 않습니다. 아래 코드는 해당 부분을 제거한 수정된 코드입니다:
			*/
			
		} catch (IOException e) {
			e.printStackTrace();
			/*
			 finally 블록 내에서 osw.close()와 fos.close()를 호출하는 이유는 
		 		프로그램이 종료되기 전에 열린 파일 스트림을 명시적으로 닫아야 하기 때문입니다.
			 */
		} finally {
            try {
                if (osw != null)
                    osw.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
/*
// 1.FileOutputStream이 사용될 때 인코딩을 지정하지 않아서 문제 발생. 
//  바이트 단위를 기본으로 데이터를 쓰기가 이루어지기 때문에 문자열을 직접 쓸 때 한글문자는 깨질 수 있습니다.
//  OutputStreamWriter를 사용하여 명시적으로 인코딩을 지정하는 것이 있습니다.
//  22행에  OutputStreamWriter osw = null; 로 초기화
// 	25행에 osw = new OutputStreamWriter(fos, "UTF-8"); // UTF-8 인코딩으로 설정
// 	27행에 osw.write(str); 넣어줘서 입력시 UTF-8 인코딩이 되게 설정
// catch문 이후 finally { 를 사용하여 null값으로 열었던 osw, fos를  null값이 아니라면 닫아주는 예외처리 작업이 필요하다. 
try {
    if (osw != null)
        osw.close();
    if (fos != null)
        fos.close();
} catch (IOException e) {
    e.printStackTrace();
  */
// 2. 