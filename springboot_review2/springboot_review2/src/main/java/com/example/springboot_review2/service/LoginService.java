package com.example.springboot_review2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springboot_review2.model.Login;
import com.example.springboot_review2.repository.LoginRepo;


@Service
public class LoginService {
    @Autowired
    private LoginRepo ivtmgRepo;

    public Login addIvtmg(Login ivtmg) {
        return ivtmgRepo.save(ivtmg);
    }

    public Page<Login> getAllIvtmgs(Pageable pageable) {
        return ivtmgRepo.findAll(pageable);
    }

    public Login getIvtmgById(Integer id) {
        return ivtmgRepo.findById(id).orElse(null);
    }

    public Login updateIvtmg(Login ivtmg) {
        return ivtmgRepo.save(ivtmg);
    }

    public void deleteIvtmgById(Integer id) {
        ivtmgRepo.deleteById(id);
    }

    public Page<Login> findByUsername(String username, Pageable pageable) {
        return ivtmgRepo.findByUsername(username, pageable);
    }
}