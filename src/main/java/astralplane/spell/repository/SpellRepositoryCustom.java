package astralplane.spell.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import astralplane.spell.model.SpellFilterFormModel;
import astralplane.spell.model.SpellModel;

@Repository
public interface SpellRepositoryCustom {
	List<SpellModel> findSpellsByFilter(SpellFilterFormModel spellFilterFormModel);
}
