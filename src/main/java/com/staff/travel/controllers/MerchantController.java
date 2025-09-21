package com.staff.travel.controllers;

import com.staff.travel.models.Merchant;
import com.staff.travel.repositories.IMerchantRepository;
import com.staff.travel.services.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/merchant")
public class MerchantController {
    @Autowired
    private IMerchantRepository repository;

    @Autowired
    private IMerchantService merchantService;

    @GetMapping("/")
    public String getStatus() {
        return "endpoint is running";
    }

    @GetMapping("/{id}")
    public Merchant getById(@PathVariable("id") String merchantId) {
        return repository.findMerchantById(merchantId);
    }

    @GetMapping("/list")
    public List<Merchant> getList() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public Merchant add(@RequestBody final Merchant merchant){
        return repository.add(merchant);
    }

    @PutMapping("/edit")
    public boolean edit(@RequestBody final Merchant merchant){
        return repository.edit(merchant);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody final String merchantId){
        return repository.delete(merchantId);
    }
}
