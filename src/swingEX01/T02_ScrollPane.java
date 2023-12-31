package swingEX01;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_ScrollPane extends JFrame{
	private JLabel lblImg;
	private JScrollPane scrollPane;
	
	
	public T02_ScrollPane() {
		setTitle("ScrollPane 연습");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(getScrollPane(), BorderLayout.CENTER);

	}
	//JScrollPane 생성
	private JScrollPane getScrollPane() {
		scrollPane=new JScrollPane(getLblImg()); //JScrollPane에 그림을 포함하고 있는 레이블을 올려줌
		return scrollPane;
	}

	//JLable 생성(JLabel생성과 동시에 그림 넣기)
	private JLabel getLblImg() {
		lblImg=new JLabel();
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/12.png")));
		return lblImg;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T02_ScrollPane t02 = new T02_ScrollPane();
				t02.setVisible(true);
				
			}
		});
	}
	
}
