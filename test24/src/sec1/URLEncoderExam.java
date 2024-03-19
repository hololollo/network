package sec1;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


// URLEncoder : 웹에서 사용하는 형태 코드값(UTF-8)으로 변경
// URLDecoder : 웹에서 사용하는 형태의 코드값을 다른 데스크톱 프로그램에서 인식 가능한 MS949로 변경
public class URLEncoderExam {
	public URLEncoderExam() {
		String msg = "abc가나다def1234學校";
		String enc_data;
		try {
			enc_data = URLEncoder.encode(msg, "UTF-8"); // ★★★
			System.out.println("인코딩 : " + enc_data);
			
			String dec_data = URLDecoder.decode(enc_data, "UTF-8");
			System.out.println("디코딩 : " + dec_data);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new URLEncoderExam();
	}
}
