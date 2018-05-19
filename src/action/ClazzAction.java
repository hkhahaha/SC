package action;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.ClazzDao;
import dto.Clazz;

public class ClazzAction extends ActionSupport {
	private Clazz clazz;
	private int id;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Clazz getClazz() {
		return clazz;
	}



	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}



	public String addClazz() throws Exception{
		ClazzDao clazzDao = new ClazzDao();
		boolean result = clazzDao.addClazz(clazz);
		if(result){
			return "addsuccess";
		}
		else{
			return "adderror";
		}
	}
	
	public String showClazz() throws Exception{
		ClazzDao clazzDao = new ClazzDao();
		List<Clazz> clazzs = clazzDao.showClazz();
		ActionContext.getContext().getSession().put("clazzs", clazzs);
		if(clazzs!=null){
			return "showsuccess";
		}
		else{
			return "showerror";
		}
	}
	
	public String checkClazz() throws Exception{
		Clazz clazz = ClazzDao.getClazzByID(id);
		ActionContext.getContext().getSession().put("clazz", clazz);
		System.out.println(clazz+"456");
		return "getsuccess";
	}
	
	public String modifiClazz() throws Exception{
		ClazzDao clazzDao = new ClazzDao();
		clazzDao.modifiClazz(clazz);
		ClazzAction c = new ClazzAction();
		c.showClazz();
		return "modifiSuccess";
	}
	
	public String DeleteAction() throws Exception{
		ClazzDao clazzDao = new ClazzDao();
		clazzDao.DeleteClazz(id);
		ClazzAction c = new ClazzAction();
		c.showClazz();
		return "deletesuccess";
	}
	
	public String StudentClazzAction() throws Exception{
		ClazzDao clazzDao = new ClazzDao();
		List<Clazz> clazzs = clazzDao.showClazz();
		ActionContext.getContext().getSession().put("clazzs", clazzs);
		if(clazzs!=null){
			return "clazzsuccess";
		}
		else{
			return "clazzerror";
		}
	}
	
}
