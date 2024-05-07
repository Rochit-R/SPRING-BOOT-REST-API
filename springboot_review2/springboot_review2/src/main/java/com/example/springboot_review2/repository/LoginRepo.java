package com.example.springboot_review2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.springboot_review2.model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {
    @Query("SELECT i FROM Ivtmg i WHERE i.username = ?1")
    Page<Login> findByUsername(String username, Pageable pageable);
}