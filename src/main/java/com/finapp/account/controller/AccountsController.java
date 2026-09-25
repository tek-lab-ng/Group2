package com.finapp.account.controller;


import com.finapp.account.constants.AccountsConstants;
import com.finapp.account.constants.LoanConstant;
import com.finapp.account.dto.*;
import com.finapp.account.service.impl.AccountsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AccountsController {

    @Autowired
    private AccountsServiceImpl accountsService;

    @PostMapping("/api/create")
    public ResponseEntity<ResponseDto> createAccount( @RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/api/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber) {
        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.FOUND).body(customerDto);
    }

    @PutMapping("/api/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountsService.updateAccount(customerDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto( AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/api/delete")
    public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam String mobileNumber) {
        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.MESSAGE_417_DELETE));
        }
    }

    @PostMapping("/api/loan")
    public ResponseEntity<?> createLoanRequest(@RequestBody LoanRequestDTO loanRequestDTO) {
        LoanReturnDTO loanReturnObj = accountsService.createLoan(loanRequestDTO);
        if (loanReturnObj == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LoanResponseDTO(LoanConstant.PHONE_NUMBER));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new LoanResponseDTO(LoanConstant.MESSAGE_201,
                loanReturnObj.getCustomer_name(),
                loanReturnObj.getTotal_amount(),
                loanReturnObj.getOutstanding_balance()));
    }




}
