package swing2_JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class T01_JFrame2 extends JFrame{
	JButton btnExit; 
	
	
	public T01_JFrame2() {
		setTitle("스윙2~");
		setBounds(300,300,600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnExit = new JButton("EXIT");
		add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		
		T01_JFrame2 t1 =new T01_JFrame2();
		t1.setVisible(true);
	}
	
}
