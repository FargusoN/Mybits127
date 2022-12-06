package server;

import com.jr.biz.impl.UserBizImpl;
import com.jr.entry.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userservlet")
public class Userervlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String str = request.getParameter("userervletstate");
        System.out.println(str);
        if (str.equals("1")) {
            login(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    /**
     * 使用sesson存储用户登录后返回的对象
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));

        System.out.println(user);
        User login = new UserBizImpl().login(user);
        System.out.println(login);
        HttpSession session = request.getSession();
        if (login == null) {
            System.out.println("登陆失败");
            response.sendRedirect("login.jsp");
        } else {
            session.setAttribute("user",login);
            response.sendRedirect("ticket-open.jsp");


        }

    }
}
