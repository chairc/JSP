package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowInfo;
import dao.ShowInfoImpl;
import entity.MessageInfo;

//@WebServlet(urlPatterns = "/showinfoServlet",loadOnStartup = 1)
@SuppressWarnings("serial")
public class showinfo extends HttpServlet{
	
//	public showinfo() {
//		super();
//	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShowInfo sInfo=new ShowInfoImpl();
		List<MessageInfo> inforall=sInfo.showinfo();
		request.setAttribute("InfoAll", inforall);
		request.getRequestDispatcher("/Login_new.jsp").forward(request, response);
	}

}