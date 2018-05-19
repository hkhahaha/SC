package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ClazzDao;
import dao.UserDao;
import dto.Clazz;
import dto.User;

public class loginAction extends ActionSupport {
	private String username;
	private String password;
	private Map session;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	@Override
	public String execute() throws Exception{
		UserDao dao = new UserDao();
		User user = dao.login(username, password);
		session = ActionContext.getContext().getSession();
		if(user!=null){
			session.put("user",user);
			ClazzDao clazzDao = new ClazzDao();
			List<Clazz> clazzs = clazzDao.showClazz();
			ActionContext.getContext().getSession().put("clazzs", clazzs);
			return "loginsuccess";
		}else {
			return "loginerror";
		}
	}
}
