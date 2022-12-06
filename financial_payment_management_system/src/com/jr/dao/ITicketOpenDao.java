package com.jr.dao;

import com.jr.entry.TicketOpen;
import com.jr.entry.User;
import com.jr.until.PageHelper;
import com.jr.until.SqlHelper;
import com.jr.until.TicketView;


import java.util.List;

public interface ITicketOpenDao {

    //查询单个开单表的no编号 ,用模糊查询,使用ajax完成异步查询,(要写工具类)

    //查询所有符合条件的开单列表信息
    public List<TicketOpen> queryAllTicketopenByConditions(TicketOpen ticketOpen, SqlHelper sqlHelper);

    //查询全部状态为开单中的信息  A：成功；B：开单中； C：已撤销；D：复核未通过
    public List<TicketOpen> QueryAllTicketopenByObTheBill(TicketOpen ticketOpen);


    //插入一条Ticketopen数据
    public int insertTicketopen(TicketOpen ticketOpen);

    //更新开单表状态
    public int updateTicketopen(TicketOpen ticketOpen);

    public TicketOpen selectTicketopenbyUserEnterId(User user);

    public int queryCountNum(); //查询全部数据条数

    public List<TicketView> QueryByPage(PageHelper pageHelper, SqlHelper sqlHelper); //查询分页信息集合



}
