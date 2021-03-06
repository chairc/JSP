/**
 *
 * @author GitHub ID : chairc
 *
 */
package cc.ccblog.garbage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.ccblog.entity.GarbageClass;
import cc.ccblog.garbage.dao.GarbageClassDao;
import cc.ccblog.garbage.dao.GarbageClassDaoImpl;

@WebServlet("/GarbageClassServlet")
@SuppressWarnings("serial")
public class GarbageClassServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//列表输出
		
		String searchgarbagename = new String(request.getParameter("searchgarbagename").getBytes("ISO-8859-1"),"utf-8");
		
		if(searchgarbagename.equals(null)) {
			GarbageClassDao gcd = new GarbageClassDaoImpl();
			List<GarbageClass> searchgarbage = gcd.searchgarbageall();
			request.setAttribute("searchgarbage", searchgarbage);
			request.getRequestDispatcher("/jsp/garbageclass/Garbage.jsp").forward(request, response);
			
			System.out.println("--------------\n" + "垃圾查询所有---------成功\n" + "--------------");
		}else {
			GarbageClassDao gcd = new GarbageClassDaoImpl();
			List<GarbageClass> searchgarbage = gcd.searchgarbage(searchgarbagename);
			request.setAttribute("searchgarbage", searchgarbage);
			request.getRequestDispatcher("/jsp/garbageclass/Garbage.jsp").forward(request, response);
			
			System.out.println("--------------\n" + "垃圾查询：" + searchgarbagename + "\n" + "--------------");
		}			
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}
	
}

