/**
 *
 * @author GitHub ID : chairc
 *
 */
package cc.ccblog.common.servlet;
 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import cc.ccblog.common.dao.JsonSelect;
import cc.ccblog.common.dao.UserDao;
import cc.ccblog.common.dao.UserDaoImpl;
import cc.ccblog.entity.User;

@WebServlet("/Searchall")
@SuppressWarnings("serial")
public class Searchall extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = (String) request.getSession().getAttribute("username");
		String pwd = (String) request.getSession().getAttribute("password");
		
		UserDao ud = new UserDaoImpl();
		if(ud.login(name, pwd)) {
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			JsonObject json=new JsonSelect().selectall();
			System.out.println(json);
			response.setHeader("Access-Control-Allow-Origin", "*");
			out.print(json);
			
			//System.out.println("--------------\n" + "Json查询所有用户---------成功\n" + "--------------");
		}else {
			if(name == null || pwd == null) {
				response.getWriter().print("<script>alert('Alert:Please login......');window.location.href='showinfo';</script>");
				
				//System.out.println("--------------\n" + "Json查询所有用户---------失败\n原因：未登录\n" + "--------------");
			}else {
				response.getWriter().print("<script>alert('Alert:Incorrect information verification!');window.location.href='showinfo';</script>");
			
				//System.out.println("--------------\n" + "Json查询所有用户---------失败\n原因：信息未验证正确\n" + "--------------");
			}
		}
		
		
		
		//列表输出
//		UserDao ud = new UserDaoImpl();
//		List<User> userAll = ud.getUserAll();
//		request.setAttribute("userAll", userAll);
//		request.getRequestDispatcher("/ShowAll.jsp").forward(request, response);

		
		//json数据集
//		response.setContentType("application/json;charset=UTF-8");
//		Gson gson=new Gson();
//		JsonArray jsonarray=new JsonArray();
//		JsonObject json=new JsonObject();
//		json.addProperty("code", 0);
//		json.addProperty("msg", "");
//		json.addProperty("count", 1000);
//		JsonElement infoString=gson.toJsonTree(userAll);
//		json.add("data", infoString);		
//		System.out.println(jsonarray);

		//普通json格式
//		Gson gson=new Gson();
//		String infoString=gson.toJson(userAll);
//		PrintWriter out = response.getWriter();
//		System.out.println(infoString);
//		out.write(infoString);		
//		out.close();
		
		
		
				
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}
	
}
