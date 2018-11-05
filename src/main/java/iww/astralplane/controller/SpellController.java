package iww.astralplane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import iww.astralplane.dao.SpellDAO;
import iww.astralplane.model.SpellFilterFormModel;

@Controller
public class SpellController {

	@Autowired
	private SpellDAO spellDao;

	@GetMapping("/spells")
	public ModelAndView spellsList(Model model) {
		// add Key/Value pair to model so that Thymeleaf can parse query
		model.addAttribute("spellList", spellDao.getSpellList());
		model.addAttribute("spellFilterFormModel", new SpellFilterFormModel());
		// return name of template to return
		return new ModelAndView("spells");
	}
	
	@PostMapping("/spells")
	public ModelAndView filterSpellListSubmit(@ModelAttribute SpellFilterFormModel spellFilters, Model model) {
		model.addAttribute("spellList", spellDao.getSpellListByFilter(spellFilters));
		return new ModelAndView("spells");
	}
	
	@PostMapping("/spells/clearForm")
	public ModelAndView clearForm(Model model) {
		return spellsList(model);
	}

	@GetMapping("/spell/{id}")
	public ModelAndView getSpellView(@PathVariable int id, Model model) {
		model.addAttribute("spell", spellDao.getSpell(id));
		return new ModelAndView("spell");
	}
}
