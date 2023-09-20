package swing3_Layout;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


//BorderLayout연습
@SuppressWarnings("serial")
public class T02_BorderLayout2 extends JFrame{
	private JButton btnNorth, btnWest,btnEast;
	private JTextField txtSouth;
	private JTextArea txtACenter;
	
	public T02_BorderLayout2() {
		setTitle("BorderLayout 연습");
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		this.getContentPane().add(getBtnNorth(),BorderLayout.NORTH);
		this.getContentPane().add(getTxtSouth(),BorderLayout.SOUTH);
		this.getContentPane().add(getBtnWest(),BorderLayout.WEST);
		this.getContentPane().add(getBtnEast(),BorderLayout.EAST);
		add(getTxtACenter(),BorderLayout.CENTER);
	}
	
	


	private JTextArea getTxtACenter() {
		txtACenter = new JTextArea();
		return txtACenter;
	}


	private JTextField getTxtSouth() {
		txtSouth =new JTextField();
		return txtSouth;
	}


	private Component getBtnEast() {
		btnEast=new JButton("동쪽");
		return btnEast;
	}


	private Component getBtnWest() {
		btnWest=new JButton("서쪽");
		return btnWest;
	}


	private Component getBtnNorth() {
		btnNorth =new JButton("북쪽");
		return btnNorth;
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T02_BorderLayout2 t02 = new T02_BorderLayout2();
				t02.setVisible(true);
				
			}
		});
	}
}
