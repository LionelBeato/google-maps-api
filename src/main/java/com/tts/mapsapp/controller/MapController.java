package com.tts.mapsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.mapsapp.model.Location;
import com.tts.mapsapp.service.MapService;

@Controller
public class MapController {
	
	@Autowired
	MapService mapService; 
	
	@GetMapping("/home")
	public String getDefaultMap(Model model) {
		Location location = new Location(); 
		location.setCity("Dallas");
		location.setState("Texas");
		mapService.addCoordinates(location);
//		System.out.println(location); 
		
		model.addAttribute(new Location()); 
		return "index.html";
	}
	
	@PostMapping("/home")
	public String getMapForLocation(Location location, Model model) {
		mapService.addCoordinates(location);
		model.addAttribute(location);
		return "index.html"; 
	}
	

}
