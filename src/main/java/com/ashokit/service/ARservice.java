package com.ashokit.service;

import java.util.List;

import com.ashokit.binding.CitizenAppBinding;

public interface ARservice {

	public String saveCitizenApp(CitizenAppBinding appBinding);
	
	public  List<CitizenAppBinding> viewCitizenapp();
	
}
