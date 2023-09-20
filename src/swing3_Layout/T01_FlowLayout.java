package swing3_Layout;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T01_FlowLayout extends JFrame{
	private JButton btnOK,btnExit,btnAnswer1,btnAnswer2,btnAnswer3,btnInput;
	private JLabel lblName;
	
	public T01_FlowLayout() {
		setTitle("FlowLayout 연습");
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 창 닫기
		setLocationRelativeTo(null);	//프레임 가운데정렬
//		setResizable(false); 			//프레임 크기 고정

		setLayout(new FlowLayout());
		
		/*------------------------------------------*/
		
//		this.getContentPane().add(getBtnOK());		
		add(getBtnAnswer1());
		add(getBtnAnswer2());
		add(getBtnAnswer3());
		
		add(getBtnInput());

		add(getBtnOK());
		add(getBtnExit());
		
		
		add(getLblName());
		
		
		/*------------------------------------------*/
		
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("성명을 입력하세요.","성명 입력창");
				JOptionPane.showMessageDialog(null, "성명 : "+name);
				lblName.setText("성명 : " +name);
				System.out.println("name : "+name);
			}
		});
		
		
		
		btnAnswer3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//옵션이 YES_NO_CANCEL_OPTION 일 때 예(0)/아니오(1)/취소(2) 값을 반환한다
				int ans=JOptionPane.showConfirmDialog(null, "작업을 계속할까요?","선택박스",JOptionPane.YES_NO_CANCEL_OPTION);
				if(ans==0) JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다","확인창",JOptionPane.INFORMATION_MESSAGE);
				else if(ans==1){
					JOptionPane.showMessageDialog(null, "작업을 종료합니다.","확인창",JOptionPane.WARNING_MESSAGE);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "선택을 취소합니다.","확인창",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnAnswer2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//옵션이 YES_NO_OPTION 일 때 예(0)/아니오(1) 값을 반환한다
				int ans=JOptionPane.showConfirmDialog(null, "작업을 계속할까요?","선택박스",JOptionPane.YES_NO_OPTION);
				if(ans==0) JOptionPane.showMessageDialog(null, "작업을 계속 진행합니다","확인창",JOptionPane.INFORMATION_MESSAGE);
				else {
					JOptionPane.showMessageDialog(null, "작업을 종료합니다.","확인창",JOptionPane.WARNING_MESSAGE);
					dispose();
				}
			}
		});
		btnAnswer1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//옵션이 OK_CANCEL_OPTION 일 때 확인(0)/취소(2) 값을 반환한다
				int ans=JOptionPane.showConfirmDialog(null, "버튼을 선택하세요","선택박스",JOptionPane.OK_CANCEL_OPTION);
				if(ans==0) JOptionPane.showMessageDialog(null, "확인완료","확인창",JOptionPane.INFORMATION_MESSAGE);
				else JOptionPane.showMessageDialog(null, "취소완료","확인창",JOptionPane.WARNING_MESSAGE);
				
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "확인완료","확인창",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "종료합니다.");
//				JOptionPane.showMessageDialog(null,"종료합니다.","종료창",JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(null,"종료합니다.","종료창",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		});
	}
	
	private JLabel getLblName() {
		lblName = new JLabel();
		return lblName;
	}

	private JButton getBtnInput() {
		btnInput = new JButton("입력");
		return btnInput;
	}

	private JButton getBtnAnswer1() {
		btnAnswer1 = new JButton("1 번");
		return btnAnswer1;
	}
	private JButton getBtnAnswer2() {
		btnAnswer2 = new JButton("2 번");
		return btnAnswer2;
	}
	private JButton getBtnAnswer3() {
		btnAnswer3 = new JButton("3 번");
		return btnAnswer3;
	}

	private JButton getBtnExit() {
		btnExit = new JButton("종료");
		return btnExit;
	}

	private JButton getBtnOK() {
		if(btnOK==null) {
//			btnOK=new JButton("확인");
			btnOK=new JButton();
			btnOK.setText("확인");
			
		}
		return btnOK;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T01_FlowLayout t01 =new T01_FlowLayout();
				t01.setVisible(true);
				
			}
		});
	}
}
