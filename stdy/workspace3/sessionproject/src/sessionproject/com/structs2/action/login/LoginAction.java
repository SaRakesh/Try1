package sessionproject.com.structs2.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class LoginAction {
	
	private String userName;
	private StringBuffer password;
	public String getUserNamr() {
		return userName;
	}
	public void setUserNamr(String userNamr) {
		this.userName = userNamr;
	}
	public StringBuffer getPassword() {
		return password;
	}
	public void setPassword(StringBuffer password) {
		this.password = password;
	}
	
	public String execute() throws Exception {
		String result= "failure";
		if(Validator.validatePassword(password)){
		  HttpServletRequest request = ServletActionContext.getRequest();
		  HttpSession session = request.getSession(true);
		  session.setAttribute("userName", session.getId());
		  result = "success";
		}
		cleardata();
		return result;
	}
	private void cleardata() {
		password.delete(0, password.length());
		password.append("had been deleted");
		
	}

}
