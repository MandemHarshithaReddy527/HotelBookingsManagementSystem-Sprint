package com.cg.hbm.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.dao.IBookingDetailsRepository;
import com.cg.hbm.entites.BookingDetails;
import com.cg.hbm.entites.Hotel;
import com.cg.hbm.exceptions.BookingDetailsNotFoundException;
import com.cg.hbm.exceptions.HotelNotFoundException;

/**
 * 
 * @author Harshitha
 *
 */
@Service
public class IBookingDetailsServiceImpl implements IBookingDetailsService {

	
	@Autowired
	IBookingDetailsRepository bDao;

	

	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingdetails) throws BookingDetailsNotFoundException {
		
		Optional<BookingDetails> b = bDao.findById(bookingdetails.getBooking_id());
		if (b.isEmpty()) {
			return bDao.saveAndFlush(bookingdetails);
		} else {
			throw new BookingDetailsNotFoundException("BookingDetails already exists");
		}
	}

	

	
	
	@Override
	public BookingDetails updateBookingDetails(int bookingId, BookingDetails bookingDetails) throws BookingDetailsNotFoundException {
		// TODO Auto-generated method stub
		Optional<BookingDetails> b = bDao.findById(bookingId);
		if (b.isEmpty()) {
			throw new BookingDetailsNotFoundException("BookingDetails not found");
		}
		else
		bDao.save(bookingDetails);
		return bookingDetails;
		
	}



	@Override
	public List<BookingDetails> showAllBookingDetails() throws BookingDetailsNotFoundException {
		List<BookingDetails> boo = bDao.findAll();
		if (boo.isEmpty()) {
			throw new BookingDetailsNotFoundException("BookingDetails not found");
		}
		return boo;
	}

	
	
	@Override
	public BookingDetails showBookingDetails(int booking_id) throws BookingDetailsNotFoundException {
		Optional<BookingDetails> b=bDao.findById(booking_id);
		if(b.isEmpty()) {
			throw new BookingDetailsNotFoundException("Given BookingDetailsId does not exist");
		}
		return b.get();
	}


	
	@Override
	public BookingDetails removeBookingDetails(int booking_id) throws BookingDetailsNotFoundException {
		
		Optional<BookingDetails> op=bDao.findById(booking_id);
		if(op.isPresent()) {
			bDao.deleteById(booking_id);
			return op.get();
		}
		else throw new BookingDetailsNotFoundException("BookingDetails with given Id doesn't exist.");
	}
}

/*
 * import java.util.List; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.cg.hbm.entites.BookingDetails;
 * 
 * import com.cg.hbm.dao.IBookingDetailsRepository;
 * 
 * @Service public class IBookingDetailsServiceImpl implements
 * IBookingDetailsService{
 * 
 * @Autowired IBookingDetailsRepository bDao;
 *//**
	 * @author Harshitha
	 * @param bookingdetails
	 * @return BookingDetails
	 */
/*
 * 
 * @Override public BookingDetails addBookingDetails(BookingDetails
 * bookingDetails) { return bDao.save(bookingDetails); }
 *//**
	 * @author Harshitha
	 * @param bookingdetails
	 * @return BookingDetails
	 */
/*
 * 
 * @Override public BookingDetails updateBookingDetails(BookingDetails
 * bookingDetails) { return bDao.saveAndFlush(bookingDetails); }
 *//**
	 * @author Harshitha
	 * @param bookingdetails
	 * @return BookingDetails
	 */
/*
 * 
 * @Override public BookingDetails removeBookingDetails(BookingDetails
 * bookingDetails) { bDao.deleteById(bookingDetails.getBooking_id()); return
 * bookingDetails; }
 *//**
	 * @author Harshitha
	 * @return List<BookingDetails>
	 */
/*
 * 
 * @Override public List<BookingDetails> showAllBookingDetails() { return
 * bDao.findAll(); }
 * 
 *//**
	 * @author Harshitha
	 * @param booking_id
	 * @return BookingDetails
	 *//*
		 * 
		 * @Override public BookingDetails showBookingDetails(int booking_id) { return
		 * bDao.findById(booking_id).get(); }
		 * 
		 * }
		 */