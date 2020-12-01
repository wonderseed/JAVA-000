package io.syria.spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School2 {
    private Student student;
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
