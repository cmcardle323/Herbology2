package com.plantbase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private PlantService plantServ; //inject service to auto create crud layer at runtime
	
	//handler methods here
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Plant> listPlants = plantServ.listAll();
		model.addAttribute("listPlants", listPlants);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
	    Plant plant = new Plant();
	    model.addAttribute("plant", plant);
	    return "new_plant";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePlant(@ModelAttribute("plant") Plant plant) {
	    plantServ.save(plant);
	    return "redirect:/"; //redirects to "/" which redirects to index
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditPlantPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_plant");
	    Plant plant = plantServ.get(id);
	    mav.addObject("plant", plant);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePlant(@PathVariable(name = "id") int id) {
	    plantServ.delete(id);
	    return "redirect:/";       
	}
}
