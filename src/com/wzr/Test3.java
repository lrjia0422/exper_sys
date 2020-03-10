package com.wzr;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.awt.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lrj.util.DBhelper;



public class Test3 {	 
	
	 DBhelper db=new DBhelper();
	 
	 public JTable PrintEmptyClass()throws SQLException{//��ӡ���н��ұ�
			  String[] columnNames={"���ұ��","����","����"};
			  DefaultTableModel situation=new DefaultTableModel();
			  situation.setColumnIdentifiers(columnNames);//�½���
			  String s="select id,am_status,pm_status from classroom where am_status=0 or pm_status=0";
			  PreparedStatement ps=db.getPStatement(s);
			  ResultSet rs=ps.executeQuery();
			  System.out.println("classroom_id\tam\t\tpm\t");
			  while(rs.next()){
			    	System.out.print(rs.getString(1)+"\t\t");
			    	String classroom_name=rs.getString(1);
			    	Object am=new Object();
			    	Object pm=new Object();
			    	if(!rs.getBoolean(2)){
			    		System.out.print("available");
			    		am="available";
			    	}else{
			    		System.out.print("unavailable");
			    		am="unavailable";
			    	}
			    	System.out.print("\t");
			    	if(!rs.getBoolean(3)){
			    		System.out.print("available");
			    		pm="available";
			    	}else{
			    		System.out.print("unavailable");
			    		pm="unavailable";
			    	}
			    	
			    	System.out.print("\n");
			    	situation.addRow(new Object[]{classroom_name,am,pm});
			    }
			  JTable table=new JTable(situation);
			  table.setFont(new Font("����", Font.PLAIN, 28));
			  table.setRowHeight(30);
			  return table;
		  }
	 
		  public boolean judgeClassroom(Experiment exp){//ʱ���Ƿ�Ϸ�X
			  PreparedStatement ps=null;
			  try{
			  if(exp.date.equals("am")){
			  String s="select id from classroom where am_status=1";
			  ps=db.getPStatement(s);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()){
				  if(exp.Classroom_id==rs.getInt(1)){
					 return false;
				  }
			  }
			  }
			  else if(exp.date.equals("pm")){
				  String s="select id from classroom where pm_status=1";
				  ps=db.getPStatement(s);
				  ResultSet rs=ps.executeQuery();
				  while(rs.next()){
					  if(exp.Classroom_id==rs.getInt(1)){
						 return false;
					  }
				  }
				  }
			  }catch(SQLException e){
				  e.printStackTrace();
			  }
			  return true;
		  }
		  
		  public int setAClass(Experiment exp, String teacher)throws SQLException{//����γ�
			  PreparedStatement ps=null;
			  String order;
			  int preceed=0;
			  //����ʵ���
			  order="insert into expr values(?,?,?);";
			  ps=db.getPStatement(order);
			  ps.setString(1, exp.exp_name);
			  ps.setString(2,exp.date);
			  ps.setInt(3, exp.Classroom_id);
			  ps.executeUpdate();
			  preceed++;
			  //���¿��α�
			  order="insert into set_a_class values(?,?);";
			  ps=db.getPStatement(order);
			  ps.setString(1, teacher);
			  ps.setString(2,exp.exp_name);
			  ps.executeUpdate();
			  preceed++;
			  //���½��ұ�
			  if(exp.date.equals("am")){
				order="update classroom set am_status=? where id=?";
				ps=db.getPStatement(order);
				ps.setInt(1,1);
				ps.setInt(2,exp.Classroom_id);
				ps.executeUpdate();
				preceed++;
			  }
			  else{
			    order="update classroom set pm_status=? where id=?";
			    ps=db.getPStatement(order);
		        ps.setInt(1,1);
			    ps.setInt(2,exp.Classroom_id);
			    ps.executeUpdate();
			    preceed++;
			  }
			  ps.close();
			  return preceed;
		  }
		  
		  public boolean checkExpreName(Experiment expr){//���ʵ����
			  PreparedStatement ps=null;
			  String order="select name from expr";
			  try {
				ps=db.getPStatement(order);
				ResultSet rs=ps.executeQuery();
				  while(rs.next()){
					  if(rs.getString(1).equals(expr.exp_name)) return false;
				  }
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			  return true;
		  }
		  
		  public boolean checkClassroom_id(Experiment expr){//��������
			  PreparedStatement ps=null;
			  String order="select id from classroom";
			  try {
					ps=db.getPStatement(order);
					ResultSet rs=ps.executeQuery();
					  while(rs.next()){
						  if(rs.getInt(1)==expr.Classroom_id) return true;
					  }
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				  return false;
		  }
		}

/*  ʣ�µ����⣺
 * ��ô��radiobutton����ֻ�ܵ�ѡ
 * �ǲ��ǿ��԰�judge����ɾ����
 * �¼�������
 * 1���γ�������ô���뵽��ˡ���ѡ��������ô���뵽���
 * 2�����水ť�¼���Ӧ
 * 3���Ű�����
 * 4��
 * */
