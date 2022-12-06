package com.jr.biz.impl;

import com.jr.biz.IReviewrecordBiz;
import com.jr.dao.impl.ReviewrecordDaoImpl;
import com.jr.entry.Reviewrecord;

import javax.xml.stream.FactoryConfigurationError;

public class ReviewrecordBizImpl implements IReviewrecordBiz {
    /*
     * 添加审核记录
     * */
    ReviewrecordDaoImpl dao=new ReviewrecordDaoImpl();
    @Override
    public int addReviewrecord(Reviewrecord reviewrecord) {
        return dao.insertReviewrecord(reviewrecord);

    }
    /*
     * 根据开单id获取审核记录信息
     * */
    @Override
    public Reviewrecord getReviewrecord(int ticketId) {
        return dao.queryReviewrecord(ticketId);
    }
}
