package iww.astralplane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import iww.astralplane.dao.SpellDAO;

@Controller
public class SpellController {

	@Autowired
	private SpellDAO spellDao;

	@GetMapping(value = "spells")
	public ModelAndView getSpellListView(Model model) {
		// add Key/Value pair to model so that Thymeleaf can parse query
		model.addAttribute("spellList", spellDao.getSpellList());
		// return name of template to return
		return new ModelAndView("spells");
	}

	@GetMapping(value = "spell/{id}")
	public ModelAndView getSpellView(@PathVariable int id, Model model) {
		model.addAttribute("spell", spellDao.getSpell(id));
		return new ModelAndView("spell");
	}

}
