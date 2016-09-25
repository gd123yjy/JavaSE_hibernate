package com.service.imp;

import com.bean.Student;
import com.dao.StudentDAO;
import com.dao.imp.StudentDAOImp;
import com.service.BussinessLogicService;

import java.text.SimpleDateFormat;

/**
 * Created by yjy on 16-9-25.
 */
public class StudentServiceImp implements BussinessLogicService {
    private StudentDAO studentDAO = new StudentDAOImp();

    @Override
    public String getStudentInfoByNumber(String number) {
        Student student = studentDAO.find_student_by_number(number);
        return formatStudent(student);
    }

    private String formatStudent(Student student) {
        String result = "学号：" + student.getNumber() + " 姓名：" + student.getName() + " 出生：" + new SimpleDateFormat("yyyy-MM-dd").format(student.getBirthday()) + " 英语：" + student.getEnglish() + " 数学：" + student.getMath();
        return result;
    }
}
