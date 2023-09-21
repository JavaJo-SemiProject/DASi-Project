package com.project.dasi.auth.repository;

import com.project.dasi.auth.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <Users, String> {
    Users findByUserid(String userid);
}