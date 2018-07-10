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
public class KampanyaRestController {
//	@Autowired
	private KampanyaDAO kampanyaDAO;
	
	public KampanyaRestController() {
		
	}
	
	public KampanyaRestController(KampanyaDAO kampanyaDAO) {
		super();
		this.kampanyaDAO = kampanyaDAO;
	}

	@GetMapping("/kampanyalar")
	public Iterable<Kampanya> getKampanyalar(){
		return kampanyaDAO.findAll();
	}
	
	@PostMapping("/kampanyalar")
	public Kampanya addKampanya(@RequestBody Kampanya kampanya){
		
		//theCustomer.setId(0);
		
		kampanyaDAO.save(kampanya);
		
		return kampanya;
	}
	
	@PutMapping("/kampanyalar")
	public Kampanya updateKampanya(@RequestBody Kampanya kampanya){
		
		kampanyaDAO.save(kampanya);
		
		return kampanya;
	}
	
	@DeleteMapping("/kampanyalar/{kampanyaId}")
	public String deleteKampanya(@PathVariable int kampanyaId){
		
		Optional<Kampanya> tempHesap = kampanyaDAO.findById(kampanyaId);
		
		if(tempHesap == null)
			throw new KampanyaNotFoundException("Kampanya id not found - " + kampanyaId);
		
		kampanyaDAO.deleteById(kampanyaId);
		
		return "Deleted kampanya id - " + kampanyaId;
	}
}
