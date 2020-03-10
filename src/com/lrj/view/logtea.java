package com.lrj.view;
import com.lrj.model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wzr.AddClassWindow;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class logtea extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public logtea(Teacher teacher) {
		setTitle("\u6559\u5E08");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("\u5F00\u8BBE\u5B9E\u9A8C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddClassWindow asw = new AddClassWindow(teacher);
					asw.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton button_1 = new JButton("\u4E0A\u4F20\u6210\u7EE9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpScoreFrm ups = new UpScoreFrm();
				ups.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton("\u8FD4\u56DE\u767B\u9646\u754C\u9762");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogOn og = new LogOn();
				dispose();
				og.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(130)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(169))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addComponent(button)
					.addGap(46)
					.addComponent(button_1)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addComponent(button_2)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
