package com.yaz;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface CustomerDAO extends CrudRepository<Customer, Integer>{
	
}