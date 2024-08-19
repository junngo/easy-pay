package com.ewallet.baking.adapter.out.persistence;

import com.ewallet.baking.application.port.out.RegisterBankAccountPort;
import com.ewallet.baking.domain.RegisteredBankAccount;
import com.ewallet.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository bankAccountRepository;

    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount(RegisteredBankAccount.MembershipId membershipId, RegisteredBankAccount.BankName bankName, RegisteredBankAccount.BankAccountNumber bankAccountNumber, RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
        return bankAccountRepository.save(
          new RegisteredBankAccountJpaEntity(
                  membershipId.getMembershipId(),
                  bankName.getBankName(),
                  bankAccountNumber.getBankAccountNumber(),
                  linkedStatusIsValid.isLinkedStatusIsValid()
          )
        );
    }
}
