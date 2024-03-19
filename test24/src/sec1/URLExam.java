package sec1;

import java.net.MalformedURLException;
import java.net.URL;

//URL 클래스 : URL 주소를 다루기 위한 클래스
/*
주요 메소드 설명

① String getFile( )
URL의 파일 이름을 반환하는 메서드입니다.

② String getHost( )
URL의 호스트 이름을 반환하는 메서드입니다.

③ String getPort( )
URL의 포트 번호를 반환하는 메서드입니다. 보통은 80번이지만 감추어 졌거나 모종의 이유로 묵시적인 포트인 경우 –1 을 반환합니다.

④ String getProtocol( )
URL의 프로토콜 이름을 반환하는 메서드입니다.

⑤ String toExternalForm( )
전체 URL의 문자열 객체를 반환하는 메서드입니다.

⑥ InputStream openStream( ) throws IOException
지정된 URL로부터 정보를 읽어들이기 위한 객체를 반환하는 메서드입니다.

⑦ URLConnection openConnection( ) throws IOException
지정된 URL과 연결 후 URLConnection 객체를 반환하는 메서드입니다.

*/
public class URLExam {
	public static void main(String[] args) throws MalformedURLException { 
		// MalformedURLException : 잘못된 URL이 발생했음을 나타내기 위해 실행. 문자열에서 합법적인 프로토콜을 찾을 수 없거나 문자열을 구문 분석할 수 없을 때
		URL naver = new URL("https://comic.naver.com/index");
		System.out.println("프로토콜 종류 : "+naver.getProtocol());
		System.out.println("포트 번호 : "+naver.getPort());
		System.out.println("호스트 이름 : "+naver.getHost());
		System.out.println("파일(경로 포함) : "+naver.getFile());
		System.out.println("전체 URL : "+naver.toExternalForm());
	}
}