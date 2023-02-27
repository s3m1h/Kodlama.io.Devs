package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.Language;

public interface LanguageDao {

	List<Language> getAll();
	void add(Language language);
	void delete(Language language);
	void update();
	Language getById(int id);
}
