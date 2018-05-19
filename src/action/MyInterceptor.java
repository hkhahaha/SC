package action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import dto.User;

public class MyInterceptor extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception{
		Map session=ActionContext.getContext().getSession();
		User user =(User)session.get("user");
		System.out.println(user);
		if (user != null)
		{
			return invocation.invoke();
		}
		else{
			ActionSupport action=(ActionSupport) invocation.getAction();
			action.addActionError("��û�е�¼,���ܷ�����Դ,���ȵ�¼!");
			return Action.LOGIN;
		}
	}
}
