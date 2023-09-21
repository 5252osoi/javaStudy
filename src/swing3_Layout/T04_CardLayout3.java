package swing3_Layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
public class T04_CardLayout3 extends JFrame{
	private JButton btn1,btn2,btn3,btn4;
	
	public T04_CardLayout3() {
		setTitle("CardLayout 연습");
		setSize(250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		CardLayout card=new CardLayout();
		setLayout(card);
		
		btn1=new JButton("봄");
		btn2=new JButton("여름");
		btn3=new JButton("가울");
		btn4=new JButton("겨울");
		
		btn1.setBackground(Color.YELLOW);
		btn2.setBackground(Color.GREEN);
		btn3.setBackground(Color.RED);
		btn4.setBackground(Color.BLUE);
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		
		/*--------------------------------------*/
		
		
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(getContentPane());
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T04_CardLayout3 t04 = new T04_CardLayout3();
				t04.setVisible(true);
				
			}
		});
	}
}
