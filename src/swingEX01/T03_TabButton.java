package swingEX01;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T03_TabButton extends JFrame{
	private JTabbedPane tabbedPane;
	private JPanel pnTab1,pnTab2;
	
	public T03_TabButton() {
		setTitle("TabButton연습");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		add(getTabbedPane(),BorderLayout.CENTER);
		
		
		
	}
	
	private JTabbedPane getTabbedPane() {
		tabbedPane =new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.add("탭1",getPnTab1());
		tabbedPane.add("탭2",getPnTab2());
		return tabbedPane;
	}

	//첫번째 탭 설정
	private JPanel getPnTab2() {
		pnTab2 = new JPanel();
		JLabel lblImg1=new JLabel();
		lblImg1.setIcon(new ImageIcon(getClass().getResource("./images/13.png")));
		pnTab2.add(lblImg1);
		return pnTab2;
	}

	private JPanel getPnTab1() {
		pnTab1 = new JPanel();
		JLabel lblImg2=new JLabel();
		lblImg2.setIcon(new ImageIcon(getClass().getResource("./images/14.png")));
		pnTab1.add(lblImg2);
		return pnTab1;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			
			@Override
			public void run() {
				T03_TabButton t03 = new T03_TabButton();
				t03.setVisible(true);
			}
		});
	}
	
}
