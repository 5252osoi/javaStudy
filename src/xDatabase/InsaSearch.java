package xDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class InsaSearch extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private ButtonGroup buttonGroup =new ButtonGroup();
	private JRadioButton rdMale,rdFemale;
	private JButton btnUpdate,btnDelete,btnClose;
	
	InsaDAO dao= new InsaDAO();
	InsaVO vo=null;
	int res=0;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsaInput frame = new InsaInput();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		new InsaSearch();
//	}

	/**
	 * Create the frame.
	 * @param vo2 
	 */
	public InsaSearch(InsaVO vo2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setLayout(null);
		pn1.setBounds(7, 5, 770, 70);
		contentPane.add(pn1);
		
		JLabel lblNewLabel = new JLabel("사 원 정 보 조 회");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 10, 700, 50);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(null);
		pn2.setBounds(7, 80, 770, 400);
		contentPane.add(pn2);
		
		JLabel lblName = new JLabel("성  명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblName.setBounds(173, 56, 150, 30);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나  이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblAge.setBounds(173, 142, 150, 30);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성  별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblGender.setBounds(173, 228, 150, 30);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입 사 일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		lblIpsail.setBounds(173, 314, 150, 30);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		txtName.setBounds(321, 57, 250, 30);
		txtName.setText(vo.getName());
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		txtName.setText(vo.getAge()+"");
		txtAge.setColumns(10);
		txtAge.setBounds(321, 143, 250, 30);
		pn2.add(txtAge);
		
		rdMale = new JRadioButton("남  자");
		rdMale.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		rdMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdMale.setSelected(true);
		
		if(vo.getGender().equals("남자"))rdMale.setSelected(true);
		
		rdMale.setBounds(349, 228, 100, 30);
		buttonGroup.add(rdMale);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여  자");
		rdFemale.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		rdFemale.setHorizontalAlignment(SwingConstants.CENTER);

		if(vo.getGender().equals("여자"))rdFemale.setSelected(true);
		
		rdFemale.setBounds(453, 228, 100, 30);
		buttonGroup.add(rdFemale);
		pn2.add(rdFemale);
		
		String[] yy = new String[24];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		
		int imsi;
		for(int i=0; i<yy.length; i++) {
			imsi = i + 2000;
			yy[i]=imsi+"";
		}
		for(int i=0; i<mm.length; i++) {
			mm[i]=(1+i)+"";
		}
		for(int i=0; i<dd.length; i++) {
			dd[i]=(i+1)+"";
		}
		
		String[] ymds=vo.getIpsail().substring(0,10).split("-"); //2023-09-22 ;  
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		cbYY.setBounds(321, 314, 80, 30);
		cbYY.setSelectedItem(ymds[0]);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		cbMM.setBounds(436, 314, 60, 30);
		cbMM.setSelectedItem(ymds[1]);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		cbDD.setBounds(525, 314, 60, 30);
		cbDD.setSelectedItem(ymds[2]);
		pn2.add(cbDD);
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setBounds(7, 485, 770, 70);
		contentPane.add(pn3);
		
		btnUpdate = new JButton("사원정보수정");
		btnUpdate.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnUpdate.setBounds(80, 15, 150, 40);
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("사원정보삭제");
		btnDelete.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnDelete.setBounds(310, 15, 150, 40);
		pn3.add(btnDelete);
		
		btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnClose.setBounds(540, 15, 150, 40);
		pn3.add(btnClose);

		/*--------------------------------------------------------------*/
		
		//등록완료
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//다시입력
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				rdMale.setSelected(true);
				
				//입사일은 오늘날짜로 채우기
				InsaService service=new InsaService();
				vo = service.getDefaultDate();
				//vo에 가져온 날짜데이터 콤보상자에 setselecteditem으로 넣기
				cbYY.setSelectedItem(vo.getStryy());
				cbMM.setSelectedItem(vo.getStrmm());
				cbDD.setSelectedItem(vo.getStrdd());
				
				txtName.requestFocus();
			}
		});
		//창 닫기
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
				dispose();
			}
		});
	}
}
