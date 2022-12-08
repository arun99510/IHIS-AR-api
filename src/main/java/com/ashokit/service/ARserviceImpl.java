package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashokit.binding.CitizenAppBinding;
import com.ashokit.entity.CitizenappEntity;
import com.ashokit.repo.CitizenAppRepo;

@Service
public class ARserviceImpl implements ARservice {

	@Autowired
	private CitizenAppRepo citizenRepo;

	/*
	 * public String saveCitizenApp(CitizenAppBinding appBinding) {
	 * 
	 * String url= "https://ssa-web-api.herokuapp.com/ssn/{ssn}"; RestTemplate
	 * rs=new RestTemplate(); ResponseEntity<String> responseEntity =
	 * rs.getForEntity(url, String.class,appBinding.getSsn()); String stateName =
	 * responseEntity.getBody(); if("New Jersy".equals(stateName)) {
	 * appBinding.setState(stateName); CitizenappEntity entity=new
	 * CitizenappEntity(); BeanUtils.copyProperties(appBinding, entity);
	 * citizenRepo.save(entity); return "Citizen belongs to New Jersystate"; }
	 * return "Citizen belongs to New Jersystate"; }
	 */

	@Override
	public List<CitizenAppBinding> viewCitizenapp() {

		List<CitizenAppBinding>  citizenBindings=new ArrayList<>();
		List<CitizenappEntity> entities = citizenRepo.findAll();
		entities.forEach(citizenList ->{
			CitizenAppBinding appBinding=new CitizenAppBinding();
			BeanUtils.copyProperties(citizenList, appBinding);
			citizenBindings.add(appBinding);
		});
		return  citizenBindings;
		
	}
	@Override
	public String saveCitizenApp(CitizenAppBinding appBinding) {

		if(appBinding.getSsn()==662233)
		{
			String stateName="New Jersy";
			appBinding.setState(stateName);
			CitizenappEntity entity=new CitizenappEntity();
			BeanUtils.copyProperties(appBinding, entity);
			citizenRepo.save(entity);
			return "Citizen Belongs to new Jersystate";
		}
		return "Citizen not Belongs to new Jersystate";
	}

}
