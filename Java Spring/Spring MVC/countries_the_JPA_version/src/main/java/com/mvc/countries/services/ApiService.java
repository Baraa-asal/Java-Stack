package com.mvc.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.countries.repositories.CityRepository;
import com.mvc.countries.repositories.CountryRepository;
import com.mvc.countries.repositories.LanguageRepository;


@Service
public class ApiService {

	private final CountryRepository countryRepo;
	private final LanguageRepository langRepo;
	private final CityRepository cityRepo;
	
	@Autowired
	public ApiService(CountryRepository countryRepo,
			LanguageRepository langRepo,
			CityRepository cityRepo) {
		this.countryRepo = countryRepo;
		this.langRepo = langRepo;
		this.cityRepo = cityRepo;
	}
	
	public List<Object[]> countriesSpeakSlovene() {
		return countryRepo.allCountriesWhereLanguageSlovene();
	}
	
	
	public List<Object[]> countryNames() {
		return countryRepo.numberCitiesByCountry();
	}
	
	public List<Object[]> mexicoCities() {
		return cityRepo.citiesInMexicoMoreThan500KPop();
	}
	
	public List<Object[]> languagesPercentGreater89() {
		return langRepo.languagesPercentGreater89();
	}
	
	public List<Object[]> countriesSurfaceAreaBelow501PopGreater100000() {
		return countryRepo.countriesSurfaceAreaBelow501PopGreater100000();
	}
	
	public List<Object[]> countriesConstitutionalMonarchy() {
		return countryRepo.countriesConstitutionalMonarchy();
	}
	
	public List<Object[]> argentinaCitiesInBuenosAires() {
		return cityRepo.argentinaCitiesInBuenosAires();
	}
	
	public List<Object[]> summaryCountriesInRegion() {
		return countryRepo.summaryCountriesInRegion();
	}
}