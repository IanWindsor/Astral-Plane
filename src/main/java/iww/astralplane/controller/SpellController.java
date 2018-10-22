package iww.astralplane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import iww.astralplane.dao.SpellDAO;

@Controller
public class SpellController {

	@Autowired
	private SpellDAO spellDao;

	@RequestMapping(value = "spells", method = RequestMethod.GET)
	public String getSpellView(Model model) {
		// add Key/Value pair to model so that Thymeleaf can parse query
		model.addAttribute("spellList", spellDao.getSpells());
		// return name of template to return
		return "spells";
	}

}
