package com.jr.biz.impl;

import com.jr.biz.ITicketopenBiz;
import com.jr.dao.impl.TicketOpenDaoImpl;
import com.jr.entry.TicketOpen;
import com.jr.entry.User;
import com.jr.until.PageHelper;
import com.jr.until.SqlHelper;
import com.jr.until.TicketView;
import java.util.List;

public class TicketopenBizImpl implements ITicketopenBiz {
    TicketOpenDaoImpl ticketOpenDao = new TicketOpenDaoImpl();


    //通过条件查询获取所有开单表信息数据
    @Override
    public List<TicketOpen> getAllTicketopenByConditions(TicketOpen ticketOpen, SqlHelper sqlHelper) {

        List<TicketOpen> ticketOpens = ticketOpenDao.queryAllTicketopenByConditions(ticketOpen, sqlHelper);
        return ticketOpens;
    }

    @Override
    public TicketOpen queryAllTicketopen(TicketOpen ticketOpen) {
        return new TicketOpenDaoImpl().queryAllTicketopen(ticketOpen);
    }

    @Override
    public boolean addTicketopen(TicketOpen ticketOpen) {
        int i = ticketOpenDao.insertTicketopen(ticketOpen);
        return i == 0 ? false : true;

    }

    @Override
    public boolean modifyTicketopen(TicketOpen ticketOpen) {
        return ticketOpenDao.updateTicketopen(ticketOpen) == 0 ? false : true;
    }

    @Override
    public TicketOpen getTicketopenbyUserEnterId(User user) {
        TicketOpen ticketOpen = ticketOpenDao.selectTicketopenbyUserEnterId(user);
        return ticketOpen;
    }

    @Override
    //查询总页数
    public int getAllnum() {
        return ticketOpenDao.queryCountNum();
    }

    @Override
    public List<TicketView> getBypage(PageHelper pageHelper, SqlHelper sqlHelper) {

        return ticketOpenDao.QueryByPage(pageHelper, sqlHelper);
    }
}
