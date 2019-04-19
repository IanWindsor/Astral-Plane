package astralplane.spell.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import astralplane.spell.model.SpellFilterFormModel;
import astralplane.spell.model.SpellModel;

@Service
public class SpellRepositoryImpl implements SpellRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<SpellModel> findSpellsByFilter(SpellFilterFormModel spellFilterModel) {	
		// Setup Criteria Builder, Query, and Root
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<SpellModel> query = builder.createQuery(SpellModel.class);
		Root<SpellModel> root = query.from(SpellModel.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		// Check incoming spell filters and build query
		if(spellFilterModel.getName() != null && spellFilterModel.getName() != "")
			predicates.add(builder.like(builder.lower(root.get("name")), "%" + spellFilterModel.getName().toLowerCase() + "%"));
		
		if(spellFilterModel.getLevel() != null)
			predicates.add(builder.equal(root.get("level"), spellFilterModel.getLevel()));
		
		if(spellFilterModel.getSchool() != null && spellFilterModel.getSchool() != "")
			predicates.add(builder.equal(builder.lower(root.get("school")), spellFilterModel.getSchool().toLowerCase()));
		
		if(spellFilterModel.getRitual() != null)
			predicates.add(builder.equal(root.get("ritual"), spellFilterModel.getRitual()));
		
		if(spellFilterModel.getCastingTime() != null && spellFilterModel.getCastingTime() != "" )
			predicates.add(builder.equal(builder.lower(root.get("castingTime")), spellFilterModel.getCastingTime().toLowerCase()));

		query = query.select(root).where(predicates.toArray(new Predicate[]{}));
		return em.createQuery(query).getResultList();
	}

	

}
