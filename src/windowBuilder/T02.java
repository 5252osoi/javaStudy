package windowBuilder;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;

public class T02 extends JFrame {

	private JPanel contentPane;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMale,rdbtnFemale;
	private JCheckBox chckbxHobby,chckbxHobby_1,chckbxHobby_2,chckbxHobby_3;
	private JButton btnSubmit,btnReset;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T02 frame = new T02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public T02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 7, 560, 50);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("라디오버튼 연습");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("궁서", Font.ITALIC, 18));
		lblTitle.setBounds(0, 5, 560, 40);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 64, 560, 200);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblGender = new JLabel("성  별");
		lblGender.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(83, 27, 80, 30);
		pn2.add(lblGender);
		
		JLabel lblHobby = new JLabel("취  미");
		lblHobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblHobby.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblHobby.setBounds(83, 84, 80, 30);
		pn2.add(lblHobby);
		
		rdbtnMale = new JRadioButton("남  자");
		rdbtnMale.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		rdbtnMale.setBounds(240, 27, 80, 30);
		buttonGroup.add(rdbtnMale);
		pn2.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("여  자");
		rdbtnFemale.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		rdbtnFemale.setSelected(true);
		rdbtnFemale.setBounds(400, 27, 80, 30);
		buttonGroup.add(rdbtnFemale);
		pn2.add(rdbtnFemale);
		
		JLabel lblMsg = new JLabel("메시지 출력");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBackground(Color.PINK);
		lblMsg.setBounds(123, 141, 330, 30);
		pn2.add(lblMsg);
		
		chckbxHobby = new JCheckBox("등산");
		chckbxHobby.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		chckbxHobby.setBounds(200, 84, 80, 30);
		pn2.add(chckbxHobby);
		
		chckbxHobby_1 = new JCheckBox("낚시");
		chckbxHobby_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		chckbxHobby_1.setBounds(284, 84, 80, 30);
		pn2.add(chckbxHobby_1);
		
		chckbxHobby_2 = new JCheckBox("수영");
		chckbxHobby_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		chckbxHobby_2.setBounds(368, 84, 80, 30);
		pn2.add(chckbxHobby_2);
		
		chckbxHobby_3 = new JCheckBox("바둑");
		chckbxHobby_3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		chckbxHobby_3.setBounds(452, 84, 80, 30);
		pn2.add(chckbxHobby_3);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 271, 560, 80);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		/*---------------------------------------------------*/
		
		//전송버튼
		btnSubmit = new JButton("전  송");
		btnSubmit.setBounds(86, 20, 150, 40);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String gender="";
				if(rdbtnMale.isSelected())gender=rdbtnMale.getText();
				else if(rdbtnFemale.isSelected())gender=rdbtnFemale.getText();
				
				String hobby="";
				if(chckbxHobby.isSelected())hobby+= chckbxHobby.getText()+"/";
				if(chckbxHobby_1.isSelected())hobby+= chckbxHobby_1.getText()+"/";
				if(chckbxHobby_2.isSelected())hobby+= chckbxHobby_2.getText()+"/";
				if(chckbxHobby_3.isSelected())hobby+= chckbxHobby_3.getText()+"/";
				
				lblMsg.setText(gender+" , "+hobby);
				JOptionPane.showMessageDialog(null, "성별 : " +gender+" , "+hobby);
			}
		});
		
		
		pn3.add(btnSubmit);
		
		btnReset = new JButton("종  료");
		btnReset.setBounds(322, 20, 150, 40);
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		pn3.add(btnReset);
	}
}
