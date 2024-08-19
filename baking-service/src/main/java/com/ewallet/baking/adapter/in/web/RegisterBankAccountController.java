package com.ewallet.baking.adapter.in.web;

import com.ewallet.baking.application.port.in.RegisterBankAccountCommand;
import com.ewallet.baking.application.port.in.RegisterBankAccountUseCase;
import com.ewallet.baking.domain.RegisteredBankAccount;
import com.ewallet.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping(path = "/banking/account/register")
    RegisteredBankAccount registeredBankAccount(@RequestBody RegisterBankAccountRequest request) {
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(request.isValid())
                .build();

        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
        if (registeredBankAccount == null) {
            // todo: error handling
            return null;
        }
        return registeredBankAccount;
    }
}
