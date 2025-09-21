package com.staff.travel.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class Address {
    @DynamoDBAttribute(attributeName = "City")
    private String city;

    @DynamoDBAttribute(attributeName = "State")
    private String state;

    @DynamoDBAttribute(attributeName = "PinCode")
    private String pinCode;
}
