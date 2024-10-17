package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        Student student = new Student();
        student.setId(23);
        student.setName("Uncle Sam");
        student.setCity("Mumbai");
        
//        int r = studentDao.insert(student);
        
        Student student1 = studentDao.getStudent(23);
        System.out.println(student1);
        
        List<Student> students = studentDao.getAllStudents();
        for(Student s: students) {
        	System.out.println(s);
        }
        
        
    }
}


