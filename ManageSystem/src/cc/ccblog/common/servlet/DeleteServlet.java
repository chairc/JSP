/**
 *
 * @author GitHub ID : chairc
 *
 */
package cc.ccblog.common.servlet;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.ccblog.common.dao.UserDao;
import cc.ccblog.common.dao.UserDaoImpl;

@WebServlet("/DeleteServlet")
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int userId = Integer.parseInt(id);
		
		UserDao ud = new UserDaoImpl();
		
		if(ud.delete(userId)){
			System.out.println("--------------\n" + "删除1条---------成功\n" + "--------------");

			request.setAttribute("xiaoxi", "删除成功！");
			request.getRequestDispatcher("/Searchall").forward(request, response);
		}else{
			System.out.println("--------------\n" + "删除1条---------失败\n" + "--------------");

			request.setAttribute("xiaoxi", "删除失败！");
			request.getRequestDispatcher("/Searchall").forward(request, response);
			//response.sendRedirect("/jsp/others/Failure_new.jsp");
		}
	}
 
}
