package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.Language;

public interface LanguageService {
	List<Language> getAll();
	void add(Language language) throws Exception;
	Language getById(int id);
	void update();
	void delete(Language language);
}
