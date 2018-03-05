package net.ojbk.admin;

import org.apache.coyote.http11.filters.VoidInputFilter;
/**
 * 个人理解：对于这个包来说，是 javabean的数据，而adminHandle.java 是相关的操作
 * 理应现有 adminHandle 再有 admin.java 。
 * Admin类 类似于课程设计的 卖家数据、车辆数据的地位。
 * 
 * @author twobox
 *
 */
public class Admin {
	private String admName;
	private String admPassword;
	
	public void setAdmName (String admName) {
		this.admName = admName;
	}
	public void setAdmPassword (String admPassword) {
		this.admPassword = admPassword;
	}
	
	public String getAdmName () {
		return this.admName;
	}
	public String getAdmPassword() {
		return this.admPassword;
	}
}
