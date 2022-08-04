package com.staff.travel.controllers;

import com.staff.travel.models.Merchant;
import com.staff.travel.repositories.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
public class MerchantController {
    @Autowired
    private MerchantRepository merchantRepository;

    @GetMapping("/")
    public String getStatus() {
        return "endpoint is running";
    }

    @GetMapping("/{id}")
    public Merchant getById(@PathVariable("id") String merchantId) {
        return merchantRepository.findMerchantById(merchantId);
    }

    @GetMapping("/list")
    public Merchant getList() {
        return merchantRepository.findMerchantById("fa268234-b158-4137-b458-d2c97bcac122");
    }

    @PostMapping("/add")
    public Merchant add(@RequestBody final Merchant merchant){
        System.out.println(merchant.toString());
        return merchantRepository.add(merchant);
    }

    @PutMapping("/edit")
    public boolean edit(@RequestBody final Merchant merchant){
        return merchantRepository.edit(merchant);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestBody final String merchantId){
        return merchantRepository.delete(merchantId);
    }
}
