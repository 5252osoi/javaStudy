package swing3_Layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
public class T04_CardLayout2 extends JFrame{
	
	private JPanel pn1,pn2,pn3;
	
	public T04_CardLayout2() {
		setTitle("CardLayout 연습");
		setSize(250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		CardLayout card=new CardLayout();
		
//		setLayout(new CardLayout());
		setLayout(card);
		
		
//		pn1=new JPanel();
//		pn1.setBackground(Color.magenta);
		pn2=new JPanel();
		pn2.setBackground(Color.CYAN);
		
		
		add("WHITE",genPn1());
		add(pn2);
		add("Green",getPn3());
		
		/*--------------------------------*/
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				card.next(getContentPane());
			}
		});
		
	}
	
	private JPanel getPn3() {
		pn3=new JPanel();
		pn3.setBackground(Color.GREEN);
		return pn3;
	}

	private JPanel genPn1() {
		pn1=new JPanel();
//		pn1.setBackground(Color.cyan);
//		pn1.setBackground(new Color(r,g,b));
		pn1.setBackground(new Color(190,0,50));
		return pn1;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T04_CardLayout2 t04 = new T04_CardLayout2();
				t04.setVisible(true);
				
			}
		});
	}
}
