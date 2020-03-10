package com.lrj.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lrj.dao.*;

import com.lrj.util.*;
import com.lrj.model.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryResultsView extends JFrame {

	private JPanel contentPane;
	private JTextField stuidTxt;
	private JTable scoretable;
	private DbUtil dbUtil=new DbUtil();
	private QueryResultsDao qrs=new QueryResultsDao();
	private QueryMessageDao qms=new QueryMessageDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryResultsView frame = new QueryResultsView();
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
	public QueryResultsView() {
		setTitle("\u67E5\u8BE2\u6210\u7EE9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblid = new JLabel("\u8BF7\u8F93\u5165\u5B66\u751Fid\uFF1A");
		
		stuidTxt = new JTextField();
		stuidTxt.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ScoreSearchActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stuidTxt, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(182)
							.addComponent(button)
							.addGap(108)
							.addComponent(button_1)))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblid, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(stuidTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		
		scoretable = new JTable();
		scoretable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B9E\u9A8C\u540D", "\u5B9E\u9A8C\u6279\u6B21", "\u6210\u7EE9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(scoretable);
		contentPane.setLayout(gl_contentPane);
		this.fillTable(new QueryResults());
	}
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.stuidTxt.setText("");
	}
	

	/**
	 * 查询成绩事件处理
	 * @param evt
	 */
	private void ScoreSearchActionPerformed(ActionEvent evt) {
		String stuid=this.stuidTxt.getText();
		
		if(StringUtil.isEmpty(stuid)) {
			JOptionPane.showMessageDialog(null, "学生id不能为空！");
			return;
		}
		QueryMessage qm=new QueryMessage(stuid);
		QueryResults qr=new QueryResults();
		Connection con1=null;
		try {
			con1=dbUtil.getConn();
			QueryMessage currentMessage=qms.Query(con1, qm);
			if(currentMessage!=null) {
				JOptionPane.showMessageDialog(null, "查询成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "查询失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询失败！");
		}finally {
			try {
				dbUtil.closeCon(con1);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		qr.setStudent_id(stuid);
		this.fillTable(qr);
	}

	private void fillTable(QueryResults qr) {
		DefaultTableModel dtm=(DefaultTableModel)scoretable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getConn();
			ResultSet rs=qrs.list(con, qr);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("expr_name"));
				v.add(rs.getString("pici"));
				v.add(rs.getInt("score"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
}
