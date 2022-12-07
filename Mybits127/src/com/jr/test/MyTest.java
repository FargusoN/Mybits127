package com.jr.test;

import com.jr.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @auther Summer
 * @create 2022-12-07-9:43
 */
public class MyTest {

    @Test
    public void findall() throws IOException {
        //1.加载mybits的核心配置文件
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.获得session对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(inputStream);
        SqlSession session=factory.openSession();
        //3.执行session方法，处理返回值
        List<Dept> depts=session.selectList("selectDept");
        for (Dept dept:depts){
            System.out.println(dept);
        }

        //4.关闭session
        session.close();


    }
}
