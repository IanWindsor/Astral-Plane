package astralplane.spell.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import astralplane.spell.model.SpellModel;

/**
 * All SQL statements and Mapping for Spells 
 * @author ianww
 *
 */
public class SpellMapper implements RowMapper<SpellModel> {
	
	/**
	 * Retrieve all columns and rows from Spells table
	 */
	public static final String BASE_SQL = "SELECT * FROM Spells";
	
	/**
	 * Retrieve only columns and rows needed from Spell table
	 * TODO: Eventually include filtering
	 */
	public static final String SPELL_LIST_SQL = "SELECT id, name, level, school, ritual, castingtime, components, concentration, source FROM Spells s";

	/**
	 * Retrieve all columns for a single Spell
	 */
	public static final String SINGLE_SPELL_SQL = "SELECT * FROM spells s WHERE s.id = ?";
	
	/**
	 * Retrieve all columns for spell by filter on name
	 */
	public static final String FILTER_BY_NAME_SQL = "SELECT * FROM spells s WHERE s.name LIKE ?";
	public static final String FILTER_BY_LEVEL_SQL = "SELECT * FROM spells s WHERE s.level = ?";
	public static final String FILTER_BY_SCHOOL_SQL = "SELECT * FROM spells s WHERE s.school = ?";
	public static final String FILTER_BY_RITUAL_SQL = "SELECT * FROM spells s WHERE s.ritual = ?";
	public static final String FILTER_BY_CASTINGTIME_SQL = "SELECT * FROM spells s WHERE s.castingtime = '?'";
	public static final String FILTER_BY_COMPONENTS_SQL = "SELECT * FROM spells s WHERE s.components LIKE '?'";
	public static final String FILTER_BY_CONCENTRATION_SQL = "SELECT * FROM spells s WHERE s.concentration = ?";
	public static final String FILTER_BY_SOURCE_SQL = "SELECT * FROM spell s WHERE s.source = '?'";

	/**
	 * Maps all Column names to model properties
	 */
	@Override
	public SpellModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("ID");
		String name = rs.getString("Name");
		String description = rs.getString("Description");
		String atHigherLevelsDescription = rs.getString("AtHigherLevelsDescription");
		int level = rs.getInt("Level");
		String school = rs.getString("School");
		boolean ritual = rs.getBoolean("Ritual");
		String castingTime = rs.getString("CastingTime");
		String components = rs.getString("Components");
		boolean concentration = rs.getBoolean("Concentration");
		String source = rs.getString("Source");
		return new SpellModel(id, name, description, atHigherLevelsDescription, level, school, ritual, castingTime,
				components, concentration, source);
	}

}
