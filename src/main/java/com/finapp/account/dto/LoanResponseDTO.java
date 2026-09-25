package com.finapp.account.dto;

import com.finapp.account.entity.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoanResponseDTO {

    private String message;
    private String name;
    private int amountBorrowed;
    private int outStandingAmount;


    public LoanResponseDTO(String message){
        this.message = message;
    }

    public LoanResponseDTO(String message, String name, int amountBorrowed, int outStandingAmount) {
        this.message = message;
        this.name = name;
        this.amountBorrowed = amountBorrowed;
        this.outStandingAmount = outStandingAmount;

    }
}
