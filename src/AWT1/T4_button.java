package AWT1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T4_button extends Frame implements WindowListener, ActionListener{
	
	public T4_button() {
		super("프레임 테스트");
//		setSize(400,300);
		setBounds(300, 300, 600, 480);
		//이름표(label)
		Label lbl=new Label("회 원 가 입 폼"); 
		this.add(lbl);
				
		Button btnExit = new Button("종 료");
		add(btnExit);
		
		setVisible(true);
		
		//UI
		/*----------------*/
		//리스너
		
		
		btnExit.addActionListener(this);
		
		addWindowListener(this);
	}
	public static void main(String[] args) {
		new T4_button();
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {}
	
////////////////////////////////////////////////////
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}
////////////////////////////////////////////////////
	
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
	
	
}
