package swing3_Layout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_BorderLayout3 extends JFrame{
	private JButton btn1,btn2,btnExit;
	private JPanel pn1;
	
	public T02_BorderLayout3() {
		setTitle("보더레이아웃연습");
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		btn1=new JButton("안녕하세요");
		add(btn1,BorderLayout.NORTH); 

		btn2=new JButton("헉인");
		btnExit=new JButton("종료");
		pn1=new JPanel();
		
//		pn1.setLayout(new GridLayout(1,2)); //패널에 레이아웃을 넣기
		
		pn1.add(btn2);
		pn1.add(btnExit);
//		add(pn1);
		
		add(pn1,BorderLayout.SOUTH);
		
		/*-------------------------------------*/
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "안녕..");
				
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T02_BorderLayout3 t02 = new T02_BorderLayout3();
				t02.setVisible(true);
			}
		});
	}
}
