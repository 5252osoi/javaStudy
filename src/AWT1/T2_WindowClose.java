package AWT1;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T2_WindowClose extends Frame implements WindowListener{
	
	public T2_WindowClose() {
		super("프레임 테스트");
		setSize(400,300);
		
		Label lbl=new Label("회 원 가 입 폼");
		this.add(lbl);
		
		setVisible(true);
		
		/*------------------------------------*/

		
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new T2_WindowClose();
		
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
	
	
}
