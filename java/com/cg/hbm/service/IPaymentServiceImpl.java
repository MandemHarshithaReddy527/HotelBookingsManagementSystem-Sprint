
package com.cg.hbm.service;

/*import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entites.Hotel;
import com.cg.hbm.entites.Payments;
import com.cg.hbm.exceptions.*;
import com.cg.hbm.dao.IHotelRepository;
import com.cg.hbm.dao.IPaymentRepository;

@Service
public class IPaymentServiceImpl implements IPaymentService{
	@Autowired
	IPaymentRepository pDao;

	@Override
	public Payments addPayment(Payments payment) {
		return pDao.save(payment);
	}

	


	@Override
	public List<Payments> showAllPayments() {
		return pDao.findAll();
	}

	@Override
	public Payments showPayments(int payment_id) {
		return pDao.findById(payment_id).get();
	}

}*/
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hbm.dao.IPaymentRepository;
import com.cg.hbm.entites.Payments;
import com.cg.hbm.exceptions.PaymentNotFoundException;

@Service
@Transactional
public class IPaymentServiceImpl implements IPaymentService {
	@Autowired
	IPaymentRepository repository;

	@Override
	public Payments addPayment(Payments payments) throws PaymentNotFoundException{
		if(repository.existsById(payments.getPayment_id())){
			throw new PaymentNotFoundException("Payment with given Id already exists.");
		}
		else
		repository.saveAndFlush(payments);
		return payments;
	}
	
	
	@Override
	public List<Payments> showAllPayments() throws PaymentNotFoundException {
		List<Payments> p = repository.findAll();
		if (p.isEmpty()) {
			throw new PaymentNotFoundException("Payment not found");
		}
		return p;
	}

	@Override
	public Payments showPayments(int payment_id) throws PaymentNotFoundException{
		if(repository.findById(payment_id).isPresent()) {
			return repository.findById(payment_id).get();
		}
		else {
			throw new PaymentNotFoundException("Payment with given Id not found.");
		}
		
	}
}

 