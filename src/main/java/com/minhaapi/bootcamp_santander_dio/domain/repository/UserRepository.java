package com.minhaapi.bootcamp_santander_dio.domain.repository;

import com.minhaapi.bootcamp_santander_dio.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
