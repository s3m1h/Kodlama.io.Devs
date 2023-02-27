package Kodlama.io.Devs.dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageDao;
import Kodlama.io.Devs.entities.Language;

@Service
public class InMemoryLanguageDao implements LanguageDao{

	List<Language> languages;
	public InMemoryLanguageDao() {
		languages = new ArrayList<>();
		languages.add(new Language(0,"c"));
		languages.add(new Language(1,"c++"));
		languages.add(new Language(2,"c#"));
	}
	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public void add(Language language) {
		languages.add(language);
		
	}

	@Override
	public void delete(Language language) {
	languages.remove(getById(language.getId()));
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Language getById(int id) {
		for (Language language : languages) {
			if(language.getId() == id) {
				return language;
			}
		}
		return null;
	}

}
