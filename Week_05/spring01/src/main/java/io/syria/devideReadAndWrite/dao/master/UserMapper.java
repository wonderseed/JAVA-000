package io.syria.devideReadAndWrite.dao.master;

import io.syria.semiAutoAnnotation.User;

public interface UserMapper {

    void insertUser(User user);

    void updateUser(User user);

    void deleteUserByName(String userName);
}
