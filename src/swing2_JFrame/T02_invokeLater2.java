package swing2_JFrame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_invokeLater2 extends JFrame{
	
	public T02_invokeLater2() {
		setTitle("스윙 이벤트 큐");
		setSize(600,480);
		
		System.out.println("222222222");
		
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		System.out.println("1111111111");
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T02_invokeLater2 t02 = new T02_invokeLater2();
				t02.setVisible(true);
				System.out.println(Thread.currentThread().getName());
			}
		});
		
		
		System.out.println("33333333333");
		System.out.println(Thread.currentThread().getName());
	}
}
