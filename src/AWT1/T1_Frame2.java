package AWT1;

import java.awt.Frame;

@SuppressWarnings("serial")
public class T1_Frame2 extends Frame{
	
	
	public T1_Frame2() {
		super("프레임 테스트");
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args) {
//		Frame frame = new Frame();
//		
//		frame.setTitle("AWT 연습");
//		frame.setSize(400,300);  //폭,높이는 픽셀단위임.
//		frame.setVisible(true); //작업종료하는 코드가 따로 필요함 . . .
//		
	new T1_Frame2();	
		
	}
}
