package swing3_Layout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T05_NullLayout2 extends JFrame{
	private JButton btnExit;
	
	
	public T05_NullLayout2() {
		setTitle("NullLayout (절대위치레이아웃)");
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(null);
		
		add(getBtnExit());
		
		
	}
	
	private JButton getBtnExit() {
		btnExit=new JButton();
		btnExit.setText("종 료");
		btnExit.setBounds(100, 80, 70, 50);
		return btnExit;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T05_NullLayout2 t05 = new T05_NullLayout2();
				t05.setVisible(true);
			}
		});
		
		
	}
}
