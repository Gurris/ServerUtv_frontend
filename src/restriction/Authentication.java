package restriction;

import beans.LoginBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Gurris on 2016-11-16.
 */
public class Authentication implements Filter{
    private FilterConfig config;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(((HttpServletRequest) servletRequest).getSession().getAttribute(LoginBean.AUTHENTICATION) == null){
            ((HttpServletResponse) servletResponse).sendRedirect("/restricted.xhtml");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
    public void init(FilterConfig config)throws ServletException{
        this.config = config;
    }
    public void destroy(){
        config = null;
    }
}
