package Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.entities.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{
}
