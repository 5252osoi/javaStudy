package swing3_Layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
	CardLayout 사용법
	카드레이아웃 제어메소드 : first(),last(),next(),show();
	first()	: 첫번째 카드 보이기
	last()	: 마지막 카드
	next()	: 다음 카드
	show()	: 그냥 보이기
*/

@SuppressWarnings("serial")
public class T04_CardLayout1 extends JFrame{
	
	private JPanel pnb1,pnb2;
	private JButton btn1,btn2;
	
	public T04_CardLayout1() {
		setTitle("CardLayout 연습");
		setSize(250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		CardLayout card = new CardLayout();
		
//		lbl1=new JLabel();
//		lbl1.setText("여기는 레이블");
//		pnb3=new JPanel();
//		pnb3.add(lbl1);
		
		
		pnb1 = new JPanel();
		pnb2 = new JPanel();
//		pnb1.setBackground(Color.CYAN);
//		pnb2.setBackground(Color.MAGENTA);
		pnb1.setLayout(card);
		
		
		btn1=new JButton("버튼1");
		btn2=new JButton("버튼2");
		
		pnb2.add(btn1);
		pnb2.add(btn2);
		
		
		add(pnb1, BorderLayout.CENTER);
		add(pnb2, BorderLayout.SOUTH);
	
	}
		
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T04_CardLayout1  t04 = new T04_CardLayout1 ();
				t04.setVisible(true);
			}
		});
	
	}
}
