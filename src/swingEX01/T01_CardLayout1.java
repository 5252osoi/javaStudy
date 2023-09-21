package swingEX01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_CardLayout1 extends JFrame{

	private JLabel lblCen;
	private JPanel lblSou;
	private JButton btn1,btn2,btn3,btn4;
	public T01_CardLayout1() {
		setTitle("카드레이아웃연습");
		setSize(280,400);;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		lblCen=new JLabel();
		lblSou=new JPanel();
		add(lblCen,BorderLayout.CENTER);
		add(lblSou,BorderLayout.SOUTH);
	///////////////////보더레이아웃/////////////////
	/////////////////////버튼////////////////////
		btn1=new JButton("봄");
		btn2=new JButton("여름");
		btn3=new JButton("가울");
		btn4=new JButton("겨울");
//		pnCen.setIcon(new ImageIcon(".images/11.png"));
		lblSou.add(btn1);
		lblSou.add(btn2);
		lblSou.add(btn3);
		lblSou.add(btn4);
	///////////////////////////////////////////////
		/*-----------액션리스너-------------*/
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCen.setIcon(new ImageIcon(getClass().getResource("./images/11.png")));
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCen.setIcon(new ImageIcon(getClass().getResource("./images/12.png")));
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCen.setIcon(new ImageIcon(getClass().getResource("./images/13.png")));
			}
		});
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCen.setIcon(new ImageIcon(getClass().getResource("./images/14.png")));
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T01_CardLayout1 t01 = new T01_CardLayout1();
				t01.setVisible(true);
			}
		});
		
	}
}
