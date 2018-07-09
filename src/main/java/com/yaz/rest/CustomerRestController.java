package com.yaz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaz.entity.Customer;
import com.yaz.entity.HesapHareketi;
import com.yaz.entity.Kampanya;
import com.yaz.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/frusers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@PostMapping("/frusers")
	public Customer addCustomer(@RequestBody Customer theCustomer){
		
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("/frusers")
	public Customer updateCustomer(@RequestBody Customer theCustomer){
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@DeleteMapping("/frusers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId){
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		if(tempCustomer == null)
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted Customer id - " + customerId;
	}
	
	@PostMapping("/frusers/user/pass")
	public Customer getCustomer(@RequestHeader String userName, @RequestHeader String password){
		Customer theCustomer = customerService.getCustomer(userName, password);
		
		if(theCustomer == null)
			throw new CustomerNotFoundException("UserName or password not found - " + userName + " " +password);
		
		return theCustomer;
	}
	
	@PostMapping("/frusers/user")
	public Customer getCustomer(@RequestHeader String userName){
		Customer theCustomer = customerService.getCustomer(userName);
		
		if(theCustomer == null)
			throw new CustomerNotFoundException("UserName not found - " + userName);
		
		return theCustomer;
	}
	
	@PostMapping("/frusers/find")
	public Customer getCustomer(@RequestHeader int customerId){
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer == null)
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		
		return theCustomer;
	}
	
	
	@PostMapping("/frusers/multiple")
	public Customer[] addCustomers(@RequestBody Customer[] theCustomers){
		
		for(int i = 0; i < theCustomers.length; i++) {
			theCustomers[i].setId(0);
			
			customerService.saveCustomer(theCustomers[i]);
		}
		
		return theCustomers;
	}
	
	
	
//-----------------------------------KAMPANYALAR----------------------------------
	
	@GetMapping("/kampanyalar")
	public List<Kampanya> getKampanyalar(){
		return customerService.getKampanyalar();
	}
	
	@PostMapping("/kampanyalar")
	public Kampanya addKampanya(@RequestBody Kampanya kampanya){
		
		kampanya.setId(0);
		
		customerService.saveKampanya(kampanya);
		
		return kampanya;
	}
	
	@PutMapping("/kampanyalar")
	public Kampanya updateKampanya(@RequestBody Kampanya kampanya){
		
		customerService.saveKampanya(kampanya);
		
		return kampanya;
	}
	
	@DeleteMapping("/kampanyalar/{kampanyaId}")
	public String deleteKampanya(@PathVariable int kampanyaId){
		
		Kampanya kampanya = customerService.getKampanya(kampanyaId);
		
		if(kampanya == null)
			throw new CustomerNotFoundException("Kampanya id not found - " + kampanyaId);
		
		customerService.deleteKampanya(kampanyaId);
		
		return "Deleted Kampanya id - " + kampanyaId;
	}
	
	
//-----------------------------------HESAP HAREKETÝ----------------------------------

	@GetMapping("/hesapHareketleri")
	public List<HesapHareketi> getHesapHareketleri(){
		return customerService.getHesapHareketleri();
	}
	
	@PostMapping("/hesapHareketleri")
	public HesapHareketi addHesapHareketi(@RequestBody HesapHareketi hesapHareketi){
		
		hesapHareketi.setId(0);
		
		customerService.saveHesapHareketi(hesapHareketi);
		
		return hesapHareketi;
	}
	
	@PutMapping("/hesapHareketleri")
	public HesapHareketi updateHesapHareketi(@RequestBody HesapHareketi hesapHareketi){
		
		customerService.saveHesapHareketi(hesapHareketi);
		
		return hesapHareketi;
	}
	
	@DeleteMapping("/hesapHareketleri/{hesapHareketiId}")
	public String deleteHesapHareketi(@PathVariable int hesapHareketiId){
		
		HesapHareketi hesapHareketi = customerService.getHesapHareketi(hesapHareketiId);
		
		if(hesapHareketi == null)
			throw new CustomerNotFoundException("HesapHareketi id not found - " + hesapHareketiId);
		
		customerService.deleteHesapHareketi(hesapHareketiId);
		
		return "Deleted HesapHareketi id - " + hesapHareketiId;
	}
}
