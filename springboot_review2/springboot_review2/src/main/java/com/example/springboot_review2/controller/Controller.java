package com.example.springboot_review2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot_review2.model.*;
import com.example.springboot_review2.repository.*;
import com.example.springboot_review2.service.LoginService;
@RestController
@RequestMapping("/api")
public class Controller
{

    @Autowired
    private LoginService ivtmgService;

    @Autowired
    private ServiceRepo productRepo;


    @PostMapping("/user")
    public ResponseEntity<Login> addIvtmg(@RequestBody Login ivtmg)
    {
        Login addedIvtmg = ivtmgService.addIvtmg(ivtmg);
        if (addedIvtmg != null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body(addedIvtmg);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/user")
    public ResponseEntity<Page<Login>> getAllIvtmgs(Pageable pageable)
    {
        Page<Login> ivtmgs = ivtmgService.getAllIvtmgs(pageable);
        if (!ivtmgs.isEmpty())
        {
            return ResponseEntity.ok(ivtmgs);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Login> getIvtmgById(@PathVariable Integer userId)
    {
        Login ivtmg = ivtmgService.getIvtmgById(userId);
        if (ivtmg != null)
        {
            return ResponseEntity.ok(ivtmg);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<Login> updateIvtmg(@PathVariable Integer userId, @RequestBody Login ivtmg)
    {
        if (ivtmgService.getIvtmgById(userId) != null)
        {
            ivtmg.setId(userId);
            Login updatedIvtmg = ivtmgService.updateIvtmg(ivtmg);
            return ResponseEntity.ok(updatedIvtmg);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteIvtmgById(@PathVariable Integer userId)
    {
        if (ivtmgService.getIvtmgById(userId) != null)
        {
            ivtmgService.deleteIvtmgById(userId);
            return ResponseEntity.noContent().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to get users by username with pagination
    @GetMapping("/user/by-username")
    public ResponseEntity<Page<Login>> findByUsername(@RequestParam String username, Pageable pageable)
    {
        Page<Login> users = ivtmgService.findByUsername(username, pageable);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/user/{userId}/product")
    public ResponseEntity<Service> addProductToIvtmg(@PathVariable Integer userId, @RequestBody Service product) {
        Login ivtmg = ivtmgService.getIvtmgById(userId);
        
        if (ivtmg != null)
        {
            product.setIvtmg(ivtmg);
            Service addedProduct = productRepo.save(product);
            
            if (addedProduct != null)
            {
                return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
            }
            else
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}