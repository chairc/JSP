	/**
	 * 
	 * @author GitHub ID : chairc
	 * 文章
	 * 
	 */
package cc.ccblog.article.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cc.ccblog.entity.Article;
import cc.ccblog.util.DBconn;

public class ArticleDaoImpl implements ArticleDao{

	/**
	 * 
	 * 展示所有文章列表
	 * 
	 */
	public List<Article> showartinfo(int Page) {
		int i=1;
		int curPage = Page - i;
		int pageSize = 8;
		int startRow = (curPage) * pageSize;		
		
		List<Article> list = new ArrayList<Article>();
		try {
			DBconn.init();
			ResultSet rs= DBconn.selectSql("select * from user_article limit "+startRow+",8");
			while (rs.next()) {
				Article article=new Article();
				article.setArticleid(rs.getInt("articleid"));
				article.setArticleauthor(rs.getString("articleauthor"));
				article.setArticletime(rs.getString("articletime"));
				article.setArticletitle(rs.getString("articletitle"));
//				article.setArticlemain(rs.getString("articlemain"));
				list.add(article);
			}
					
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return null;
	}

	
	
	/**
	 * 
	 * 单独文章显示
	 * 
	 */
	public List<Article> showartmaininfo(String articletitle) {
		List<Article> list = new ArrayList<Article>();
		try {
			DBconn.init();
			ResultSet rs= DBconn.selectSql("select * from user_article where articletitle = '"+articletitle+"'");
			while (rs.next()) {
				Article article=new Article();
				article.setArticleid(rs.getInt("articleid"));
				article.setArticleauthor(rs.getString("articleauthor"));
				article.setArticletime(rs.getString("articletime"));
				article.setArticletitle(rs.getString("articletitle"));
				article.setArticlemain(rs.getString("articlemain"));
				list.add(article);
				System.out.println("文章ok");
			}
					
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return null;
	}



	/**
	 * 
	 * 添加文章
	 * 
	 */
	public boolean addartinfo(Article wa) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into user_article(articletitle,articlemain,articleauthor,articletime)" +
				"values('"+wa.getArticletitle()+"','"+wa.getArticlemain()+"','"+wa.getArticleauthor()+"','"+wa.getArticletime()+"')");			
		if(i>0){
			flag = true;		
		}
		System.out.println("文章留言ok");
		DBconn.closeConn();
		return flag;
	}



	/**
	 * 
	  * 文章留言
	 * 
	 */
	public boolean addartmsinfo(Article msg) {
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("insert into user_article_message(addarticlemessagename,addarticlemessageinfo,addarticlemessagetime,whicharticletitle)" +
				"values('"+msg.getAddarticlemessagename()+"','"+msg.getAddarticlemessageinfo()+"','"+msg.getAddarticlemessagetime()+"','"+msg.getWhicharticletitle()+"')");
		if(i>0) {
			flag = true;
		}
		return flag;
	}



	/**
	 * 
	 * 文章留言展示
	 * 
	 */
	public List<Article> showartmsginfo(String articletitle) {
		List<Article> list = new ArrayList<Article>();
		try {
			DBconn.init();
			ResultSet rs= DBconn.selectSql("select * from user_article_message where whicharticletitle = '"+articletitle+"'");
			while (rs.next()) {
				Article article=new Article();
				article.setAddarticlemessageid(rs.getInt("addarticlemessageid"));
				article.setAddarticlemessagename(rs.getString("addarticlemessagename"));
				article.setAddarticlemessageinfo(rs.getString("addarticlemessageinfo"));
				article.setAddarticlemessagetime(rs.getString("addarticlemessagetime"));
				list.add(article);
			}
					
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return null;
	}



	/**
	 * 
	 * 文章模糊搜素
	 * 
	 */
	public List<Article> searcharticletitle(int Page,String searcharticletitle) {
		int i=1;
		int curPage = Page - i;
		int pageSize = 8;
		int startRow = (curPage) * pageSize;	
		
		List<Article> list = new ArrayList<Article>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from user_article where articletitle like '%"+searcharticletitle+"%' limit "+startRow+",8");
			while(rs.next()) {
				Article article=new Article();
				article.setArticleid(rs.getInt("articleid"));
				article.setArticleauthor(rs.getString("articleauthor"));
				article.setArticletitle(rs.getString("articletitle"));
				article.setArticletime(rs.getString("articletime"));
				list.add(article);
			}
			DBconn.closeConn();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}



	
	

	
	
}
