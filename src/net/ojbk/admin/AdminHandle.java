package net.ojbk.admin;

import java.sql.*;

import database.DatabaseConnection;

public class AdminHandle {
	
	DatabaseConnection dbconn;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public boolean checkAdmin(Admin admin) {
		String admName = admin.getAdmName();
		String admPassword = admin.getAdmPassword();
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
}
