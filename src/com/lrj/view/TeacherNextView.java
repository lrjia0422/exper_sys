package com.lrj.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Frame;

@SuppressWarnings("serial")
public class TeacherNextView extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherNextView frame = new TeacherNextView();
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
	public TeacherNextView() {
		setExtendedState(Frame.MAXIMIZED_VERT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 493);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u6CE8\u518C");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u6559\u5E08\u6CE8\u518C");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherInterFrm tea=new TeacherInterFrm();
				tea.setVisible(true);
				table.add(tea);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5B66\u751F\u6CE8\u518C");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentInterFrm stu=new StudentInterFrm();
				stu.setVisible(true);
				table.add(stu);
			}
		});
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
	    table = new JDesktopPane();
	    table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
	}

	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
