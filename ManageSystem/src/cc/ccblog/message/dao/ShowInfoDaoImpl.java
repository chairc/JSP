	/**
	 * 
	 * @author GitHub ID : chairc
	 * 登录界面以及留言板 信息方法
	 * 
	 */
package cc.ccblog.message.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cc.ccblog.entity.MessageInfo;
import cc.ccblog.util.DBconn;

public class ShowInfoDaoImpl implements ShowInfoDao {

	/**
	 * 
	 * 展示登录界面信息
	 * 
	 */
	@Override
	public List<MessageInfo> showinfo() {
		// TODO Auto-generated method stub
		List<MessageInfo> m_list = new ArrayList<MessageInfo>();
		try {
			DBconn.init();
			ResultSet rs= DBconn.selectSql("select * from user_message_info");//select TOP 1 * from user_message_info order by id desc
			while (rs.next()) {
				MessageInfo ms=new MessageInfo();
				ms.setMessagemaintitle(rs.getString("m_main_title"));
				ms.setMessagetitle(rs.getString("m_title"));
				ms.setMessageinfo(rs.getString("m_info"));
				m_list.add(ms);
			}
					
			DBconn.closeConn();
			return m_list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return null;
	}

//	@Override
//	public List<MessageInfo> editinfo(){
//		List<MessageInfo> m_editall = new ArrayList<MessageInfo>();
//		try {
//			DBconn.init();
//			ResultSet rs= DBconn.selectSql("select * from user_message_info");
//			while (rs.next()) {
//				MessageInfo ms=new MessageInfo();
//				ms.setMessagemaintitle(rs.getString("m_main_title"));
//				ms.setMessagetitle(rs.getString("m_title"));
//				ms.setMessageinfo(rs.getString("m_info"));
//				m_editall.add(ms);
//			}
//					
//			DBconn.closeConn();
//			return m_editall;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

	
	/**
	 * 
	 * 更新登录界面信息
	 * 
	 */
	@Override
	public boolean update(int messageid,String messagemaintitle ,String messagetitle,String messageinfo) {
		boolean flag = false;
		DBconn.init();
		String sql ="update user_message_info set m_main_title ='"+messagemaintitle
				+"' , m_title ='"+messagetitle
				+"' , m_info ='"+messageinfo+"' where m_id = "+messageid;
//		System.out.println(sql);//控制台纠错
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}



	
	
	

	/**
	 * 
	 * 留言板显示信息
	 * 
	 */
	@Override
	public List<MessageInfo> showmsinfo(int Page) {
		int i=1;
		int curPage = Page - i;
		int pageSize = 10;
		int startRow = (curPage) * pageSize;		
		
		List<MessageInfo> msg_list = new ArrayList<MessageInfo>();
		try {
			DBconn.init();
			ResultSet rs= DBconn.selectSql("select * from user_message order by addmessageid desc limit "+startRow+",10");
			while (rs.next()) {
				MessageInfo setms=new MessageInfo();
				setms.setAddmessageid(rs.getInt("addmessageid"));
				setms.setAddmessagename(rs.getString("addmessagename"));
				setms.setAddmessageinfo(rs.getString("addmessageinfo"));
				setms.setServertime(rs.getString("servertime"));
				msg_list.add(setms);
			}
					
			DBconn.closeConn();
			return msg_list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return null;
	}


	/**
	 * 
	 * 留言板存入信息
	 * 
	 */
	@Override
	public boolean addmsinfo(MessageInfo msg) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into user_message(addmessagename,addmessageinfo,servertime)" +
				"values('"+msg.getAddmessagename()+"','"+msg.getAddmessageinfo()+"','"+msg.getServertime()+"')");		
		if(i>0){
			flag = true;		
		}
		DBconn.closeConn();
		return flag;
	}

	@Override
	public int msgpagecount() {
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from user_message");
			int rowCount = 0;
			while(rs.next()) {
			    rowCount++;
			}
			DBconn.closeConn();
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
