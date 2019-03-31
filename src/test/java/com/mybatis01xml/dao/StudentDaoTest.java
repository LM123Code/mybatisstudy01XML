package com.mybatis01xml.dao;

import com.mybatis01xml.entities.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * StudentDao Tester.
 */
public class StudentDaoTest {
    StudentDao studentDao = null;
    @Before
    public void before() throws Exception {
        studentDao = new StudentDao();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectStudentById(int id)
     */
    @Test
    public void testSelectStudentById() throws Exception {
        Student student = studentDao.selectStudentById(1);
        System.out.println(student);
        Assert.assertNotNull(student);
    }
    @Test
    public void testSelectStudentsByName(){
        List<Student> list = studentDao.selectStudentsByName("liuqijun");
        System.out.println(list);
        Assert.assertNotNull(list);
    }
    @Test
    public void testInsertStudent(){
        int row = 0;
        Student student = new Student();
        student.setName("yangluo");
        student.setSex("girl");
        row = studentDao.insertStudent(student);
        Assert.assertEquals(1, row);
    }
    @Test
    public void testUpdateStudent(){
        int row = 0;
        Student student = new Student();
        student.setName("liuqijun");
        student.setSex("boy");
        row = studentDao.insertStudent(student);
        Assert.assertEquals(1, row);
    }
    @Test
    public void testDeleteStudent(){
        int row = 0;
        row = studentDao.deleteStudentById(14);
        Assert.assertEquals(1, row);
    }
}
