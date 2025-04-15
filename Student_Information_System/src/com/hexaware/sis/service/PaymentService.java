package com.hexaware.sis.service;

import com.hexaware.sis.entity.Payment;
import java.util.List;

public interface PaymentService {
    void makePayment(Payment payment) throws Exception;
    List<Payment> getPaymentsByStudentId(int studentId) throws Exception;
	void addPayment(Payment payment);
}
