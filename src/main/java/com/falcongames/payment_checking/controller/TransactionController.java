package com.falcongames.payment_checking.controller;

import com.falcongames.payment_checking.domain.dto.Create;
import com.falcongames.payment_checking.domain.dto.TransactionDTO;
import com.falcongames.payment_checking.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/transaction"))
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	@PostMapping
	public TransactionDTO create(@RequestBody @Validated(Create.class) TransactionDTO dto) {
		return transactionService.create(dto);
	}
}
