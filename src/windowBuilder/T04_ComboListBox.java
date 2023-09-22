package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

public class T04_ComboListBox extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T04_ComboListBox frame = new T04_ComboListBox();
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
	public T04_ComboListBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(11, 7, 375, 300);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblJob = new JLabel("직업을 선택하세요");
		lblJob.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 18));
		lblJob.setHorizontalAlignment(SwingConstants.CENTER);
		lblJob.setBounds(37, 22, 300, 30);
		pn1.add(lblJob);
		
		JComboBox comboJob = new JComboBox();
		comboJob.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"회사원", "학생", "군인", "의사", "판사", "변호사", "검사", "요리사", "프리랜서", "기타리스트", "기타"}));
		comboJob.setBounds(37, 74, 300, 30);
		pn1.add(comboJob);
		
		JList listFood = new JList();
		listFood.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		listFood.setModel(new AbstractListModel() {
			String[] values = new String[] {"그냥 리스트는", "사이즈를 벗어난 내용을", "보여주지 않음. . .", "라면", "돈까스", "피자", "치킨", "초콜릿", "볶음밥", "제육볶음", "불고기", "도시락", "김밥", "샐러드", "음료수"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listFood.setBounds(37, 126, 300, 150);
		pn1.add(listFood);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(397, 7, 375, 300);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblFood = new JLabel("좋아하는 음식을 선택하세요");
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 18));
		lblFood.setBounds(37, 22, 300, 30);
		pn2.add(lblFood);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 75, 300, 200);
		pn2.add(scrollPane);
		
		JList listFood2 = new JList();
		listFood2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		listFood2.setModel(new AbstractListModel() {
			String[] values = new String[] {"탕수육", "라면", "돈까스", "피자", "짜장면", "짬뽕", "치킨", "초콜릿", "볶음밥", "제육볶음", "불고기", "도시락", "김밥", "샐러드", "음료수"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listFood2);
		
		JPanel pn3 = new JPanel();
		pn3.setBackground(new Color(204, 204, 204));
		pn3.setBounds(12, 401, 760, 150);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMsg = new JLabel("출 력 창");
		lblMsg.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 16));
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(15, 10, 400, 130);
		pn3.add(lblMsg);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(427, 10, 321, 130);
		pn3.add(scrollPane_1);
		
		JTextArea txtaMsg = new JTextArea();
		scrollPane_1.setViewportView(txtaMsg);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(11, 314, 760, 80);
		contentPane.add(pn4);
		pn4.setLayout(null);
		
		JButton btnCombo = new JButton("콤보출력");
		btnCombo.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		btnCombo.setBounds(26, 20, 120, 40);
		pn4.add(btnCombo);
		
		JButton btnList = new JButton("리스트출력3");
		btnList.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		btnList.setBounds(464, 20, 120, 40);
		pn4.add(btnList);
		
		JButton btnExit = new JButton("종 료");
		btnExit.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 14));
		btnExit.setBounds(610, 20, 120, 40);
		pn4.add(btnExit);
		
		JButton btnList1 = new JButton("리스트출력1");
		btnList1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		btnList1.setBounds(172, 20, 120, 40);
		pn4.add(btnList1);
		
		JButton btnList2 = new JButton("리스트출력2");
		btnList2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		btnList2.setBounds(318, 20, 120, 40);
		pn4.add(btnList2);
		
		
		/*--------------------------------------------------------------*/
		
		//리스트박스의 내용을 출력하는 버튼
		
		//콤보박스 선택내용 출력처리 버튼
		btnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg=comboJob.getSelectedItem().toString();
				lblMsg.setText(msg);
			}
		});
		//리스트 박스의 내용을 출력하는 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaMsg.append(listFood2.getSelectedValue().toString()+"\n");
				
			}
		});
		btnList1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] foods=listFood2.getSelectedValuesList().toArray();
				String food="";
				for(Object f : foods) food += f+"/";
				lblMsg.setText(food);
				
			}
		});
		btnList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] foods=listFood2.getSelectedValuesList().toArray();
				/*
				String food="";
				for(Object f : foods) {
					food += f+"\n";
				}
				txtaMsg.setText(food);
				*/
				
				for(Object f: foods) {
					txtaMsg.append(f.toString()+"\n");
				}
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
