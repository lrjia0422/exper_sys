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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.lrj.model.*;
import java.awt.Color;;
//import mysql.DBConnection;
@SuppressWarnings("serial")
public class TeacherInterFrm extends JInternalFrame {
	private JTextField teacher_id;
	private JTextField teacher_name;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherInterFrm frame = new TeacherInterFrm();
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
	public TeacherInterFrm() {
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setTitle("\u6559\u5E08\u6CE8\u518C");
		setBounds(100, 100, 450, 300);
		
		JLabel lblid = new JLabel("\u6559\u5E08id\uFF1A");
		
		teacher_id = new JTextField();
		teacher_id.setColumns(10);
		
		JLabel label = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		
		teacher_name = new JTextField();
		teacher_name.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u5BC6\u7801\uFF1A");
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblid)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(label_1)
									.addComponent(label)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(password)
								.addComponent(teacher_name)
								.addComponent(teacher_id, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1)))
					.addContainerGap(204, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(teacher_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblid))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(teacher_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void ZhuceActionPerformed(ActionEvent e) throws Exception {
		// 教师注册
		Teacher s=new Teacher();
		s.id=this.teacher_id.getText();
		s.userName=this.teacher_name.getText();
		s. password=this.password.getText();
		if ("".equals(s.id)) {
			JOptionPane.showMessageDialog(TeacherInterFrm.this, "请输入id!");
			return;
		} else if ("".equals(s.userName)) {
			JOptionPane.showMessageDialog(TeacherInterFrm.this, "请输入姓名!");
			return;
		}
		else if("".equals(s.password)){
			JOptionPane.showMessageDialog(TeacherInterFrm.this, "请输入密码!");
			return;
		}
		TeacherManger.add(s);
		JOptionPane.showMessageDialog(TeacherInterFrm.this, "添加成功");
		resetValueActionPerformed(e);
	}

	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.teacher_id.setText("");
		this.teacher_name.setText("");
		this.password.setText("");
	}

}
