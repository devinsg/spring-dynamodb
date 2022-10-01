package com.staff.travel.services;

import com.staff.travel.repositories.IMerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "merchantService")
public class MerchantService implements IMerchantService {
    @Autowired
    private IMerchantRepository repository;


}
