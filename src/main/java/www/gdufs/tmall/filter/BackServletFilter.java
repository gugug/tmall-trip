package www.gdufs.tmall.filter;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gu on 2017/10/21.
 */
public class BackServletFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //   requestURI:     /tmail/admin_category_list
        String requestURI = request.getRequestURI();
        //        contextPath : /tmail
        String contextPath = request.getServletContext().getContextPath();
        // requestURI : /admin_category_list
        requestURI = StringUtils.remove(requestURI,contextPath);
        if (requestURI.startsWith("/admin_")) {
            String servletPath = StringUtils.substringBetween(requestURI, "_", "_") + "Servlet";
            String method = StringUtils.substringAfterLast(requestURI, "_");
            request.setAttribute("method", method);
            //服务端跳转
            request.getRequestDispatcher("/" + servletPath).forward(request, response);
            return;
        }

        //放行 例如  css js等
        filterChain.doFilter(request, response);
    }

    public void destroy() {

    }
}
