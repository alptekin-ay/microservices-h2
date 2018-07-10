package com.yaz;


import org.springframework.data.repository.CrudRepository;

import com.yaz.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Integer>{
	
}