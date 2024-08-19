package com.ewallet.baking.application.port.in;

import com.ewallet.baking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {

    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
