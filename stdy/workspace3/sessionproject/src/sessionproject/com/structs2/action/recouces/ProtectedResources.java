package sessionproject.com.structs2.action.recouces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class ProtectedResources {
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		  HttpSession session = request.getSession(false);
		  String result = "failure";
		  if(session != null && !session.isNew())
			  result = "success";
		  return result;
	}
}
