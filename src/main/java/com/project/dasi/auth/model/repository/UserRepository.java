package com.project.dasi.auth.model.repository;

import com.project.dasi.auth.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <Users, String> {
    Users findByUserid(String userid);

    boolean existsByUserid(String userid);
}