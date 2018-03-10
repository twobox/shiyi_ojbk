package net.ojbk.user;

import java.sql.*;

import database.DatabaseConnection;

public class UserHandle {
	
	DatabaseConnection dbconn;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public boolean checkUser(User user) {
		String admName = user.getUserName();
		String admPassword = user.getUserPassword();
		boolean tf = false;
		try {
			dbconn = new DatabaseConnection();
			conn = dbconn.getConnection();
			stmt = dbconn.getStatement();
			String sql = "SELECT * FROM user WHERE id='"
					+ admName
					+ "' AND password='"
					+ admPassword
					+ "'";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				tf = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbconn.close();
		}
		return tf;
	}
	
	public boolean registerUser (User user) {
		String userName = user.getUserName();
		String userPassword = user.getUserPassword();
		boolean tf =  false;
		try {
			dbconn = new DatabaseConnection();
			conn = dbconn.getConnection();
			stmt = dbconn.getStatement();
			
			
			String sql = "INSERT INTO user(id, password) VALUES('"
					+ userName
					+ "', '"
					+ userPassword
					+ "');";
			
			stmt.executeLargeUpdate(sql);
			
			tf = true;
			System.out.println("注册一个新用户：" + user);
		} catch (Exception e) {
			e.printStackTrace();
			tf = false;
		} finally {
			dbconn.close();
		}
		return tf;
	}
	
	public static void main(String[] args) { // 测试的代码写在这里
		User user = new User();
		user.setUserName("10002");
		user.setUserPassword("123456");
		
		UserHandle userHandle = new UserHandle();
		userHandle.registerUser(user);
	}
}
