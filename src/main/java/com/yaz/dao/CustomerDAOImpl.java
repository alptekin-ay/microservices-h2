package com.yaz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaz.entity.Customer;
import com.yaz.entity.HesapHareketi;
import com.yaz.entity.Kampanya;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",
											Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}
	@Override
	public Customer getCustomer(String userName, String password) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by userName",
											Customer.class);
		List<Customer> customers = null;
		// execute query and get result list
		customers = theQuery.getResultList();
		for(int i = 0; i < customers.size(); i++) {
			if ((customers.get(i)).getUserName().equals(userName) 
					&& customers.get(i).getPassword().equals(password)) {
				return customers.get(i);
			}
		}
		return null;
	}
	
	@Override
	public Customer getCustomer(String userName) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by userName",
											Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		Customer theCustomer = currentSession.get(Customer.class, 6);
		
		for(int i = 0; i < customers.size(); i++) {
			if ((customers.get(i)).getUserName().equals(userName)) {
				theCustomer = customers.get(i);
			}
		}
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}

//----------------------KAMPANYALAR--------------------
	
	@Override
	public List<Kampanya> getKampanyalar() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Kampanya> theQuery = 
				currentSession.createQuery("from Kampanya order by kampanya_adi",
											Kampanya.class);
		
		// execute query and get result list
		List<Kampanya> kampanyalar = theQuery.getResultList();
				
		// return the results		
		return kampanyalar;
	}

	@Override
	public void saveKampanya(Kampanya kampanya) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(kampanya);
		
	}

	@Override
	public Kampanya getKampanya(int kampanyaId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Kampanya kampanya = currentSession.get(Kampanya.class, kampanyaId);
				
		return kampanya;
	}

	@Override
	public void deleteKampanya(int kampanyaId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Kampanya where id=:kampanyaId");
		theQuery.setParameter("kampanyaId", kampanyaId);
		
		theQuery.executeUpdate();
		
	}

	
	//-----------------------HESAP HAREKETLERÝ------------------
	
	@Override
	public List<HesapHareketi> getHesapHareketleri() {
	// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<HesapHareketi> theQuery = 
				currentSession.createQuery("from HesapHareketi",
										HesapHareketi.class);
		
		// execute query and get result list
		List<HesapHareketi> hesapHareketleri = theQuery.getResultList();
				
		// return the results		
		return hesapHareketleri;
	}

	@Override
	public void saveHesapHareketi(HesapHareketi hesapHareketi) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(hesapHareketi);

	}

	@Override
	public HesapHareketi getHesapHareketi(int hesapHareketiId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		HesapHareketi hesapHareketi = currentSession.get(HesapHareketi.class, hesapHareketiId);
				
		return hesapHareketi;
	}

	@Override
	public void deleteHesapHareketi(int hesapHareketiId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from HesapHareketi where id=:hesapHareketiId");
		theQuery.setParameter("hesapHareketiId", hesapHareketiId);
		
		theQuery.executeUpdate();
	}
	
}