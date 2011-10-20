package net.erqo.web.action;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * 标题：ERQO.NET
 * 
 * 作者：Tony 2011-4-24
 * 
 * 描述：
 * 
 * 说明:
 */
public class DbTest {

	/**
	 * @param args
	 */
	

	public static void main(String[] args) throws Exception {

//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//		String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=F:/Erqo/erqo.mdb";
//		Connection conn = null;
//		try{
//			conn = DriverManager.getConnection(url);
//			System.out.println("Testing");
//		} catch (Exception e){
//			System.out.println(e);
//		} finally {
//			
//			if(conn!=null){
//				conn.close();
//			}
//			
//		}
		String strurl = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=f:\\Erqo\\erqo.mdb";
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection(strurl);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		
	}
	

	
	


}
