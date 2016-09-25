package com.dao.imp;

import com.bean.Student;
import com.dao.StudentDAO;
import com.hibernateUtils.HibernateLoader;

/**
 * Created by yjy on 16-9-25.
 */
public class StudentDAOImp implements StudentDAO {
    @Override
    public Student find_student_by_number(String number) {
        return (Student) HibernateLoader.getSession().get(Student.class, number);
    }
}
