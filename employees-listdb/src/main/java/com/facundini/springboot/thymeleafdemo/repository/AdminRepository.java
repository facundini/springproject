package com.facundini.springboot.thymeleafdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facundini.springboot.thymeleafdemo.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
