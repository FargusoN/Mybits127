package server;

import com.jr.biz.impl.ReviewrecordBizImpl;
import com.jr.entry.Reviewrecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/reviewrecordservlet")
public class ReviewrecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("reviewrecordservletstate").equals("1")) {
            insertReviewCord(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);

    }
    /**
     * 插入一条审核记录
     * */
    protected void insertReviewCord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doPost(req, resp);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Reviewrecord reviewrecord = new Reviewrecord();
        reviewrecord.setTicketOpenId(Integer.parseInt(request.getParameter("ticket_open_id")));
        reviewrecord.setCreatorId(Integer.parseInt(request.getParameter("creator_id")));
        try {
            reviewrecord.setCreateTime(simpleDateFormat.parse(request.getParameter("create_time")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        reviewrecord.setReviewStatus(request.getParameter("review_status"));
        reviewrecord.setRemark(request.getParameter("remark"));

        int i = new ReviewrecordBizImpl().addReviewrecord(reviewrecord);
        if (i == 0) {
            System.out.println("复核失败");
        } else {
            System.out.println("复核/添加成功");
        }
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }


}
