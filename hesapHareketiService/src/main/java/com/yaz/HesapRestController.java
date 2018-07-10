package com.yaz;

import java.util.Optional;

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
public class HesapRestController {
//	@Autowired
	private HesapDAO hesapDAO;
	
	public HesapRestController() {
		
	}
	
	public HesapRestController(HesapDAO hesapDAO) {
		super();
		this.hesapDAO = hesapDAO;
	}

	@GetMapping("/hesaplar")
	public Iterable<HesapHareketi> getHesaplar(){
		return hesapDAO.findAll();
	}
	
	@PostMapping("/hesaplar")
	public HesapHareketi addHesap(@RequestBody HesapHareketi hesap){
		
		//theCustomer.setId(0);
		
		hesapDAO.save(hesap);
		
		return hesap;
	}
	
	@PutMapping("/hesaplar")
	public HesapHareketi updateHesap(@RequestBody HesapHareketi hesap){
		
		hesapDAO.save(hesap);
		
		return hesap;
	}
	
	@DeleteMapping("/hesaplar/{hesapId}")
	public String deleteHesap(@PathVariable int hesapId){
		
		Optional<HesapHareketi> tempHesap = hesapDAO.findById(hesapId);
		
		if(tempHesap == null)
			throw new HesapNotFoundException("Hesap id not found - " + hesapId);
		
		hesapDAO.deleteById(hesapId);
		
		return "Deleted HesapHareketi id - " + hesapId;
	}
}
