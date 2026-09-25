package com.finapp.account.dto;

import lombok.Data;

@Data
public class LoanRequestDTO {

    private String mobile_number;
    private String loan_type;
    private int total_loan;

}
