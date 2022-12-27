package com.jr.pojo;

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
 * @create 2022-12-07-12:11
 */
public class MyTest {

    @Test
    public void findall() throws IOException {
        //1.加载mybatis得核心配置文件：
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.获得session对象：
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(inputStream);
        SqlSession session=factory.openSession();

        //3.执行session方法，处理返回值
        List<Dept> depts=session.selectList("selectDept");
        for(Dept dept:depts){
            System.out.println(dept);
        }

        //4.关闭session
        session.close();
    }

    @Test
    public void adddept() throws IOException {
        //1.加载mybatis核心配置文件：
        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获得session对象:
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(inputStream);
        SqlSession session=factory.openSession();

        //3.调用session方法，处理返回值
        Dept dept=new Dept();
        dept.setDeptno(100);
        dept.setDname("运维组");
        dept.setLoc("长春");
        int i= session.insert("addDept",dept);
        if(i==1){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        session.commit();

        //4.关闭session对象：
        session.close();
    }


    @Test
    public void upddept() throws IOException {
        //1.加载mybatis核心配置文件：
        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获得session对象:
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(inputStream);
        SqlSession session=factory.openSession();

        //3.调用session方法，处理返回值
        Dept dept=new Dept();
        dept.setDeptno(50);
        dept.setDname("研发部");
        dept.setLoc("大连");
        int i= session.delete("updDept",dept);
        if(i==1){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        session.commit();

        //4.关闭session对象：
        session.close();
    }

    @Test
    public void deldept() throws IOException {
        //1.加载mybatis核心配置文件：
        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获得session对象:
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(inputStream);
        SqlSession session=factory.openSession();

        //3.调用session方法，处理返回值
        int i= session.delete("delDept",60);
        if(i==1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        session.commit();

        //4.关闭session对象：
        session.close();
    }

    @Test
    public void findOne() throws IOException {
        //1.加载mybatis核心配置文件：
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获得session对象:
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(inputStream);
        SqlSession session=factory.openSession();

        //3.调用session方法，处理返回值
        Dept dept=session.selectOne("selectOne",50);
        System.out.println(dept);

        //4.关闭session对象：
        session.close();
    }
}