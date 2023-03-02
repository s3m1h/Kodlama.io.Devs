package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.TechnologyService;
import Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/technologys")
@AllArgsConstructor
public class TechnologysController {


	private TechnologyService technologyService;
	
	
	@GetMapping
	public List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
	@GetMapping("/{id}")
	public GetByIdTechnologyResponse getById(int id) {
		return technologyService.getById(id);
	}
	
	@PostMapping
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
		technologyService.add(createTechnologyRequest);
	}
	@PutMapping
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		technologyService.update(updateTechnologyRequest);
	}
	@DeleteMapping
	public void delete(int id) {
		technologyService.delete(id);
	}
	
	
	
}
