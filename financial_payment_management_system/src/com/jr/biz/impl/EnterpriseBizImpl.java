package com.jr.biz.impl;

import com.jr.biz.IEnterpriseBiz;
import com.jr.dao.impl.EnterpriseDaoImpl;
import com.jr.entry.Enterprise;

import java.util.List;

public class EnterpriseBizImpl implements IEnterpriseBiz {
    /*
     * 通过id获取企业信息
     * */
    EnterpriseDaoImpl dao=new EnterpriseDaoImpl();

    @Override
    public Enterprise getEnterpriseInfo(int id) {
      return dao.queryByid(id);
    }
    /*
     *获取所有企业名称
     * */
    @Override
    public List<Enterprise> getAllEnterpriseNames() {
        return dao.queryAllEnterpriseNames();
    }
}
