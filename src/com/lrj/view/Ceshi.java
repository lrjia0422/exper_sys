package com.lrj.view;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lrj.dao.*;
import com.lrj.model.*;
import com.lrj.util.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ceshi extends JFrame {

	private JPanel contentPane;
	private JTable exprTable;
	private DbUtil dbUtil=new DbUtil();
    private ExprDao exprDao=new ExprDao();
    private CHOOSEDao chooseDao=new CHOOSEDao();
    private ChooseMessageDao cmd=new ChooseMessageDao();
    private JLabel lblid;
    private JTextField stuidTxt;
    private JButton btnNewButton;
    private JButton button;
    private JLabel label;
    private JTextField exprnameTxt;
    private JLabel label_1;
    private JTable classtable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ceshi frame = new Ceshi();
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
	public Ceshi() {
		setTitle("\u5B66\u751F\u9009\u8BFE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblid = new JLabel("\u8BF7\u8F93\u5165\u5B66\u751Fid\uFF1A");
		
		stuidTxt = new JTextField();
		stuidTxt.setColumns(10);
		
		btnNewButton = new JButton("\u786E\u8BA4\u9009\u8BFE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			chooseAddActionPerformed(e);
			}
		});
		
		button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		label = new JLabel("\u8BF7\u8F93\u5165\u5B9E\u9A8C\u540D\u79F0\uFF1A");
		
		exprnameTxt = new JTextField();
		exprnameTxt.setColumns(10);
		
		label_1 = new JLabel("\u53EF\u9009\u5B9E\u9A8C");
		
		JLabel label_2 = new JLabel("\u5DF2\u9009\u5B9E\u9A8C");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton button_1 = new JButton("\u67E5\u770B\u5DF2\u9009\u5B9E\u9A8C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(193)
							.addComponent(label_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)))
					.addGap(56))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(75, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(23, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
									.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
								.addComponent(label, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(stuidTxt)
								.addComponent(exprnameTxt, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
							.addContainerGap(116, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(button_1)
							.addGap(64)
							.addComponent(button)
							.addGap(131))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(stuidTxt, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(exprnameTxt, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		
		classtable = new JTable();
		classtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5DF2\u9009\u5B9E\u9A8C"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(classtable);
		
		exprTable = new JTable();
		exprTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B9E\u9A8C\u540D", "\u65E5\u671F", "\u6559\u5BA4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(exprTable);
		contentPane.setLayout(gl_contentPane);
		
		this.fillTable1(new Expr());
		this.fillTable2(new CHOOSE());
	}
	


	private void LookActionPerformed(ActionEvent evt) {
		String stu_id=this.stuidTxt.getText();
		CHOOSE choose=new CHOOSE(stu_id);
		Connection con=null;
		try {
			con=dbUtil.getConn();
			CHOOSE currentchoose=chooseDao.judge(con,choose);
			if(currentchoose!=null) {
				JOptionPane.showMessageDialog(null, "查看选课成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "查看选课失败！");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查看选课失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		this.fillTable2(choose);
	}

	/**
	 * 学生选课添加事件处理
	 * @param evt
	 */
	private void chooseAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String stu_id=this.stuidTxt.getText();
		String expr_name=this.exprnameTxt.getText();
		if(StringUtil.isEmpty(stu_id)) {
			JOptionPane.showMessageDialog(null, "学生id不能为空！");
			return;
		}
		if(StringUtil.isEmpty(expr_name)) {
			JOptionPane.showMessageDialog(null, "实验名称不能为空！");
			return;
		}
		ChooseMessage cm=new ChooseMessage(stu_id,expr_name);
		CHOOSE choose=new CHOOSE(stu_id,expr_name);
		Connection con=null;
		try {
			con=dbUtil.getConn();
			int n=chooseDao.add(con, choose);
			ChooseMessage currentMessage=cmd.choose(con,cm);
			if(n==1&&currentMessage!=null) {
				JOptionPane.showMessageDialog(null, "选课成功！");
				resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "选课失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "选课失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
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
		this.exprnameTxt.setText("");
	}
	
	
	/**
	 * 插入可选实验表格
	 * @param expr
	 */
	private void fillTable1(Expr expr) {
		DefaultTableModel dtm=(DefaultTableModel) exprTable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getConn();
			ResultSet rs=exprDao.list(con);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("name"));
				v.add(rs.getString("date"));
				v.add(rs.getInt("classroom_id"));
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
	/**
	 * 插入查看选课的表格
	 * @param choose
	 */
	private void fillTable2(CHOOSE choose) {
		
		DefaultTableModel dtm=(DefaultTableModel) classtable.getModel();
		dtm.setRowCount(0);
		Connection con=null;
		try {
			con=dbUtil.getConn();
			ResultSet rs=chooseDao.list(con,choose);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("expr_name"));
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

	