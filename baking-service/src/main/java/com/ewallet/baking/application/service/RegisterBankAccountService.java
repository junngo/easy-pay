package com.ewallet.baking.application.service;

import com.ewallet.baking.adapter.out.external.bank.BankAccount;
import com.ewallet.baking.adapter.out.external.bank.GetBankAccountRequest;
import com.ewallet.baking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.ewallet.baking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.ewallet.baking.application.port.in.RegisterBankAccountCommand;
import com.ewallet.baking.application.port.in.RegisterBankAccountUseCase;
import com.ewallet.baking.application.port.out.RegisterBankAccountPort;
import com.ewallet.baking.application.port.out.RequestBankAccountInfoPort;
import com.ewallet.baking.domain.RegisteredBankAccount;
import com.ewallet.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RegisteredBankAccountMapper registeredBankAccountMapper;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // To get the real information of external bank account If the membership account can register
        // Port -> Adapter -> External System(Bank)
        BankAccount account = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(
                command.getBankName(),
                command.getBankAccountNumber()
        ));
        boolean accountIsValid = account.isValid();
        if (accountIsValid) {
            // save the account
            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMembershipId()),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
            );

            return registeredBankAccountMapper.mapToDomainEntity(savedAccountInfo);
        } else {
            return null;
        }
    }
}
