package com.yaz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaz.dao.CustomerDAO;
import com.yaz.entity.Customer;
import com.yaz.entity.HesapHareketi;
import com.yaz.entity.Kampanya;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}

	@Override
	public Customer getCustomer(String userName, String password) {
		
		return customerDAO.getCustomer(userName, password);
	}

	@Override
	public Customer getCustomer(String userName) {
		
		return customerDAO.getCustomer(userName);
	}
//-----------------------KAMPANYALAR------------------------
	@Override
	public List<Kampanya> getKampanyalar() {
		return customerDAO.getKampanyalar();
	}

	@Override
	public void saveKampanya(Kampanya kampanya) {
		customerDAO.saveKampanya(kampanya);
		
	}

	@Override
	public Kampanya getKampanya(int kampanyaId) {
		return customerDAO.getKampanya(kampanyaId);
	}

	@Override
	public void deleteKampanya(int kampanyaId) {
		customerDAO.deleteKampanya(kampanyaId);
	}
	
//-----------------------HESAP HAREKETLERÝ------------------
	@Override
	public List<HesapHareketi> getHesapHareketleri() {
		return customerDAO.getHesapHareketleri();
	}

	@Override
	public void saveHesapHareketi(HesapHareketi hesapHareketi) {
		customerDAO.saveHesapHareketi(hesapHareketi);
	}

	@Override
	public HesapHareketi getHesapHareketi(int hesapHareketiId) {
		return customerDAO.getHesapHareketi(hesapHareketiId);
	}

	@Override
	public void deleteHesapHareketi(int hesapHareketiId) {
		customerDAO.deleteHesapHareketi(hesapHareketiId);
	}
}





