package astralplane.spell.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import astralplane.spell.model.SpellFilterFormModel;
import astralplane.spell.model.SpellModel;

/**
 * Each method established of SQL to be used, parameters needed, and mapper required.
 * @author ianww
 *
 */
@Repository
@Transactional
public class SpellDAO extends JdbcDaoSupport {

	/**
	 * DataSource connection defined in application.properties
	 * Spring Boot handles the connection information for us
	 * @param dataSource
	 */
	@Autowired
	public SpellDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<SpellModel> getSpellList() {
		String sql = SpellMapper.BASE_SQL;

		Object[] params = new Object[] {};
		try {
			List<SpellModel> spellList = this.getJdbcTemplate().query(sql, params, new SpellMapper());
			return spellList;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	/**
	 * Retrieve a list of spells by filter values
	 * @param spellFilters
	 * @return
	 */
	public List<SpellModel> getSpellListByFilter(SpellFilterFormModel spellFilters) {
		String sql = SpellMapper.BASE_SQL + " WHERE 1=1";
		List<Object> filters = new ArrayList<Object>();
		
		if(spellFilters.getName() != null && !spellFilters.getName().isEmpty()) {
			sql += " AND LOWER(name) LIKE LOWER(?)";
			filters.add("%" + spellFilters.getName() + "%");
		}
		
		if(spellFilters.getLevel() != null) {
			sql += " AND level = ?";
			filters.add(spellFilters.getLevel());
		}
		
		if(spellFilters.getSchool() != null && !spellFilters.getSchool().isEmpty()) {
			sql += " AND school = ?";
			filters.add(spellFilters.getSchool());
		}
		
		if(spellFilters.getRitual() != null) {
			sql += " AND ritual = ?";
			filters.add(spellFilters.getRitual());
		}
		 
		if(spellFilters.getCastingTime() != null && !spellFilters.getCastingTime().isEmpty()) {
			sql += " AND LOWER(castingtime) = LOWER(?)";
			filters.add(spellFilters.getCastingTime());
		}
		
		Object[] params = filters.toArray();
		
		try {
			 List<SpellModel> filteredSpellList = this.getJdbcTemplate().query(sql, params, new SpellMapper());
			 return filteredSpellList;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// Singular record retrieval
	public SpellModel getSpell(int id) {
		String sql = SpellMapper.SINGLE_SPELL_SQL;

		Object[] params = new Object[] { id };
		try {
			SpellModel spell = this.getJdbcTemplate().queryForObject(sql, params, new SpellMapper());
			return spell;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// TODO: Create update and filtering

}
