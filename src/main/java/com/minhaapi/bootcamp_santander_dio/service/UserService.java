package com.minhaapi.bootcamp_santander_dio.service;

import com.minhaapi.bootcamp_santander_dio.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

    void update(Long id, User userUpdate);

    void deleteUser(Long id);
}
