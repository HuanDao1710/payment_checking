package com.falcongames.payment_checking.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Duration {
	DAY_1(1), DAY_3(3), DAY_7(7), DAY_14(14), DAY_30(30);
	private final int value;
}
