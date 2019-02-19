package astralplane.spell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import astralplane.spell.exception.SpellResourceException;
import astralplane.spell.model.SpellFilterFormModel;
import astralplane.spell.model.SpellModel;
import astralplane.spell.repository.SpellRepository;

@Controller
public class SpellController {
	
	SpellRepository spellRepository;
	SpellFilterFormModel filterForm;
	
	public SpellController(SpellRepository spellRepository, SpellFilterFormModel filterForm) {
		this.spellRepository = spellRepository;
		this.filterForm = filterForm;
	}

	@GetMapping("/spells")
	public ModelAndView spellsList(Model model) {
		// add Key/Value pair to model so that Thymeleaf can parse query
		model.addAttribute("spellList", spellRepository.findAll());
		model.addAttribute("spellFilterFormModel", filterForm);
		return new ModelAndView("spells");
	}
	
	@PostMapping("/spells")
	public ModelAndView filterSpellListSubmit(@ModelAttribute SpellFilterFormModel spellFilters, Model model) {
		model.addAttribute("spellList", spellRepository.findSpellsByFilter(spellFilters));
		return new ModelAndView("spells");
	}
	
	@PostMapping("/spells/clearForm")
	public ModelAndView clearForm(Model model) {
		return spellsList(model);
	}

	@GetMapping("/spell/{id}")
	public ModelAndView getSpellView(@PathVariable int id, Model model) {
		// Eventually move such logic out of the controller and into a service
		// Keep Controller as accepting REST and model building only
		SpellModel spell = spellRepository.findById(id)
				.orElseThrow(() -> new SpellResourceException(id));
		
		model.addAttribute("spell", spell);
		return new ModelAndView("spell");
	}
}
