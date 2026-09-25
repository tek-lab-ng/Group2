package com.finapp.account.mapper;

import com.finapp.account.dto.LoanDTO;
import com.finapp.account.entity.Loan;

public class LoanMapper {

    public static Loan maptoLoan(LoanDTO loanDTO, Loan loan){
        loan.setLoanType(loanDTO.getLoan_type());
        loan.setMobileNumber(loanDTO.getMobile_number());
        loan.setTotalLoan(loanDTO.getTotal_loan());

        return loan;
    }
}
