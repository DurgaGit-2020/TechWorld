package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Admin_User;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public List<Admin_User> getUserDetails() {
		return adminRepository.findAll();
	}
	
	//08-09-2020 task
	
	public String deleteProduct(int id)
	{
		adminRepository.deleteById(id);
		return "product removed || "+ id;		
	}
	
	public Admin_User getProductById(int id) {
		return adminRepository.findById(id).orElse(null);
	}
	
	public Admin_User updateProduct(Admin_User adminUser) {
		Admin_User existingProduct = adminRepository.findById(adminUser.getUserId()).orElse(null);
		existingProduct.setUserId(adminUser.getUserId());
		existingProduct.setName(adminUser.getName());
		existingProduct.setAccessDetails(adminUser.getAccessDetails());
		existingProduct.setAccountStatus(adminUser.getAccountStatus());
		return adminRepository.save(existingProduct);		
	}
	//today
	
//	public List<Admin_User> listAll(String keyword) {
//        if (keyword != null) {
//            return adminRepository.search(keyword);
//        }
//        return adminRepository.findAll();
//    }
	
	public List<Admin_User> listAll(String keyword) {
        if (keyword != null){
            return adminRepository.search(keyword);
        }
        return adminRepository.findAll();
    }
}
