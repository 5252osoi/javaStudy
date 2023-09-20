package swing3_Layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//GridLayout 연습
@SuppressWarnings("serial")
public class T03_GridLayout extends JFrame{
	private JButton btn1, btn2, btn3, btn4, btn5, btn6;
	
	public T03_GridLayout() {
		setTitle("GridLayout 연습");
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		setLayout(new GridLayout(2, 3));
		
		add(getBtn1());
		add(getBtn2());
		add(getBtn3());
		add(getBtn4());
		add(getBtn5());
//		add(getBtn6());
		
		
	}
	
	private JButton getBtn1() {
		btn1= new JButton("버튼1임다");
		return btn1;
	}
	private JButton getBtn2() {
		btn2= new JButton("버튼2임다");
		return btn2;
	}
	private JButton getBtn3() {
		btn3= new JButton("버튼3임다");
		return btn3;
	}
	private JButton getBtn4() {
		btn4= new JButton("버튼4임다");
		return btn4;
	}
	private JButton getBtn5() {
		btn5= new JButton("버튼5임다");
		return btn5;
	}
//	private JButton getBtn6() {
//		btn6= new JButton("버튼6임다");
//		return btn6;
//	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T03_GridLayout t03=new T03_GridLayout();
				t03.setVisible(true);
			}
		});
		
		
	}
	
}
