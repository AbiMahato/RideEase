package com.rideease.rideease.repository;

import com.rideease.rideease.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query("select u from UserModel u where u.email = :email ")
    public UserModel getUserByUserName(@Param("email") String email);
}
