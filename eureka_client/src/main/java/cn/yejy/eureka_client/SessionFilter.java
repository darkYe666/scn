package cn.yejy.eureka_client;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author ye
 * @date 2019-05-08
 */
@Slf4j
public class SessionFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        Enumeration<String> names = request.getHeaderNames();
        if (names.hasMoreElements()) {
            String header = request.getHeader(names.nextElement());
        }
        log.info(names.toString());

        ConsoleUserVo userSession = (ConsoleUserVo) request.getSession().getAttribute("userInfo");
        if (userSession != null) {
            //先销毁在添加否则触发不了监听器中的attributeAdded
//            request.getSession().removeAttribute("userInfo");
            //重新设值session
            request.getSession().setAttribute("userInfo", userSession);
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
