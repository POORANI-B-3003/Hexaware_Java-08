package com.hexaware.sis.service;

import com.hexaware.sis.dao.PaymentDAO;
import com.hexaware.sis.dao.PaymentDAOImplement;
import com.hexaware.sis.entity.Payment;
import com.hexaware.sis.exception.PaymentValidationException;

import java.util.List;

public class PaymentServiceImplement implements PaymentService {
    private PaymentDAO paymentDAO = new PaymentDAOImplement();

    @Override
    public void makePayment(Payment payment) throws Exception {
        if (payment.getAmount() <= 0 || payment.getPaymentDate() == null) {
            throw new PaymentValidationException("Amount must be positive and date required.");
        }
        paymentDAO.addPayment(payment);
    }

    @Override
    public List<Payment> getPaymentsByStudentId(int studentId) throws Exception {
        return paymentDAO.getPaymentsByStudentId(studentId);
    }

	@Override
	public void addPayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}
}
