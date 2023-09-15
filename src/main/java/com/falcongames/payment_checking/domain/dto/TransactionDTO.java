package com.falcongames.payment_checking.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TransactionDTO {

@NotNull(groups = {Create.class})
private String accountId;

@NotNull(groups = {Create.class})
private Long packageId;



}
