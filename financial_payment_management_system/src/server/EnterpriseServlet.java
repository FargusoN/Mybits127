package server;

import com.google.gson.Gson;
import com.jr.biz.impl.EnterpriseBizImpl;
import com.jr.entry.Enterprise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/enterpriseservlet")
@SuppressWarnings({"all"})
public class EnterpriseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (request.getParameter("enterpriseservletstate").equals("1")) {
            getAllEnterprise(request, response);
        }
        if (request.getParameter("enterpriseservletstate").equals("2")) {
            getEnterpriseInfoByEnterpriseID(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    /**
     * 通过用户传入进来的企业ID获取企业信息，在填入
     */
    protected void getEnterpriseInfoByEnterpriseID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        EnterpriseBizImpl enterpriseBiz = new EnterpriseBizImpl();
        Enterprise enterprise = enterpriseBiz.getEnterpriseInfo(Integer.parseInt(request.getParameter("entrtpriseid")));
        request.getSession().setAttribute("enterparesbysesson",enterprise);
                Gson gson = new Gson();
        System.out.println(gson.toJson(enterprise));
        response.getWriter().println(gson.toJson(enterprise));
    }

    /**
     * 获取企业的全部信息列表
     * 将列表内企业名称展示在前端下拉框中
     */

    protected static void getAllEnterprise(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Enterprise> allEnterprise = new EnterpriseBizImpl().getAllEnterpriseNames();

        response.getWriter().println(new Gson().toJson(allEnterprise));

    }

}
