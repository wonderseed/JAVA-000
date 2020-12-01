package io.syria.devideReadAndWrite.service;

import io.syria.devideReadAndWrite.dao.cluster.UserMapperReadOnly;
import io.syria.devideReadAndWrite.dao.master.UserMapper;
import io.syria.semiAutoAnnotation.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    @Autowired
    private UserMapperReadOnly readOnlyMapper;

    @Autowired
    private UserMapper masterMapper;

    public List<User> findUsersByName(String name){
        return readOnlyMapper.selectUserByName(name);
    }

    public void insertUser(User user){
        //todo set User
       try {
           masterMapper.insertUser(user);
       }catch (SQLException e){

       }
    }
}
