package io.syria.spring01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {
    private int id;
    private String name;

    public Student create(){return new Student(101,"luyuqi");}

    public void say(){
        System.out.println("I'm a student in this school");
    }
}
