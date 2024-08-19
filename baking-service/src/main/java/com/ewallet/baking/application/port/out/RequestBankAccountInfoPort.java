package com.ewallet.baking.application.port.out;

import com.ewallet.baking.adapter.out.external.bank.BankAccount;
import com.ewallet.baking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
