package com.finapp.account.mapper;

import com.finapp.account.dto.LoanRequestDTO;
import com.finapp.account.entity.Loan;

public class LoanMapper {

    public static Loan maptoLoan(LoanRequestDTO loanRequestDTO, Loan loan){
        loan.setLoanType(loanRequestDTO.getLoan_type());
        loan.setMobileNumber(loanRequestDTO.getMobile_number());
        loan.setTotalLoan(loanRequestDTO.getTotal_loan());

        return loan;
    }
}
