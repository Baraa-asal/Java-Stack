package com.mvc.countries.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.countries.services.ApiService;

@Controller
public class WorldController {
	
	private final ApiService worldService;
	
	public WorldController(ApiService worldService) {
		this.worldService = worldService;
	}
	@RequestMapping("/api/selvone")
	public List<Object[]> Slovene() {
		List<Object[]> all = worldService.countriesSpeakSlovene();
		return all;
	}
	@RequestMapping("/api/query2")
	public List<Object[]> displayTotalCities() {
		List<Object[]> all = worldService.countryNames();
		return all;
	}
	@RequestMapping("/api/query3")
	public List<Object[]> mexicoCities() {
		List<Object[]> all = worldService.countryNames();
		return all;
	}
	@RequestMapping("/api/query4")
	public List<Object[]> languagesPercentGreater89() {
		List<Object[]> all = worldService.countryNames();
		return all;
	}
	@RequestMapping("/api/query5")
	public List<Object[]> countriesSurfaceAreaBelow501PopGreater100000() {
		List<Object[]> all = worldService.countryNames();
		return all;
	}
	@RequestMapping("/api/query6")
	public List<Object[]> countriesConstitutionalMonarchy() {
		List<Object[]> all = worldService.countryNames();
		return all;
	}
	@RequestMapping("/api/query7")
	public List<Object[]> argentinaCitiesInBuenosAires() {
		List<Object[]> all = worldService.countryNames();
		return all;
	}
	@RequestMapping("/api/query8")
	public List<Object[]> summaryCountriesInRegion() {
		List<Object[]> all = worldService.countryNames();
		return all;
	}
}
