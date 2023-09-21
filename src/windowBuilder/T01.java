package windowBuilder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class T01 {

	private JFrame frame;
	private JTextField txtMid,txtName,txtSosok;
	private JButton btnInput, btnReset, btnClose;
	private JPasswordField txtPsd;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T01 window = new T01();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public T01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("테스트");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입 창");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		lblNewLabel.setBounds(192, 44, 400, 100);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(204, 188, 100, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("성명");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(204, 336, 100, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(204, 262, 100, 30);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("소속");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(204, 410, 100, 30);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		txtMid = new JTextField();
		txtMid.setBounds(305, 188, 250, 30);
		frame.getContentPane().add(txtMid);
		txtMid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(305, 336, 250, 30);
		frame.getContentPane().add(txtName);
		
		txtSosok = new JTextField();
		txtSosok.setColumns(10);
		txtSosok.setBounds(305, 410, 250, 30);
		frame.getContentPane().add(txtSosok);
		
		
		//회원가입버튼
		btnInput = new JButton("회원가입");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str="";
				str+="아이디 : "+txtMid.getText()+"\n";
				str+="비밀번호 : "+txtPsd.getText()+"\n";
				str+="성 명 : "+txtName.getText()+"\n";
				str+="소 속 : "+txtSosok.getText();
				JOptionPane.showMessageDialog(null, str);
			}
		});
		btnInput.setBounds(83, 484, 150, 30);
		frame.getContentPane().add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setBounds(316, 484, 150, 30);
		frame.getContentPane().add(btnReset);
		
		btnClose = new JButton("작업종료");
		btnClose.setBounds(549, 484, 150, 30);
		frame.getContentPane().add(btnClose);
		
		txtPsd = new JPasswordField();
		txtPsd.setBounds(305, 262, 250, 30);
		frame.getContentPane().add(txtPsd);
	}
}
