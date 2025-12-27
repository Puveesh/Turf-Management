package com.example.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {
    @Id
    private Long paymentId;

    private String paymentType;
    private Double amount;

    public Payment(){

    }

    public Payment(Long paymentId,  String paymentType, Double amount){
        this.paymentId=paymentId;
        this.paymentType=paymentType;
        this.amount=amount;
    }

    public Long getPaymentId(){
        return paymentId;
    }
    public void setPaymentId(Long paymentId){
        this.paymentId=paymentId;
    }

    public String getPaymentType(){
        return paymentType;
    }
    public void setPaymentType(String paymentType){
        this.paymentType=paymentType;
    }

    public Double getAmount(){
        return amount;
    }
    public void setAmount(Double amount){
        this.amount=amount;
    }
}
