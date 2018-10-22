package iww.astralplane.mapper;

import iww.astralplane.model.SpellModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SpellMapper implements RowMapper<SpellModel> {
	
	// SQL to Select * from Spells table
	public static final String BASE_SQL = "SELECT * FROM Spells s";

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
