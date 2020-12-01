package io.syria.devideReadAndWrite.dao.cluster;

import io.syria.semiAutoAnnotation.User;

import java.util.List;

public interface UserMapperReadOnly {
    List<User> selectUserByName(String username);
}
