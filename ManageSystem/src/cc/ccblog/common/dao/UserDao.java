/**
 *
 * @author GitHub ID : chairc
 *
 */
package cc.ccblog.common.dao;

import java.util.List;

import cc.ccblog.entity.User;

public interface UserDao {
	boolean login(String name,String pwd);//登录
	boolean register(User user);//注册
	String registevalidation(User user);//注册是重名验证优化方案
	List<User> getUserAll(int curPage);//返回用户信息集合
	boolean delete(int id) ;//根据id删除用户
	int getweight(String name);//判断登录信息权重

	boolean update(User user);//修改用户信息
	boolean updateUser(String name, String pwd,String sex, String home,String info) ;//修改用户信息
	
	boolean loginupdate(String name, String servertime, String ip, String system, String browsername);//更新登录时间并记录日志
	List<User> getUserLogAll(String name, int curPage);//登录日志总表查询
	
	List<User> retrieveaccount(String selectfindway, String findway, String safequestion, String safeanswer);//找回信息
		
	boolean Searchsafetyverification(String name);//验证数据库数据是否完整，不完整则强制修改信息
	List<User> safetyverification(String name);//强制修改信息界面信息加载
	String updatesafetyverification(User user);//强制修改信息是重名验证优化方案
	
	int eapagecount();
	int sllpagecount(String name);
	
	
}
