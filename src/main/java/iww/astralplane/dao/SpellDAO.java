package iww.astralplane.dao;

import iww.astralplane.mapper.SpellMapper;
import iww.astralplane.model.SpellModel;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpellDAO extends JdbcDaoSupport {
	
	@Autowired
	public SpellDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public List<SpellModel> getSpellList() {
		String sql = SpellMapper.BASE_SQL;
		
		Object[] params = new Object[] {};
		SpellMapper mapper = new SpellMapper();
		List<SpellModel> spellList = this.getJdbcTemplate().query(sql, params, mapper);
		
		return spellList;
	}
	
	// Singular record retrieval
	public SpellModel getSpell(int id) {
		String sql = SpellMapper.SINGLE_SPELL_SQL;
		
		Object[] params = new Object[] {id};
		try {
			SpellModel spell = this.getJdbcTemplate().queryForObject(sql, params, new SpellMapper());
			return spell;
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//TODO: Create update and filtering

}
