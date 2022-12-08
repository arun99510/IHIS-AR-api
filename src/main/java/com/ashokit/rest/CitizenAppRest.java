package com.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.binding.CitizenAppBinding;
import com.ashokit.service.ARservice;

@RestController
public class CitizenAppRest {

	@Autowired
	private ARservice arservice;
	
	@PostMapping("/savecitizen")
	public ResponseEntity<String> saveCitizen( @RequestBody CitizenAppBinding appBinding)
	{
		String saveCitizenApp = arservice.saveCitizenApp(appBinding);
		return new ResponseEntity<>(saveCitizenApp,HttpStatus.OK);
	}
	@GetMapping("/viewcitizens")
	public ResponseEntity<List<CitizenAppBinding>> viewCitizens()
	{
		List<CitizenAppBinding> citizenapp = arservice.viewCitizenapp();
		return new ResponseEntity<>(citizenapp,HttpStatus.OK);
	}
}
