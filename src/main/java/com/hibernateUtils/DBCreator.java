package com.hibernateUtils;

import com.bean.Student;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yjy on 16-9-24.
 */
public class DBCreator {
    public static void main(String[] arg){

        //建表
        Configuration configuration = HibernateLoader.getConfiguration();
        SchemaExport schemaExport = new SchemaExport(configuration);
        schemaExport.create(true,true);

        //插入一条数据,此处就不开启事务了
        Student student = new Student();
        student.setNumber("2012006");
        student.setName("王五");
        try {
            student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2002-10-06"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setMath(98);
        student.setEnglish(100);
        HibernateLoader.getSession().save(student);
    }
}
