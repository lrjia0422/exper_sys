package com.lrj.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.lrj.dao.Manager;
import com.lrj.model.Student;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class StudentInterFrm extends JInternalFrame {
	private JTextField student_id;
	private JTextField student_name;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInterFrm frame = new StudentInterFrm();
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
	public StudentInterFrm() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("\u5B66\u751F\u6CE8\u518C");
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblid = new JLabel("\u5B66\u751Fid\uFF1A");
		
		student_id = new JTextField();
		student_id.setColumns(10);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		
		student_name = new JTextField();
		student_name.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u5BC6\u7801\uFF1A");
		
		password = new JTextField();
		password.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ZhuceActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(lblid)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(button)
							.addComponent(label_1)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(password)
								.addComponent(student_name)
								.addComponent(student_id, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1)))
					.addContainerGap(183, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(student_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblid))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(student_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(27))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void ZhuceActionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		Student s=new Student();
		s.id=this.student_id.getText();
		s.userName=this.student_name.getText();
		s. password=this.password.getText();
		if ("".equals(s.id)) {
			JOptionPane.showMessageDialog(StudentInterFrm.this, "请输入id!");
			return;
		} else if ("".equals(s.userName)) {
			JOptionPane.showMessageDialog(StudentInterFrm.this, "请输入姓名!");
			return;
		}
		else if("".equals(s.password)){
			JOptionPane.showMessageDialog(StudentInterFrm.this, "请输入密码!");
			return;
		}
		Manager.add(s);
		JOptionPane.showMessageDialog(StudentInterFrm.this, "添加成功");
		resetValueActionPerformed(e);
	}

	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.student_id.setText("");
		this.student_name.setText("");
		this.password.setText("");
	}

}
