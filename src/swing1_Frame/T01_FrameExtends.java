package swing1_Frame;

import java.awt.Frame;

public class T01_FrameExtends extends Frame{
	
	public T01_FrameExtends() {
//		super("스윙~");
		setTitle("스윙~");
		setSize(600,480);
		
	}
	
	public static void main(String[] args) {
		T01_FrameExtends t1=new T01_FrameExtends();
		t1.setVisible(true);
	}
}
