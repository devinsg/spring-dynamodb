package com.staff.travel.repositories;

import com.staff.travel.models.Merchant;

import java.util.List;

public interface IMerchantRepository {
    Merchant add(Merchant merchant);

    Merchant findMerchantById(String merchantId);

    List<Merchant> findAll();

    boolean delete(String merchantId);

    boolean edit(Merchant merchant);

    String update(String merchantId, Merchant merchant);
}
