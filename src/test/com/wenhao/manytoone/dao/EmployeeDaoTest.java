package com.wenhao.manytoone.dao;

import com.wenhao.manytoone.domain.Department;
import com.wenhao.manytoone.domain.Employee;
import com.wenhao.manytoone.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.nio.channels.SeekableByteChannel;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class EmployeeDaoTest {
    @Test
    public void get() throws Exception {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.getTransaction();
        Employee employee = new Employee();
        employee.setId(2L);
        Employee employee1 = session.load(Employee.class, 2L);
        System.out.println(employee1.getId());
        //System.out.println(employee1.getDepartment());
        session.close();
        //System.out.println(employee1.getDepartment());
    }

    @Test
    public void delete() throws Exception {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Employee emp = new Employee();
        emp = session.get(Employee.class, 1L);
        session.delete(emp);
        transaction.commit();
        session.close();
    }

    @Test
    public void save() throws Exception {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Department department = new Department();
        department.setName("采购部");
        session.save(department);
        Employee emp = new Employee();
        emp.setName("wenhao");
        emp.setAddressname("chengdu");
        emp.setDepartment(department);
        session.save(emp);
        transaction.commit();
        session.close();
    }

}