package com.finapp.account.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class LoanReturnDTO {
    private String customer_name;
    private int total_amount;
    private int outstanding_balance;

    public LoanReturnDTO(String customerName, int total_amount, int outStanding_balance){
        this.customer_name = customerName;
        this.total_amount = total_amount;
        this.outstanding_balance = outStanding_balance;
    }
}
