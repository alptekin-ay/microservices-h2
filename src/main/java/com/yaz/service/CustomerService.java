package com.yaz.service;

import java.util.List;

import com.yaz.entity.Customer;
import com.yaz.entity.HesapHareketi;
import com.yaz.entity.Kampanya;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(String userName, String password);
	
	public Customer getCustomer(String userName);

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
//----------------------------KAMPANYALAR------------------------------

	public List<Kampanya> getKampanyalar();

	public void saveKampanya(Kampanya kampanya);

	public Kampanya getKampanya(int kampanyaId);

	public void deleteKampanya(int kampanyaId);
	
//----------------------------HesapHareketleri------------------------------
	public List<HesapHareketi> getHesapHareketleri();

	public void saveHesapHareketi(HesapHareketi hesapHareketi);

	public HesapHareketi getHesapHareketi(int hesapHareketiId);

	public void deleteHesapHareketi(int hesapHareketiId);
	
}
