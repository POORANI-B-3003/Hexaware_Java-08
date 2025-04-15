package com.hexaware.sis.dao;

import com.hexaware.sis.entity.Payment;
import java.util.List;

public interface PaymentDAO {
    void addPayment(Payment payment) throws Exception;
    List<Payment> getPaymentsByStudentId(int studentId) throws Exception;
	Payment getPaymentById(int paymentId) throws Exception;
}
