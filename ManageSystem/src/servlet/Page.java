package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShowInfo;
import dao.ShowInfoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.MessageInfo;
import entity.User;

@SuppressWarnings("serial")
public class Page extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = (String) request.getSession().getAttribute("username");// 获取session中的用户名数据

		String sapageprve = request.getParameter("sapageprev");
		String sapagenext = request.getParameter("sapagenext");

		String mapageprve = request.getParameter("mapageprev");
		String mapagenext = request.getParameter("mapagenext");

		String sllpageprve = request.getParameter("sllpageprev");
		String sllpagenext = request.getParameter("sllpagenext");

		String maipageprve = request.getParameter("maipageprev");
		String maipagenext = request.getParameter("maipagenext");
		int i = 1;

		// 编辑所有用户上一页
		if (sapageprve != null && request.getParameter("page") != null) {
			String page = new String(request.getParameter("page").getBytes("ISO-8859-1"), "utf-8");

			int curPage = Integer.parseInt(page) - i;
			String newpage = String.valueOf(curPage);
			request.getSession().setAttribute("pagenum", newpage);

			UserDao ud = new UserDaoImpl();
			List<User> userAll = ud.getUserAll(curPage);
			request.setAttribute("userAll", userAll);
			request.getRequestDispatcher("/ShowAll.jsp").forward(request, response);
		}
		// 编辑所有用户下一页
		if (sapagenext != null && request.getParameter("page") != null) {
			String page = new String(request.getParameter("page").getBytes("ISO-8859-1"), "utf-8");

			int curPage = Integer.parseInt(page) + i;
			String newpage = String.valueOf(curPage);
			request.getSession().setAttribute("pagenum", newpage);

			UserDao ud = new UserDaoImpl();
			List<User> userAll = ud.getUserAll(curPage);
			request.setAttribute("userAll", userAll);
			request.getRequestDispatcher("/ShowAll.jsp").forward(request, response);
		}
		// 后台留言板上一页
		if (mapageprve != null && request.getParameter("page") != null) {
			String page = new String(request.getParameter("page").getBytes("ISO-8859-1"), "utf-8");

			int curPage = Integer.parseInt(page) - i;
			String newpage = String.valueOf(curPage);
			request.getSession().setAttribute("pagenum", newpage);

			ShowInfo addms = new ShowInfoImpl();
			List<MessageInfo> addmsall = addms.showmsinfo(curPage);
			request.setAttribute("MessageAll", addmsall);
			request.getRequestDispatcher("/Message.jsp").forward(request, response);
		}
		// 后台留言板下一页
		if (mapagenext != null && request.getParameter("page") != null) {
			String page = new String(request.getParameter("page").getBytes("ISO-8859-1"), "utf-8");

			int curPage = Integer.parseInt(page) + i;
			String newpage = String.valueOf(curPage);
			request.getSession().setAttribute("pagenum", newpage);

			ShowInfo addms = new ShowInfoImpl();
			List<MessageInfo> addmsall = addms.showmsinfo(curPage);
			request.setAttribute("MessageAll", addmsall);
			request.getRequestDispatcher("/Message.jsp").forward(request, response);
		}
		// 日志文件上一页
		if (sllpageprve != null && request.getParameter("page") != null) {
			String page = new String(request.getParameter("page").getBytes("ISO-8859-1"), "utf-8");

			int curPage = Integer.parseInt(page) - i;
			String newpage = String.valueOf(curPage);
			request.getSession().setAttribute("pagenum", newpage);

			UserDao ud = new UserDaoImpl();
			List<User> userLogAll = ud.getUserLogAll(s, curPage);
			request.setAttribute("userLogAll", userLogAll);
			request.getRequestDispatcher("/SearchLoginLog.jsp").forward(request, response);
		}
		// 日志文件下一页
		if (sllpagenext != null && request.getParameter("page") != null) {
			String page = new String(request.getParameter("page").getBytes("ISO-8859-1"), "utf-8");

			int curPage = Integer.parseInt(page) + i;
			String newpage = String.valueOf(curPage);
			request.getSession().setAttribute("pagenum", newpage);

			UserDao ud = new UserDaoImpl();
			List<User> userLogAll = ud.getUserLogAll(s, curPage);
			request.setAttribute("userLogAll", userLogAll);
			request.getRequestDispatcher("/SearchLoginLog.jsp").forward(request, response);
		}
		// Blog留言板上一页
		if (maipageprve != null && request.getParameter("page") != null) {
			String page = new String(request.getParameter("page").getBytes("ISO-8859-1"), "utf-8");

			int curPage = Integer.parseInt(page) - i;
			String newpage = String.valueOf(curPage);
			request.getSession().setAttribute("pagenum", newpage);

			ShowInfo addms = new ShowInfoImpl();
			List<MessageInfo> addmsall = addms.showmsinfo(curPage);
			request.setAttribute("MessageAll", addmsall);
			request.getRequestDispatcher("/Message_Index.jsp").forward(request, response);
		}
		// Blog留言板下一页
		if (maipagenext != null && request.getParameter("page") != null) {
			String page = new String(request.getParameter("page").getBytes("ISO-8859-1"), "utf-8");

			int curPage = Integer.parseInt(page) + i;
			String newpage = String.valueOf(curPage);
			request.getSession().setAttribute("pagenum", newpage);

			ShowInfo addms = new ShowInfoImpl();
			List<MessageInfo> addmsall = addms.showmsinfo(curPage);
			request.setAttribute("MessageAll", addmsall);
			request.getRequestDispatcher("/Message_Index.jsp").forward(request, response);
		}
	}
}