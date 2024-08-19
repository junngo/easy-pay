package com.ewallet.baking.adapter.out.persistence;

import com.ewallet.baking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {
    public RegisteredBankAccount mapToDomainEntity(RegisteredBankAccountJpaEntity entity) {
        return RegisteredBankAccount.generateRegisteredBankAccount(
                new RegisteredBankAccount.RegisteredBankAccountId(entity.getRegisteredBankAccountId()+""),
                new RegisteredBankAccount.MembershipId(entity.getMembershipId()),
                new RegisteredBankAccount.BankName(entity.getBankName()),
                new RegisteredBankAccount.BankAccountNumber(entity.getBankAccountNumber()),
                new RegisteredBankAccount.LinkedStatusIsValid(entity.isLinkedStatusIsValid())
        );
    }
}
