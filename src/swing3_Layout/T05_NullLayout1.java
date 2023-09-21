package swing3_Layout;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T05_NullLayout1 extends JFrame{
	private JButton btnExit,btnInput,btnReset;
	private JLabel lblName,lblAge,lblContent;
	private JTextField txtName,txtAge;
	private int xPos=50,yPos=100;
	
	private JTextArea txtaContent;
	
	public T05_NullLayout1() {
		setTitle("NullLayout (절대위치레이아웃)");
		setSize(400,380);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(null);
		
		add(getLblName());
		add(getLblAge());
		add(getTxtName());
		add(getTxtAge());
		
		
		add(getLblContent());
		
		add(getBtnExit());
		add(getBtnInput());
		add(getBtnReset());
		
		/*-------------------------------------------------*/
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str="";
				str+="성명: "+txtName.getText(); 
				str+="나이: "+txtAge.getText(); 
			
				lblContent.setText(str);
			}
		});
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtName.setName("");
				txtAge.setName("");
			}
		});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "작업을 종료합니다.. .");
				dispose();
			}
		});
		
	}
	
	private JLabel getLblContent() {
		lblContent = new JLabel("회 원 가 입");
		lblContent.setBackground(Color.blue);
		lblContent.setBounds(xPos+70, yPos+40, 200, 150);
		return 	lblContent;
	}

	private JButton getBtnReset() {
		btnReset=new JButton();
		btnReset.setText("회 원 가 입");
		btnReset.setBounds(xPos+160,yPos+100,100,30);
		return btnReset;
	}

	private JButton getBtnInput() {
		btnInput=new JButton();
		btnInput.setText("입 력");
		btnInput.setBounds(xPos+160,yPos,100,30);
		return btnInput;
	}

	private JTextField getTxtAge() {
		txtAge= new JTextField();
		txtAge.setBounds(xPos+50,yPos,100,30);
		return txtAge;
	}

	private JTextField getTxtName() {
		txtName= new JTextField();
		txtName.setBounds(xPos+50,yPos+50,100,30);
		return txtName;
	}

	private JLabel getLblAge() {
		lblAge=new JLabel();
		lblAge.setText("나  이");
		lblAge.setBounds(xPos,yPos,100,30);
		return lblAge;
	}

	private JLabel getLblName() {
		lblName = new JLabel();
		lblName.setText("성  명");
		lblName.setBounds(xPos,yPos+50,100,30);
		return lblName;
	}

	private JButton getBtnExit() {
		btnExit=new JButton();
		btnExit.setText("종 료");
		btnExit.setBounds(xPos+160,yPos+50,100,30);
		return btnExit;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T05_NullLayout1 t05 = new T05_NullLayout1();
				t05.setVisible(true);
			}
		});
		
		
	}
}
