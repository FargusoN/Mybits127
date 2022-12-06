package server;

import com.google.gson.Gson;
import com.jr.biz.impl.ReviewrecordBizImpl;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.entry.Reviewrecord;
import com.jr.entry.TicketOpen;
import com.jr.until.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@SuppressWarnings({"all"})
@WebServlet("/ticketopentservlet")
public class TicketOpenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.doGet(req, resp);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (request.getParameter("ticketopentservletstate").equals("1")) {
            getTicketopenByTicketView(request, response);
        }
        if (request.getParameter("ticketopentservletstate").equals("2")) {
            getTicketInfoView1(request, response);
        }

        if (request.getParameter("ticketopentservletstate").equals("3")) {
            page2(request, response);
        }
        if (request.getParameter("ticketopentservletstate").equals("4")) {
            page2(request, response);
        }

        if (request.getParameter("ticketopentservletstate").equals("5")) {
            getAllEsuc(request, response);
        }
        if (request.getParameter("ticketopentservletstate").equals("6")) {
            addTicketopeninfo(request, response);
        }
        if (request.getParameter("ticketopentservletstate").equals("7")) {
            getTicketInfoView2(request, response);
        }
        if (request.getParameter("ticketopentservletstate").equals("8")) {
            modify(request, response);
        }
        if (request.getParameter("ticketopentservletstate").equals("9")) {
            page(request, response);
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
     * 通过视图获取所有开单表中的详细信息
     */
    protected void getAllTicketopeninfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TicketOpen ticketOpen = new TicketOpen();
        SqlHelper sqlHelper = new SqlHelper();
        List<TicketOpen> allTicketopen = new TicketopenBizImpl().getAllTicketopenByConditions(ticketOpen, sqlHelper);
        response.getWriter().println(new Gson().toJson(allTicketopen));
    }


    /**
     * 获取所有符合条件的ticketopen开单表信息
     * 这里使用前台异步查询,提供了字符串拼接工具类
     * 可以直接在里边拼接所需要属性的字符串
     * 添加开单表的同事要在审核记录表中添加一条信息
     */
    protected void addTicketopeninfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request);

        System.out.println("进入 addTicketopeninfo");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmms");
        String fmt = sdf.format(System.currentTimeMillis());
        TicketOpen ticketOpen = new TicketOpen();
        String numb = "N" + fmt;
        ticketOpen.setNo(numb);
        ticketOpen.setEnterPriseId(request.getParameter("enterprise_id"));
        ticketOpen.setAcquirerEnterPriseId(request.getParameter("acquirer_enterprise_id"));
        ticketOpen.setAmount(Double.parseDouble(request.getParameter("amount")));
        ticketOpen.setInstitutyId(Integer.parseInt(request.getParameter("instituty_id")));

        try {
            String create_time = request.getParameter("create_time");
            String expiry_time = request.getParameter("expiry_time");
            if (expiry_time.equals("") || expiry_time == null) {

            }
            ticketOpen.setCreateTime(simpleDateFormat.parse(create_time));
            ticketOpen.setExpiryTime(simpleDateFormat.parse(expiry_time));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String type = request.getParameter("payment_interest_type");
        String typestr = type.equals("a") ? "融资方付息" : "核心企业付息";
        ticketOpen.setPaymentInterestType(typestr);

        String status = request.getParameter("status");
        String s = status.equals("1") ? "成功" : (status.equals("2") ? "开单中" : (status.equals("3") ? "已撤销" : "复核未通过"));
        ticketOpen.setStatus(s);
        String unLink = MD5Util.getInstance().toHashHexStr("你好" + fmt);
        ticketOpen.setUplinkAddress(unLink);
        ticketOpen.setTicket_remark(request.getParameter("ticket_remark"));
        boolean b = new TicketopenBizImpl().addTicketopen(ticketOpen);
        if (b) {
            System.out.println("开单插入成功");
        }
        TicketOpen ticketOpen2 = new TicketOpen();
        ticketOpen2.setNo(numb);
        TicketOpen ticketOpen1 = new TicketopenBizImpl().queryAllTicketopen(ticketOpen2);
        response.getWriter().println(new Gson().toJson(b));


        Reviewrecord reviewrecord = new Reviewrecord();
        reviewrecord.setTicketOpenId(ticketOpen1.getId());
        reviewrecord.setCreatorId(Integer.parseInt(request.getParameter("creator_id")));
        try {
            reviewrecord.setCreateTime(simpleDateFormat.parse(request.getParameter("create_time")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        reviewrecord.setReviewStatus(request.getParameter("review_status"));
        reviewrecord.setRemark(request.getParameter("remark"));

        new ReviewrecordBizImpl().addReviewrecord(reviewrecord);


    }


    /**

     * 通过试图获取开单列表
     */
    protected void getTicketopenByTicketView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<TicketView> ticketViews = new TicketView().selectAll();

        response.getWriter().println(new Gson().toJson(ticketViews));
    }

    /**
     * 通过视图获取开单列表详细信息
     * */
    protected void getTicketInfoView1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getTicketInfoView");
        String no = request.getParameter("no");
        ViewUtility viewUtility = new ViewUtility().sleectInfoView(no);

        HttpSession session = request.getSession();
        session.setAttribute("ticketInfoviewUitlity", viewUtility);
        response.sendRedirect("open-detail.jsp");
        response.getWriter().println(new Gson().toJson(viewUtility));

    }
    /**
     * 通过视图获取复核界面详细信息
     * */
    protected void getTicketInfoView2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getTicketInfoView");
        String no = request.getParameter("no");

        ViewUtility viewUtility = new ViewUtility().sleectInfoView(no);
        HttpSession session = request.getSession();
        session.setAttribute("ticketInfoviewUitlity", viewUtility);
        response.sendRedirect("check-detail.jsp");
        response.getWriter().println(new Gson().toJson(viewUtility));
    }

    /**
     * 分页方法：付款列表的分页
      */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("进入分页方法");

        TicketopenBizImpl ticketopenBizImpl = new TicketopenBizImpl();
        PageHelper ph = new PageHelper();

        ph.setTotalCount(ticketopenBizImpl.getAllnum());// 给  一共有多少条数据   赋值
        ph.setPageSize(10); //给  每页显示的条数   赋值
        ph.setTotalPage(ph.getTotalPage());

        if (request.getParameter("index") == null || request.getParameter("index").equals("undefined")) {
            ph.setIndexPage(1); //给   当前是第几页   赋值
        } else {
            ph.setIndexPage(Integer.parseInt(request.getParameter("index")));
        }

        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.setNo(request.getParameter("no"));
        sqlHelper.setEnterPriseId(request.getParameter("enterPriseId"));
        sqlHelper.setAcquirerEnterPriseId(request.getParameter("acquirerEnterPriseId"));
        sqlHelper.setCreateTime(request.getParameter("createtime"));
        sqlHelper.setAmountMin(request.getParameter("amountMin"));
        sqlHelper.setAmountMax(request.getParameter("amountMax"));

        String status = request.getParameter("status");
        if (status != null) {
            String s = status.equals("0") ? "" : (status.equals("1") ? "'成功'" : (status.equals("2") ? "'开单中'" : ("'已撤销' or status='复核未通过'")));
            sqlHelper.setStatus(s);
        }
        System.out.println(sqlHelper);
        ph.setPageList(ticketopenBizImpl.getBypage(ph, sqlHelper));
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(ph));
    }
    /**
     * 分页方法：审核列表的分页
     */
    protected void page2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入getTicketopenByTicketViewForconditions");
        System.out.println("进入分页方法");

        TicketopenBizImpl ticketopenBizImpl = new TicketopenBizImpl();
        PageHelper ph = new PageHelper();

        ph.setTotalCount(ticketopenBizImpl.getAllnum());// 给  一共有多少条数据   赋值
        ph.setPageSize(10); //给  每页显示的条数   赋值
        ph.setTotalPage(ph.getTotalPage());

        if (request.getParameter("index") == null || request.getParameter("index").equals("undefined")) {
            ph.setIndexPage(1); //给   当前是第几页   赋值
        } else {
            ph.setIndexPage(Integer.parseInt(request.getParameter("index")));
        }
        //组合sql语句字符串
        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.setNo(request.getParameter("no"));
        sqlHelper.setEnterPriseId(request.getParameter("enterPriseId"));
        sqlHelper.setAcquirerEnterPriseId(request.getParameter("acquirerEnterPriseId"));
        sqlHelper.setCreateTime(request.getParameter("createtime"));
        sqlHelper.setAmountMin(request.getParameter("amountMin"));
        sqlHelper.setAmountMax(request.getParameter("amountMax"));
        sqlHelper.setStatus("'开单中'");

//        通过工具类查询数据库数据，并获取页码，展示数量等参数存入json中
        ph.setPageList(ticketopenBizImpl.getBypage(ph, sqlHelper));
        System.out.println(ph.getPageList());
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(ph));


    }

    protected void getAllEsuc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Esuc esuc = new Esuc();
        List<Esuc> esucs = esuc.queryEsuc(esuc);
        response.getWriter().println(new Gson().toJson(esucs));

    }
    /**
     *修改开单表状态
     * */
    protected void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TicketOpen ticketOpen = new TicketOpen();
        ticketOpen.setStatus(request.getParameter("ticketopenstatus"));
        ticketOpen.setId(Integer.parseInt(request.getParameter("ticketopenid")));
        System.out.println(ticketOpen + "0000000000000000000000000000000");
        boolean b = new TicketopenBizImpl().modifyTicketopen(ticketOpen);
        response.getWriter().println(new Gson().toJson(b));
    }


}