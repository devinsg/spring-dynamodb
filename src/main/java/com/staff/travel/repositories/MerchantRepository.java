package com.staff.travel.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.staff.travel.models.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MerchantRepository {
    @Autowired
    private DynamoDBMapper mapper;

    public Merchant add(Merchant merchant) {
        mapper.save(merchant);
        return merchant;
    }
    
    public Merchant findMerchantById(String merchantId) {
        List<Merchant> lstMerchant = mapper.scan(Merchant.class, new DynamoDBScanExpression());
        return lstMerchant.stream()
                .filter(item -> item.getMerchantId().equals(merchantId))
                .findFirst()
                .orElse(null);
    }

    public List<Merchant> findAll() {
        return mapper.scan(Merchant.class, new DynamoDBScanExpression());
    }

    public boolean delete(String merchantId) {
        try {
            mapper.delete(merchantId);
            return true;
        } catch (Exception ex) {
            System.out.println("ERROR:" + ex.toString());
            return false;
        }
    }

    public boolean edit(Merchant merchant) {
        try {
            mapper.save(merchant, buildExpression(merchant));
            return true;
        } catch (Exception ex) {
            System.out.println("ERROR:" + ex.toString());
            return false;
        }
    }

    private DynamoDBSaveExpression buildExpression(Merchant merchant) {
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedValueMap = new HashMap<>();
        expectedValueMap.put("MerchantId", new ExpectedAttributeValue(new AttributeValue().withS(merchant.getMerchantId())));
        dynamoDBSaveExpression.setExpected(expectedValueMap);
        return dynamoDBSaveExpression;
    }

    public String update(String merchantId, Merchant merchant) {
        mapper.save(merchant,
                new DynamoDBSaveExpression().withExpectedEntry("MerchantId",
                        new ExpectedAttributeValue(
                                new AttributeValue().withS(merchantId)
                        )));
        return merchantId;
    }
}
