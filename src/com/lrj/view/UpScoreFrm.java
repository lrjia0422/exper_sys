package com.lrj.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.lrj.dao.upscoreDao;
import com.lrj.model.upscore;
import com.lrj.util.DbUtil;

import java.awt.Font;
import javax.swing.SpringLayout;
import java.awt.Label;
import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class UpScoreFrm extends JFrame {

	private JPanel contentPane;
	private JTextField exprNameTxt;
	private JTextField stuIdTxt;
	private JTextField chengjiTxt;
	private JTextField zuoyePiciTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private upscoreDao upd = new upscoreDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpScoreFrm frame = new UpScoreFrm();
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
	public UpScoreFrm() {
		setTitle("\u5B9E\u9A8C\u7BA1\u7406\u7CFB\u7EDF");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 438, 324);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("                   \u4E0A\u4F20\u6210\u7EE9");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewJgoodiesTitle, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewJgoodiesTitle, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewJgoodiesTitle, 427, SpringLayout.WEST, contentPane);
		lblNewJgoodiesTitle.setFont(new Font("微软雅黑 Light", Font.BOLD, 26));
		lblNewJgoodiesTitle.setForeground(Color.DARK_GRAY);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("\u5B9E\u9A8C\u540D");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewJgoodiesTitle_1, 29, SpringLayout.SOUTH, lblNewJgoodiesTitle);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewJgoodiesTitle_1, 10, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewJgoodiesTitle_1);
		
		JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("\u5B66\u751Fid");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewJgoodiesTitle_2, 26, SpringLayout.SOUTH, lblNewJgoodiesTitle_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewJgoodiesTitle_2, 0, SpringLayout.EAST, lblNewJgoodiesTitle_1);
		contentPane.add(lblNewJgoodiesTitle_2);
		
		JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory.getInstance().createTitle("\u4F5C\u4E1A\u6279\u6B21");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewJgoodiesTitle_3, 20, SpringLayout.SOUTH, lblNewJgoodiesTitle_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewJgoodiesTitle_3, 5, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewJgoodiesTitle_3);
		
		JLabel lblNewJgoodiesTitle_4 = DefaultComponentFactory.getInstance().createTitle("\u6210\u7EE9\r\n");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewJgoodiesTitle_4, 22, SpringLayout.SOUTH, lblNewJgoodiesTitle_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewJgoodiesTitle_4, 21, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewJgoodiesTitle_4);
		
		exprNameTxt = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, exprNameTxt, 0, SpringLayout.NORTH, lblNewJgoodiesTitle_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, exprNameTxt, 31, SpringLayout.EAST, lblNewJgoodiesTitle_1);
		contentPane.add(exprNameTxt);
		exprNameTxt.setColumns(10);
		
		stuIdTxt = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, stuIdTxt, 0, SpringLayout.NORTH, lblNewJgoodiesTitle_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, stuIdTxt, 0, SpringLayout.WEST, exprNameTxt);
		contentPane.add(stuIdTxt);
		stuIdTxt.setColumns(10);
		
		chengjiTxt = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, chengjiTxt, 0, SpringLayout.NORTH, lblNewJgoodiesTitle_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, chengjiTxt, 0, SpringLayout.WEST, exprNameTxt);
		contentPane.add(chengjiTxt);
		chengjiTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upscoreaddPerformed(e);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, button, 0, SpringLayout.EAST, exprNameTxt);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, button_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, button_1, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, button_1, -82, SpringLayout.EAST, contentPane);
		contentPane.add(button_1);
		
		zuoyePiciTxt = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, zuoyePiciTxt, 0, SpringLayout.NORTH, lblNewJgoodiesTitle_3);
		sl_contentPane.putConstraint(SpringLayout.EAST, zuoyePiciTxt, 0, SpringLayout.EAST, exprNameTxt);
		contentPane.add(zuoyePiciTxt);
		zuoyePiciTxt.setColumns(10);
	}
	
	private void upscoreaddPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
	     String exprname = this.exprNameTxt.getText(); 
		 String  stuid = this.stuIdTxt.getText();
		 String zuoyepici = this.zuoyePiciTxt.getText();
		 int chengji = Integer.parseInt(this.chengjiTxt.getText());
		 
		 upscore up = new upscore(exprname,stuid,zuoyepici,chengji);
		 Connection con = null;
		 try {
			 con = dbUtil.getConn();
			 int n = upd.addscore(con, up);
			 if(n == 1) {
				 JOptionPane.showMessageDialog(null, "上传成功");
				 resetValue();
				 }else {
					 JOptionPane.showMessageDialog(null, "上传失败");
				 }
			
		 }catch(Exception e) {
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(null, "上传失败");
		 }finally{
			 try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	}

	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();
		
	}

	private void resetValue() {
		this.exprNameTxt.setText("");
		this.stuIdTxt.setText("");
		this.chengjiTxt .setText("");
		this.zuoyePiciTxt.setText("");
		
	}

}

