package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowInfo;
import dao.ShowInfoImpl;
import entity.MessageInfo;

@WebServlet("/MessageServlet")
@SuppressWarnings("serial")
public class MessageServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("page")!=null) {
			String page = new String(request.getParameter("page").getBytes("ISO-8859-1"),"utf-8");
			int curPage = Integer.parseInt(page);
			request.getSession().setAttribute("pagenum",page);
			
			ShowInfo addms=new ShowInfoImpl();
			List<MessageInfo> addmsall=addms.showmsinfo(curPage);
			request.setAttribute("MessageAll", addmsall);
			request.getRequestDispatcher("/jsp/message/Message.jsp").forward(request, response);
		}else {
			String page="1";
			int curPage = 1;
			request.getSession().setAttribute("pagenum",page);
			
			ShowInfo addms=new ShowInfoImpl();
			List<MessageInfo> addmsall=addms.showmsinfo(curPage);
			request.setAttribute("MessageAll", addmsall);
			request.getRequestDispatcher("/jsp/message/Message.jsp").forward(request, response);
		}
		
	}
}