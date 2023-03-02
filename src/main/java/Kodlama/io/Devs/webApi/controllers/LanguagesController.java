package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import Kodlama.io.Devs.entities.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;	
	@Autowired
	public LanguagesController(LanguageService languageService){
		this.languageService = languageService;
	}
	@GetMapping("/getall")
	public List<GetAllLanguageResponse > getAll(){
		return languageService.getAll();
	}
	@GetMapping("/getbyid/{id}")
	public Language getById(@PathVariable int id) {
		return languageService.getById(id);
	}
	@PostMapping("/add")
	public void add(@RequestBody Language language) throws Exception{
		languageService.add(language);
	}
}
