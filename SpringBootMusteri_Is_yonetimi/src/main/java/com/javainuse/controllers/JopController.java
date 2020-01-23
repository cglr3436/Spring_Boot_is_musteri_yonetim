package com.javainuse.controllers;

import com.javainuse.model.Jop;
import com.javainuse.model.JopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class JopController {

	@Autowired
	private JopService jopService;
	
	@RequestMapping("/jop")
	public ModelAndView homejop() {
		List<Jop> listJop = jopService.listAll();
		ModelAndView mav = new ModelAndView("allJop");
		mav.addObject("listJop", listJop);
		return mav;
	}
	
	@RequestMapping("/newJop")
	public String newJopForm(Map<String, Object> model) {
		Jop jop = new Jop();
		model.put("jop", jop);
		return "new_jop";
	}

	@RequestMapping(value = "/saveJop", method = RequestMethod.POST)
	public String saveJop(@ModelAttribute("jop") Jop jop) {
		jopService.save(jop);
		return "redirect:/jop";
	}
	
	@RequestMapping("/editJop")
	public ModelAndView editJopForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_jop");
		Jop jop = jopService.get(id);
		mav.addObject("jop", jop);
		return mav;
	}
	
	@RequestMapping("/deleteJop")
	public String deleteJopForm(@RequestParam long id) {
		jopService.delete(id);
		return "redirect:/jop";
	}
	
	@RequestMapping("/searchJop")
	public ModelAndView search(@RequestParam String keyword) {
		List<Jop> result = jopService.search(keyword);
		ModelAndView mav = new ModelAndView("searchJop");
		mav.addObject("result", result);
		return mav;		
	}

	@RequestMapping(value = "/listJop.html", method = RequestMethod.GET)
	public ModelAndView jop() {
		List<Jop> allJop = jopService.listAll();
		return new ModelAndView("allJop", "listJop", allJop);

	}
}
