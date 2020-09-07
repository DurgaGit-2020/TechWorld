package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Admin_User;

public interface AdminRepository extends JpaRepository<Admin_User, Integer> {

}
