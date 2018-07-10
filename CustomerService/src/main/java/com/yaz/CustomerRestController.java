package com.yaz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
//	@Autowired
	private CustomerDAO customerDAO;
	
	public CustomerRestController() {
		
	}
	
	public CustomerRestController(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	@GetMapping("/frusers")
	public Iterable<Customer> getCustomers(){
		return customerDAO.findAll();
	}
	
	@PostMapping("/frusers")
	public Customer addCustomer(@RequestBody Customer theCustomer){
		
		//theCustomer.setId(0);
		
		customerDAO.save(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("/frusers")
	public Customer updateCustomer(@RequestBody Customer theCustomer){
		
		customerDAO.save(theCustomer);
		
		return theCustomer;
	}
	
	@DeleteMapping("/frusers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId){
		
		Optional<Customer> tempCustomer = customerDAO.findById(customerId);
		
		if(tempCustomer == null)
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		
		customerDAO.deleteById(customerId);
		
		return "Deleted Customer id - " + customerId;
	}
}
