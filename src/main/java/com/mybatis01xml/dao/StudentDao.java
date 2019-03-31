package com.mybatis01xml.dao;

import com.mybatis01xml.entities.Student;
import com.mybatis01xml.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author LM_Code
 * @create 2019-03-30-16:45
 */
public class StudentDao {
    /**
     * 根据id查找学生
     * @param id
     * @return
     */
    public Student selectStudentById(int id){
        Student student = null;
        SqlSession sqlSession = null;
        try{
            //通过会话工厂打开一个会话
            sqlSession = SqlSessionFactoryUtil.openSession(true);
            //查询单个对象，指定参数为3
            student = sqlSession.selectOne("com.mybatis01xml.mapper.studentMapper.selectStudentById",id);
            //关闭会话
        }finally {
            SqlSessionFactoryUtil.closeSession(sqlSession);
        }
        return student;
    }

    /**
     * 根据姓名查找学生
     * @param name
     * @return
     */
    public List<Student> selectStudentsByName(String name){
        List<Student> list = null;
        SqlSession sqlSession = null;
        try{
            //通过会话工厂打开一个会话
            sqlSession = SqlSessionFactoryUtil.openSession(true);
            //查询单个对象，指定参数为3
            list = sqlSession.selectList("com.mybatis01xml.mapper.studentMapper.selectStudentsByName", name);
        }finally {//关闭会话
            SqlSessionFactoryUtil.closeSession(sqlSession);
        }

        return list;
    }

    /**
     * 插入学生
     * @param student
     * @return
     */
    public int insertStudent(Student student) {
        int row = 0;
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtil.openSession(true);
            row = sqlSession.insert("com.mybatis01xml.mapper.studentMapper.insertStudent", student);
        }finally {
            SqlSessionFactoryUtil.closeSession(sqlSession);
        }
        return row;
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    public int updateStudent(Student student){
        int row = 0;
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtil.openSession(true);
            row = sqlSession.update("com.mybatis01xml.mapper.studentMapper.updateStudent", student);
            return row;
        }finally {
            SqlSessionFactoryUtil.closeSession(sqlSession);
        }
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    public int deleteStudentById(int id){
        int row = 0;
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtil.openSession(true);
            row = sqlSession.delete("com.mybatis01xml.mapper.studentMapper.deleteStudentById", id);
            return row;
        }finally {
            SqlSessionFactoryUtil.closeSession(sqlSession);
        }
    }
}
