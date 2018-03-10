package net.ojbk.user;


/**
 * 个人理解：对于这个包来说，是 javabean的数据，而adminHandle.java 是相关的操作
 * 理应现有 adminHandle 再有 admin.java 。
 * Admin类 类似于课程设计的 卖家数据、车辆数据的地位。
 * 
 * @author twobox
 *
 */
public class User {
	private String userName;
	private String userPassword;
	
	public void setUserName (String userName) {
		this.userName = userName;
	}
	public void setUserPassword (String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserName () {
		return this.userName;
	}
	public String getUserPassword() {
		return this.userPassword;
	}
	
	public String toString() {
		String str = "userNmae=" + this.userName + ", userPassword=" + this.userPassword;
		return str;
	} 
}
