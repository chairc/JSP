package dao;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.User;
import util.DBconn;
 
public class UserDaoImpl implements UserDao{
	
	public boolean register(User user) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into user_info(name,pwd,sex,home,info)" +
				"values('"+user.getName()+"','"+user.getPwd()+"','"+user.getSex()+"','"+user.getHome()+"','"+user.getInfo()+"')");			
		if(i>0){
			flag = true;		
		}
		DBconn.closeConn();
		return flag;
				
		/*try {   //注册冲突验证
			DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from user_info where name='"+user.getName()+"'");
			//rs为数据的查询出来的结果集
			while(rs.next()) {			//判断结果集中是否有内容
				if(user.getName().equals(rs.getString("name"))) {  //从rs中取出记录的name字段，和传入的参数name做比较
					//如果相等，则执行以下代码
					return flag;
				}else {					
					int i =DBconn.addUpdDel("insert into user_info(name,pwd,sex,home,info) " +
							"values('"+user.getName()+"','"+user.getPwd()+"','"+user.getSex()+"','"+user.getHome()+"','"+user.getInfo()+"')");			
					if(i>0){
						flag = true;		
					}
					DBconn.closeConn();
					return flag;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;*/
	}
	
    public boolean login(String name, String pwd) {//登陆
		boolean flag = false;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from user_info where name='"+name+"' and pwd='"+pwd+"'");
				while(rs.next()){
					if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){
						flag = true;
					}
				}
				DBconn.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
    
	public List<User> getUserAll() {//输出数据库user_info内容
		List<User> list = new ArrayList<User>();
    	try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from user_info");
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setSex(rs.getString("sex"));
				user.setHome(rs.getString("home"));
				user.setInfo(rs.getString("info"));
				list.add(user);
			}
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean update(int id,String name, String pwd,String sex, String home,String info) {//更新数据库内容
		boolean flag = false;
		DBconn.init();
		String sql ="update user_info set name ='"+name
				+"' , pwd ='"+pwd
				+"' , sex ='"+sex
				+"' , home ='"+home
				+"' , info ='"+info+"' where id = "+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	
	public boolean delete(int id) {
		boolean flag = false;
		DBconn.init();
		String sql = "delete  from user_info where id="+id;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	@Override
	public boolean registevalidation(String name) {//注册冲突验证
		boolean flag = true;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from user_info where name='"+name+"'");
				while(rs.next()){
					if(rs.getString("name").equals(name)){
						flag = false;
					}
				}
				DBconn.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateUser(String name, String pwd, String sex, String home, String info) {
		boolean flag = false;
		DBconn.init();
		String sql ="update user_info set name ='"+name
				+"' , pwd ='"+pwd
				+"' , sex ='"+sex
				+"' , home ='"+home
				+"' , info ='"+info+"' where name='"+name+"'";
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	




//	@Override
//	public boolean remember(String name) {
//		boolean flag = false;
//		try {
//			    DBconn.init();
//				ResultSet rs = DBconn.selectSql("select * from user_info where name='"+name+"'");
//				while(rs.next()){
//					if(rs.getString("name").equals(name)){
//						flag = true;
//					}
//				}
//				
//				DBconn.closeConn();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}
    
}
