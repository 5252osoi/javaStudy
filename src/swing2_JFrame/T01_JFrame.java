package swing2_JFrame;

import javax.swing.JFrame;

public class T01_JFrame extends JFrame{

	public T01_JFrame() {
		setTitle("스윙2~");
		setBounds(300,300,600,480);
	}
	public static void main(String[] args) {
	
		T01_JFrame t1 =new T01_JFrame();
		t1.setVisible(true);
	}
	
}
