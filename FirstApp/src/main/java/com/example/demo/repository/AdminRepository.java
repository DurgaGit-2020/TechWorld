package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Admin_User;

public interface AdminRepository extends JpaRepository<Admin_User, Integer> {	
	
    //public List<Admin_User> search(String keyword);
	@Query("SELECT p FROM Admin_User p WHERE CONCAT(p.userId,p.name.fName, ' ', p.name.lName, ' ', p.name.mName, ' ',p.accessDetails, ' ',p.accountStatus, ' ') LIKE %?1%")
    List<Admin_User> search(String keyword);
}
