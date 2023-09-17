package com.falcongames.payment_checking.utils;

import com.falcongames.payment_checking.constant.Duration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class ExpiredTime {
	public static Date createExpiredTime(Duration duration) {
		// Lấy ngày hôm nay
		LocalDate today = LocalDate.now();
		// Them thoi gian gia han
		LocalDate expirationDate = today.plusDays(duration.getValue() + 1);
		// Đặt thời gian là 00:00:00
		LocalTime midnight = LocalTime.of(0, 0, 0);
		LocalDateTime expirationDateTime = LocalDateTime.of(expirationDate, midnight);
		// Chuyển đổi LocalDateTime thành Date
		Date expiredTime = Date.from(expirationDateTime.atZone(ZoneId.systemDefault()).toInstant());
		return expiredTime;
	}
}
