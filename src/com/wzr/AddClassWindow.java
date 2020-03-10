package com.wzr;
import com.lrj.model.*;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * @author 17130110097-王致茹
 */

public class AddClassWindow extends JFrame {

	private JPanel contentPane;
	private JTextField classInfo;
	private JLabel class_table;
	private JScrollPane scrollPane;
	private JFormattedTextField textFieldForMath; 
	private ButtonGroup group=new ButtonGroup();
	Test3 test=new Test3();
	
	private int am=0,pm=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher t=new Teacher();
					AddClassWindow frame = new AddClassWindow(t);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddClassWindow(Teacher teacher) throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1069, 787);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel msg1 = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		msg1.setFont(new Font("宋体", Font.PLAIN, 28));
		msg1.setBounds(113, 31, 154, 82);
		contentPane.add(msg1);
		
		classInfo = new JTextField();
		classInfo.setFont(new Font("宋体", Font.PLAIN, 28));
		classInfo.setBounds(276, 49, 200, 50);
		contentPane.add(classInfo);
		classInfo.setColumns(10);
		
		class_table = new JLabel("\u7A7A\u95F2\u6559\u5BA4\u8868\uFF1A");
		class_table.setFont(new Font("宋体", Font.PLAIN, 28));
		class_table.setBounds(113, 135, 191, 47);
		contentPane.add(class_table);
		
		JButton save = new JButton("\u4FDD\u5B58");
		save.addActionListener(new ActionListener() {//保存！！！！！！！！！！！！！！！！！！！！
			public void actionPerformed(ActionEvent e) {
				saveInfo(teacher.id);
			}
		});
		save.setBounds(235, 622, 153, 37);
		contentPane.add(save);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetInfo();
			}
		});
		reset.setBounds(511, 622, 153, 37);
		contentPane.add(reset);
		
		//打印空闲教室表
		scrollPane = new JScrollPane(test.PrintEmptyClass());
		scrollPane.setBounds(150, 195, 500, 200);
		contentPane.add(scrollPane);
		
		
		JLabel classroom_id = new JLabel("\u8F93\u5165\u6559\u5BA4\u7F16\u53F7\uFF1A");
		classroom_id.setFont(new Font("宋体", Font.PLAIN, 28));
		classroom_id.setBounds(113, 407, 200, 61);
		contentPane.add(classroom_id);
		
		JLabel time = new JLabel("\u9009\u62E9\u5B9E\u9A8C\u65F6\u95F4\uFF1A");
		time.setFont(new Font("宋体", Font.PLAIN, 28));
		time.setBounds(113, 472, 200, 29);
		contentPane.add(time);
		
		JButton updateTable = new JButton("\u5237\u65B0");//刷新空闲表
		updateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		updateTable.setFont(new Font("宋体", Font.PLAIN, 28));
		updateTable.setBounds(282, 141, 153, 37);
		contentPane.add(updateTable);
		
		MaskFormatter matter=null;  //只能输入两位数字的文本框
		try {
			matter=new MaskFormatter("###");
		} catch (ParseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		textFieldForMath= new JFormattedTextField(matter);
		textFieldForMath.setFont(new Font("宋体", Font.PLAIN, 30));
		textFieldForMath.setBounds(309, 419, 126, 35);
		contentPane.add(textFieldForMath);
		
		JRadioButton RBam = new JRadioButton("am");
		group.add(RBam);
		RBam.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getSource()==RBam){
					am=1;
				}
			}
		});
		
		RBam.setFont(new Font("宋体", Font.PLAIN, 28));
		RBam.setBounds(309, 461, 100, 50);
		
		
		JRadioButton RBpm = new JRadioButton("pm");
		group.add(RBpm);
		RBpm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getSource()==RBpm){
					pm=1;
				}
			}
		});
		RBpm.setFont(new Font("宋体", Font.PLAIN, 28));
		RBpm.setBounds(410, 461, 200, 50);
		contentPane.add(RBam);
		contentPane.add(RBpm);
	}
	private void resetInfo(){//重置函数
		classInfo.setText("");
		textFieldForMath.setText("");
		am=0;
		pm=0;
		group.clearSelection();
	}
	
	
	private void saveInfo(String teacher_id){//保存课程
		String exp_name=classInfo.getText();
		int classroom_id=0;
		String time=new String();
		//存入实验类
		if(exp_name.isEmpty()){
			JOptionPane.showMessageDialog(null, "实验名称不能为空");
			return;
		}
		else if(textFieldForMath.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "实验教室不能为空");
			return;
		}
		else if(am==0&&pm==0){
			JOptionPane.showMessageDialog(null, "实验时间不能为空");
			return;
		}
		classroom_id=Integer.valueOf(textFieldForMath.getText());
		if(am==1) time="am";
		else if(pm==1) time="pm";
		Experiment expr=new Experiment(exp_name,classroom_id,time);
		if(!test.checkExpreName(expr)){
			JOptionPane.showMessageDialog(null, "实验已存在");
			return;
		}
		if(!test.checkClassroom_id(expr)){
			JOptionPane.showMessageDialog(null, "没有这个教室");
			return;
		}
		if(!test.judgeClassroom(expr)){
			JOptionPane.showMessageDialog(null, "教室已被占用");
			return;
		}
		//不需要保存教室和开课状态
		try {
			int i=test.setAClass(expr, teacher_id);
			if(i==3){
				JOptionPane.showMessageDialog(null, "保存成功");
				resetInfo();
			}else {
				JOptionPane.showMessageDialog(null, "保存失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void updateTable(){//刷新空闲教室表
		try {
			scrollPane.setViewportView(test.PrintEmptyClass());
			contentPane.validate();
			contentPane.repaint();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

/*
 * 1、建一个自己的jtable模板，把输入课程编号改成选择
 */
