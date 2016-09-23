package com.wenhao.manytoone.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class HibernateUtils {
    static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("读取配置文件失败" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
