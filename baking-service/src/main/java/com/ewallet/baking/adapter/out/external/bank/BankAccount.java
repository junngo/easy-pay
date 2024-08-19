package com.ewallet.baking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BankAccount {
    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;
}
