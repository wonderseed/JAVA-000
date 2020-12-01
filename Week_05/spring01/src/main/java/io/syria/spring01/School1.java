package io.syria.spring01;

import org.springframework.beans.factory.annotation.Autowired;


public class School1 {
    private Student student;
    @Autowired
    public void setStudent(Student student){
        this.student =student;
    }
    public Student getStudent(){
        return student;
    }
    public void saySomething(){
        student.say();
    }
}
