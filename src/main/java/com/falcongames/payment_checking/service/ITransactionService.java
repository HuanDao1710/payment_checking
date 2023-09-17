package com.falcongames.payment_checking.service;

import com.falcongames.payment_checking.domain.dto.TransactionDTO;

public interface ITransactionService {
	TransactionDTO create(TransactionDTO dto);
}
