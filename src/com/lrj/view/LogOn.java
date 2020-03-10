package com.lrj.view;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.lrj.util.DBConnection;
import com.lrj.dao.Manager;
import com.lrj.model.*;
import java.awt.Color;
import javax.swing.SwingConstants;

//import login.Login;
@SuppressWarnings({ "serial", "unused" })
public class LogOn extends JFrame {
    public String id ;
	private Font fontLogo = new Font("����", 1, 20);
	private JLabel jlLogo = new JLabel("ʵ�����ϵͳ");
	private Font font = new Font("����", 1, 25);
	private JLabel jlLogin = new JLabel("��ʦ��¼");
	String[] post = { "��ʦ", "ѧ��" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox jcbPost = new JComboBox(post);
	private JLabel jlID = new JLabel("��ʦ��:");
	private JTextField jtfID = new JTextField(20);
	private JLabel jlPassword = new JLabel("����:");
	private JPasswordField jpfPassword = new JPasswordField(20);
	private JButton jbLogin = new JButton("��¼");
	private JButton jbCancel = new JButton("�˳�");
	// ���ñ���ͼƬ
	private JLabel jlImage = new JLabel();
	private ImageIcon iiImage;
	private final JButton button = new JButton("\u6CE8\u518C");

	@SuppressWarnings("deprecation")
	public LogOn() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("ʵ�����ϵͳ��¼");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		iiImage = new ImageIcon("image/3.jpg");
		jlImage.setIcon(iiImage);
		jlImage.setSize(400, 300);
		jlImage.setLocation(0, 0);
		getLayeredPane().add(jlImage, new Integer(Integer.MIN_VALUE));
		JPanel jp = (JPanel) getContentPane();
		jp.setOpaque(false);
		init();
	}

	public void init() {
		jlLogo.setLocation(133, 0);
		jlLogo.setSize(250, 40);
		jlLogo.setFont(fontLogo);

		getContentPane().add(jlLogo);
		jlLogin.setFont(font);
		jlLogin.setLocation(140, 30);
		jlLogin.setSize(150, 50);
		getContentPane().add(jlLogin);

		jcbPost.setLocation(150, 75);
		jcbPost.setSize(80, 25);
		jcbPost.setFocusable(false);
		// ��ӵ�¼����Ľ�ɫѡ�����
		jcbPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbPost.getSelectedItem().equals("ѧ��")) {
					jlLogin.setText("ѧ����¼");
					jlID.setText("ѧ��:");
				} else {
					jlLogin.setText("��ʦ��¼");
					jlID.setText("��ʦ��:");
				}
			}
		});
		getContentPane().add(jcbPost);

		jlID.setLocation(80, 120);
		jlID.setSize(50, 30);
		getContentPane().add(jlID);
		jtfID.setLocation(130, 120);
		jtfID.setSize(150, 25);
		getContentPane().add(jtfID);
		jlPassword.setLocation(80, 160);
		jlPassword.setSize(50, 30);
		getContentPane().add(jlPassword);
		jpfPassword.setLocation(130, 160);
		jpfPassword.setSize(150, 25);
		getContentPane().add(jpfPassword);
		jbLogin.setBackground(Color.WHITE);

		// ������¼��ť
		jbLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jcbPost.getSelectedItem().equals("��ʦ")) {
				id=jtfID.getText().trim();
				String password = String.valueOf(jpfPassword.getPassword()).trim();
				if ("".equals(id)) {
					JOptionPane.showMessageDialog(LogOn.this, "�������ʦ��!");
					return;
				} else if ("".equals(password)) {
					JOptionPane.showMessageDialog(LogOn.this, "����������!");
					return;
				}
				try {
					Teacher teacher = TeacherManger.check(id, password);
			
					dispose();
					logtea ft = new logtea(teacher);
					ft.setVisible(true);
					//setVisible(false);
					//new StudentGrade(student, false).setVisible(true);
					JOptionPane.showMessageDialog(LogOn.this, "��¼�ɹ�");
				} catch (StudentNotFoundException e1) {
					JOptionPane.showMessageDialog(LogOn.this, "��ʦ�Ų�����");
				}catch(PasswordNotFoundException e2) {
					JOptionPane.showMessageDialog(LogOn.this, "�������");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				/*if (jcbPost.getSelectedItem().equals("jiaoshi")) {
					if (jtfID.getText().trim().equals("999999")
							&& String.valueOf(jpfPassword.getPassword()).trim()
									.equals("999999")) {
						setVisible(false);
						//new Teacher().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(LogOn.this,
								"��¼ʧ��!");
					}
				}*/ else {
					String id = jtfID.getText().trim();
					String password = String.valueOf(jpfPassword.getPassword())
							.trim();
					if ("".equals(id)) {
						JOptionPane.showMessageDialog(LogOn.this, "������ѧ��!");
						return;
					} else if ("".equals(password)) {
						JOptionPane.showMessageDialog(LogOn.this, "����������!");
						return;
					}
					try {
						Student student = Manager.check(id, password);
						setVisible(false);
						dispose();
						logstu ls = new logstu();
						ls.setVisible(true);
						//new StudentGrade(student, false).setVisible(true);
						JOptionPane.showMessageDialog(LogOn.this, "��¼�ɹ�");
					} catch (StudentNotFoundException e1) {
						JOptionPane.showMessageDialog(LogOn.this, "ѧ�Ų�����");
					}catch(PasswordNotFoundException e2) {
						JOptionPane.showMessageDialog(LogOn.this, "�������");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		jbLogin.setLocation(100, 200);
		jbLogin.setSize(80, 30);
		getContentPane().add(jbLogin);

		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jbCancel.setLocation(200, 200);
		jbCancel.setSize(80, 30);
		getContentPane().add(jbCancel);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new TeacherNextView().setVisible(true);
			}
		});
		button.setBounds(290, 200, 93, 30);
		
		getContentPane().add(button);
	}
	public static void main(String[] args) throws Exception {
		/*try {
			//Link.getcon();
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}*/
		new LogOn().setVisible(true);
	}
}
