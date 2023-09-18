package com.project.dasi.auth.repository;

import com.project.dasi.auth.entity.Users;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <Users, String> {
    Users findByUserid(String userid);

    boolean existsByUserid(String userid);
}