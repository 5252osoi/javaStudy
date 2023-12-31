package swing3_Layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class T04_CardLayout2_3 extends JFrame{

	private JPanel pn1,pn2,pn3;
	
	public T04_CardLayout2_3() {
		setTitle("CardLayout 연습");
		setSize(250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	
		setLayout(new CardLayout());
		
		add(getpn1());
		add(getpn2());
		add(getpn3());
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
	
	
	}
	
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		private Component getpn3() {
			pn3=new JPanel();
			pn3.setBackground(new Color(r,0,0));
		return pn3;
	}

		private Component getpn2() {
			pn2=new JPanel();
			pn2.setBackground(new Color(0,g,0));
		return pn2;
	}
		
		private Component getpn1() {
			pn1=new JPanel();
			pn1.setBackground(new Color(0,0,b));
		return pn1;
	}

		CardLayout card=new CardLayout();
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T04_CardLayout2_3 t04 = new T04_CardLayout2_3();
				t04.setVisible(true);
			
				//반복 스레드 생성
				Thread thread = new Thread() {
					@Override
					public void run() {
						while(true) {
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {}
							
							
							SwingUtilities.invokeLater(new Runnable() {
								@Override
								public void run() {
									CardLayout cardLayout = (CardLayout) t04.getContentPane().getLayout();									
									cardLayout.next(t04.getContentPane());
								}
							});
						}
						
					}
				};
				thread.start();
				
			}
		});
	}
}
