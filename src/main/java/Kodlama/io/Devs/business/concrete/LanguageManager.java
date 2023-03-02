package Kodlama.io.Devs.business.concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageDao;
import Kodlama.io.Devs.entities.Language;

@Service
public class LanguageManager implements LanguageService{
	private LanguageDao languageDao;

	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}
	@Override
	public List<GetAllLanguageResponse> getAll() {
		var languages = languageDao.findAll();
		List<GetAllLanguageResponse> getAllLanguages = new ArrayList<>();
		
		
		for (Language language : languages) {
			GetAllLanguageResponse getAllLanguageResponse = new GetAllLanguageResponse();
			getAllLanguageResponse.setId(language.getId());
			getAllLanguageResponse.setName(language.getName());
			getAllLanguages.add(getAllLanguageResponse);
		}
		return getAllLanguages;
	}

	@Override
	public void add(Language language) throws Exception{
		programmingLanguageCheckNameRepetition(language);
		programmingLanguageNameCannotBeBlank(language);
		programmingLanguageCannotBeBlank(language);
		languageDao.save(language);
		System.out.println(language.getName() + " eklendi");
	}

	@Override
	public Language getById(int id) {
		//var result = languageDao.getById(id);
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Language language) {
		languageDao.delete(language);
	}
	
	void programmingLanguageCannotBeBlank(Language language) throws Exception{
		if(language == null) {
			throw new Exception("programlama dili boş geçilemez");
		}
	}
	void programmingLanguageNameCannotBeBlank(Language language) throws Exception{
		if(language.getName() == "") {
			throw new Exception("programlama dili ismi boş geçilemez");
		}
	}
	void programmingLanguageCheckNameRepetition(Language language) throws Exception{
		var items = languageDao.findAll();
		for (var item : items) {
			if(item.getName().equals(language.getName())) {
				throw new Exception("isimler tekrar edemez..");
			}
		}
	}
	

}
