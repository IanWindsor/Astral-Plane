package iww.astralplane.dao;

import iww.astralplane.mapper.SpellMapper;
import iww.astralplane.model.SpellModel;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<SpellModel> getSpells() {
		String sql = SpellMapper.BASE_SQL;
		
		Object[] params = new Object[] {};
		SpellMapper mapper = new SpellMapper();
		List<SpellModel> spellList = this.getJdbcTemplate().query(sql, params, mapper);
		
		return spellList;
	}
	
	//TODO: Create singular spell retrieval, update, and filtering

}
