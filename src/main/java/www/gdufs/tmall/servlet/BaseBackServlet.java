package www.gdufs.tmall.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.gdufs.tmall.dao.*;
import www.gdufs.tmall.dao.impl.*;
import www.gdufs.tmall.util.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * BaseBackServlet 的内容
 * 第一是：获取分页信息
 * 第二是：根据反射获取对应的方法
 * 第三是：根据对应方法的返回值，进行服务端跳转、客户端跳转、或直接输出字符串
 * Created by gu on 2017/10/17.
 */
public abstract class BaseBackServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(BaseBackServlet.class);

    public abstract String add(HttpServletRequest request, HttpServletResponse response, Page page);

    public abstract String edit(HttpServletRequest request, HttpServletResponse response, Page page);

    public abstract String delete(HttpServletRequest request, HttpServletResponse response, Page page);

    public abstract String update(HttpServletRequest request, HttpServletResponse response, Page page);

    public abstract String list(HttpServletRequest request, HttpServletResponse response, Page page);

    protected ICategoryDao categoryDao = new CategoryDao();
    protected IOrderDao orderDao = new OrderDao();
    protected IOrderItemDao orderItem = new OrderItemDao();
    protected IProductDao productDao = new ProductDao();
    protected IProductImageDao productImageDao = new ProductImageDao();
    protected IPropertyDao propertyDao = new PropertyDao();
    protected IPropertyValueDao propertyValueDao = new PropertyValueDao();
    protected IReviewDao reviewDao = new ReviewDao();
    protected IUserDao userDao = new UserDao();

    public void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            /*获取分页信息*/
            int start = 0;
            int count = 5;
            try {
                start = Integer.parseInt(req.getParameter("page.start"));
            } catch (Exception e) {

            }
            try {
                count = Integer.parseInt(req.getParameter("page.count"));
            } catch (Exception e) {

            }
            Page page = new Page(start, count);
            /*根据反射获取对应的方法*/
            String method = (String) req.getAttribute("method");
            Method m = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class, Page.class);
            String redirect = m.invoke(this, req, resp, page).toString();

            /*根据返回值 进行跳转*/
            if (redirect.startsWith("@")) {
                resp.sendRedirect(redirect.substring(1));
            } else if (redirect.startsWith("%")) {
                resp.getWriter().print(redirect.substring(1));
            } else {
                req.getRequestDispatcher(redirect).forward(req, resp);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

}
