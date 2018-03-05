package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.sun.org.apache.xerces.internal.util.Status;

/**
 * MySQL连接 层,实现远程连接,统一管理连接的通与短
 * 实例化一个对象的时候 自动创建连接
 * 上层使用后应该 立即 调用 close 方法。
 * 垃圾回收一个对象的时候 会检测是否调用close方法，如未调用则调用
 * 
 * 实例化后 调用 getStatement()方法即可获得 连接对象。
 * 
 * @author twobox
 * @version v1.1
 */
public class DatabaseConnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://ojbk.net:3306/ojbk_userdb?characterEncoding=utf8";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "ojbk_user";
    static final String PASS = "w1qz1bu";
    
    Connection conn; // 连接
    Statement stmt; // 操作对象
    
    boolean isfinalized;
    
    public DatabaseConnection() {
    	isfinalized = false;
		try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            System.out.println(" 开始连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
          
            System.out.println(" 连接成功...初始化完成...");
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
    public void finalize() {
    	if (!isfinalized) {
    		this.close();
    	}
    }
    
    public Connection getConnection() { 
    	return conn;
	}
    public Statement getStatement() {
    	return stmt;
    }
    public void close () {
    	try {
    		stmt.close();
        	conn.close();
        	isfinalized = true;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public static void main(String[] args) {
    	new DatabaseConnection().getConnection();
    }
}
