package com.wenhao.manytoone.dao;

import com.wenhao.manytoone.domain.Department;
import com.wenhao.manytoone.domain.Employee;
import com.wenhao.manytoone.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class DepartmentDaoTest {
    @Test
    public void delete() throws Exception {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Department department = new Department();
        department = session.get(Department.class, 2L);
        session.delete(department);
        transaction.commit();
        session.close();
    }

}