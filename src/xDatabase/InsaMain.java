package xDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.StackWalker.Option;
import java.awt.event.ActionEvent;

public class InsaMain extends JFrame {

	private JPanel contentPane;
	private JButton btnInput,btnSearch,btnList,btnExit;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public InsaMain() {
		setTitle("인사관리 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(7, 5, 770, 70);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("인사관리프로그램(v1.0)");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 10, 700, 50);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(7, 80, 770, 400);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMain = new JLabel("");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setIcon(new ImageIcon(InsaMain.class.getResource("/xDatabase/images/01.jpg")));
		lblMain.setBounds(0, 0, 770, 400);
		pn2.add(lblMain);
		
		JPanel pn3 = new JPanel();
		pn3.setLayout(null);
		pn3.setBounds(7, 485, 770, 70);
		contentPane.add(pn3);
		
		btnInput = new JButton("사원등록");
		btnInput.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnInput.setBounds(34, 15, 150, 40);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnSearch.setBounds(218, 15, 150, 40);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체조회");
		btnList.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnList.setBounds(402, 15, 150, 40);
		pn3.add(btnList);
		
		btnExit = new JButton("작업종료");
		btnExit.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnExit.setBounds(586, 15, 150, 40);
		pn3.add(btnExit);
		
		/*============================================================*/
		//사원등록
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsaInput();
//				InsaInput frame = new InsaInput();
//				frame.setVisible(true);
			}
		});
		//사원 개별조회
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=JOptionPane.showInputDialog("조회할 사원의 성명을 입력하세요");
				InsaDAO dao=new InsaDAO();
				InsaVO vo=dao.getNameSearch(name);
				if(vo.getName()==null) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 사원명입니다.");
				} else new InsaSearch(vo);
					
//				new InsaSearch();
			}
		});
		//사원 전체목록
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//작업종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsaMain frame = new InsaMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
