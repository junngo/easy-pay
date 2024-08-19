package com.ewallet.baking.adapter.out.external.bank;

import com.ewallet.baking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import com.ewallet.baking.application.port.out.RequestBankAccountInfoPort;
import com.ewallet.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ExternalSystemAdapter
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
        // We should call the api to the external bank to get the real data in the real project
        // and then return the real data of external bank
        // But, Now we've made practicing project to learn the MSA. Return the dummy data.
        return new BankAccount(request.getBankName(), request.getBankAccountName(), true);
    }
}
