package sec1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class LoginGUI extends JFrame implements ActionListener, KeyListener {
	JPanel port_log = new JPanel();
	JLabel port_label = new JLabel("유저입력");
	JLabel port_label1 = new JLabel("포트입력");
	JLabel port_label2 = new JLabel("주소입력");
	JTextField port_num = new JTextField(15);
	JTextField port_num1 = new JTextField(15);
	JTextField port_num2 = new JTextField("###.###.###.###", 15);
	JButton port_btn = new JButton("접속");
	
	public LoginGUI() {
		setTitle("로그인 화면");
		setLocationRelativeTo(null); // 위치 : Auto
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼 표시
		setSize(300, 200); // 창 전체 가로 x 세로
		setVisible(true);
		setResizable(true); // 창크기 조절 가능
		// 패널
		port_btn.addActionListener(this);
		port_num.addKeyListener(this);
		port_log.add(port_label);
		port_log.add(port_num);
		port_log.add(port_label1);		
		port_log.add(port_num1);
		port_log.add(port_label2);		
		port_log.add(port_num2);		
		port_log.add(port_btn);
		port_btn.setPreferredSize(new Dimension(150, 30));

		add(port_log);
		
}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}	
public class GUIClient {

	public static void main(String[] args) {
		new LoginGUI();
	}

}
