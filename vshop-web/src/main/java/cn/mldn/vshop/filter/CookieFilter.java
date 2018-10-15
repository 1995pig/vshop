package cn.mldn.vshop.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ServletObjectUtil;
import cn.mldn.vshop.service.front.IMemberServiceFront;
import cn.mldn.vshop.util.cookie.RememberMeUtil;
@WebFilter("/*") 
public class CookieFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req ;
		HttpServletResponse response = (HttpServletResponse) resp ;
		if (request.getSession().getAttribute("mid") == null) {
			RememberMeUtil rmu = new RememberMeUtil(request, response);
			String user [] = rmu.loadRemember() ;	// 读取信息
			if (user != null) {
				String mid = user[0] ;
				// 用户输入的密码如果要想进行数据库认证处理必须进行加密功能实现
				String password = user[1] ;
				IMemberServiceFront memberService = Factory.getServiceInstance("member.service.front");
				try {
					Map<String, Object> map = memberService.login(mid,password);
					int result = (Integer) map.get("status"); // 取得登录状态
					if (result == 1) { // 登录成功状态
						request.getSession().setAttribute("mid", mid); // 在session中保存登录的标记数据
						request.getSession().setAttribute("name", map.get("name"));
						request.getSession().setAttribute("lastdate", map.get("lastdate"));
						request.getSession().setAttribute("allRoles", map.get("allRoles"));
						request.getSession().setAttribute("allActions", map.get("allActions"));
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
