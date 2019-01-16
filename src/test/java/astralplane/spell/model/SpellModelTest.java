package astralplane.spell.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import astralplane.spell.model.SpellModel;

/**
 * Test POJO creation No validation performed at this level
 * 
 * @author ianww
 *
 */
public class SpellModelTest {

	// Positive tests
	private final static int ID = 1;
	private final static String NAME = "Test";
	private final static String DESCRIPTION = "Testing description.";
	private final static String AT_HIGHER_LEVEL_DESCRIPTION = "Testing at higher levels.";
	private final static int LEVEL = 1;
	private final static String SCHOOL = "Test School";
	private final static boolean IS_RITUAL = false;
	private final static String CASTING_TIME = "Test Action";
	private final static String COMPONENTS = "T";
	private final static boolean CONCENTRATION = true;
	private final static String SOURCE = "Test Book";

	@Test
	public void createSpellTest() {
		SpellModel spell = new SpellModel(ID, NAME, DESCRIPTION, AT_HIGHER_LEVEL_DESCRIPTION, LEVEL, SCHOOL, IS_RITUAL,
				CASTING_TIME, COMPONENTS, CONCENTRATION, SOURCE);
		
		assertThat(spell.getId(), is(ID));
		assertThat(spell.getName().equals((NAME)));
		assertThat(spell.getDescription().equals(DESCRIPTION));
		assertThat(spell.getAtHigherLevelsDescription().equals(AT_HIGHER_LEVEL_DESCRIPTION));
		assertThat(spell.getLevel(), is(LEVEL));
		assertThat(spell.getSchool().equals(SCHOOL));
		assertThat(spell.getRitual(), is(IS_RITUAL));
		assertThat(spell.getCastingTime().equals(CASTING_TIME));
		assertThat(spell.getComponents().equals(COMPONENTS));
		assertThat(spell.getConcentration(), is(CONCENTRATION));
		assertThat(spell.getSource().equals(SOURCE));
	}
}
