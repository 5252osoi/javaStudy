package AWT2_Adapter;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T2_Button_Event extends Frame{

	public T2_Button_Event() {
		super("어댑터 활용!!!");
		
		setBounds(300, 300, 600, 480);
		Button btnPlay,btnExit;
		
		this.setLayout(new FlowLayout()); //추가레이어
		
		
		btnPlay=new Button("Play");
		btnExit=new Button("Exit");
		
		add(btnPlay);
		add(btnExit);
		
		setVisible(true);
	///////////////////////////////////////////////////////
		//btnplay버튼 제어하기
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Button btn = (Button) e.getSource();
				if(btn.getLabel().equals("Play")) {
					btn.setLabel("Stop");
					System.out.println("음악을 재생중입니다.");
				} else if(btn.getLabel().equals("Stop")) {
					btn.setLabel("Play");
					System.out.println("재생이 중단되었습니다.");
				}
			}
		});
		
		//종료버튼btnExit)를 이용한 윈도우 종료
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("작업을 종료합니다.");
				System.exit(0);
			}
		});
		
		
		//윈도우어댑처를 이용한 윈도우 종료
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new T2_Button_Event();
	}
}
