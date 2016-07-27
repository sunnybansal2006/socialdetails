package com.social.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.social.exception.UpdateNotFound;
import com.social.model.Update;
import com.social.service.UpdateService;

@Controller
@RequestMapping(value="/update")
public class UpdateController<updateServiceImpl> {
	
	@Autowired
	private UpdateService updateService;
	
	@Autowired
	private Validator updateServiceImpl;
	
	
	
	@InitBinder
	private <updateServiceImpl> void initBinder(WebDataBinder binder) {
		binder.setValidator(updateServiceImpl);
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newUpdatePage() {
		ModelAndView mav = new ModelAndView("update-new", "update", new Update());
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createNewUpdate(@ModelAttribute @Valid Update update,
			BindingResult result,
			final RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors())
			return new ModelAndView("update-new");
		
		ModelAndView mav = new ModelAndView();
		String message = "New Update "+update.getname()+" was successfully created.";
		
		updateService.create(update);
		mav.setViewName("redirect:/index.html");
				
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView updateListPage() {
		ModelAndView mav = new ModelAndView("update-list");
		List<Update> updateList = updateService.findAll();
		mav.addObject("updateList", updateList);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editUpdatePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("update-edit");
		Update update = updateService.findByid(id);
		mav.addObject("update", update);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editUpdate(@ModelAttribute @Valid Update update,
			BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws UpdateNotFound {
		
		if (result.hasErrors())
			return new ModelAndView("update-edit");
		
		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "Successfully updated.";

		updateService.update(update);
		
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteupdate(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws UpdateNotFound {
		
		ModelAndView mav = new ModelAndView("redirect:/index.html");		
		
		Update update = updateService.delete(id);
		String message = "The details "+update.getname()+" were successfully deleted.";
		
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
}
