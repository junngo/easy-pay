package com.ewallet.baking.application.port.out;

import com.ewallet.baking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.ewallet.baking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {
    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
      RegisteredBankAccount.MembershipId membershipId,
      RegisteredBankAccount.BankName bankName,
      RegisteredBankAccount.BankAccountNumber bankAccountNumber,
      RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}
