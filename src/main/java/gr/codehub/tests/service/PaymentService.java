package gr.codehub.tests.service;

import java.math.BigDecimal;

public interface PaymentService {
	BigDecimal balance();

	boolean deposit(BigDecimal amount);

	boolean withdraw(BigDecimal amount);
}
