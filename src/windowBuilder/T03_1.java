package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class T03_1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JButton btnInput,btnUpdate,btnList,btnSearch,btnDelete,btnExit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T03_1 frame = new T03_1();
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
	public T03_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 51));
		panel.setBounds(7, 7, 770, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("신  규  회  원  가  입");
		lblTitle.setFont(new Font("HY헤드라인M", Font.PLAIN, 28));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 770, 70);
		panel.add(lblTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(7, 84, 770, 230);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(199, 90, 57, 25);
		panel_1.add(lblName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setBounds(199, 145, 57, 25);
		panel_1.add(lblAge);
		
		txtName = new JTextField();
		txtName.setBounds(455, 90, 116, 25);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(455, 145, 116, 25);
		panel_1.add(txtAge);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(7, 321, 770, 230);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnInput = new JButton("입력");
		btnInput.setBounds(192, 40, 97, 23);
		panel_2.add(btnInput);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setBounds(481, 40, 97, 23);
		panel_2.add(btnUpdate);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setBounds(192, 103, 97, 23);
		panel_2.add(btnSearch);
		
		btnDelete = new JButton("삭제");
		btnDelete.setBounds(192, 166, 97, 23);
		panel_2.add(btnDelete);
		
		btnList = new JButton("전체조회");
		btnList.setBounds(481, 103, 97, 23);
		panel_2.add(btnList);
		
		btnExit = new JButton("종료");
		btnExit.setBounds(481, 166, 97, 23);
		panel_2.add(btnExit);
		
		/*---------------------------------------------------*/
		
		//입력
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtName.getText().trim();
				String age=txtAge.getText().trim();
				
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요.");
					txtName.requestFocus();
				}	
				else if(age.equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요.");
					txtAge.requestFocus();
				}
				else if(!Pattern.matches("^[0-9]*$", age)) {
					JOptionPane.showMessageDialog(null,"숫자로 입력해.");
					txtAge.requestFocus();
				}
				
				else {
					JOptionPane.showMessageDialog(null, "성명 : "+name+"\n나이 : "+age);
				}
				
			}
		});
		//수정
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "수정버튼");
			}
		});
		//개별조회
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "개별조회버튼");
			}
		});
		//전체조회
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "전체조회버튼");
			}
		});
		//삭제
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "삭제버튼");
			}
		});
		//종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "종료합니다.");
				System.exit(0);
			}
		});
	}
}
