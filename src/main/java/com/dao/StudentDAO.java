package com.dao;

import com.bean.Student;

/**
 * Created by yjy on 16-9-25.
 */
public interface StudentDAO {
    public Student find_student_by_number(String number);
}
