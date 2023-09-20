package swing2_JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T04_JWindow5 extends JWindow{
	JLabel lblImg;
	
	public T04_JWindow5() {
		setSize(600,480);
		
//		lblImg = new JLabel();
//		add(lblImg);
		
		lblImg=new JLabel();
		lblImg.setIcon(new ImageIcon(getClass().getResource("./images/2.png")));
		add(lblImg);
		
		setLocationRelativeTo(null); //화면가운데 view 정렬
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(0);
//				setVisible(false);
				dispose();
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T04_JWindow5 t05 = new T04_JWindow5();
				t05.setVisible(true);
			}
		});
		
	}
}
