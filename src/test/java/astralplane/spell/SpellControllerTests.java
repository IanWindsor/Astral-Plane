package astralplane.spell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import astralplane.spell.controller.SpellController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpellControllerTests {
	
	@Autowired
	SpellController controller;
	
	@Autowired
	MockMvc mockMvc;
	
	/**
	 * Test that controller is loaded into Context
	 * @throws Exception
	 */
	@Test
	public void contextLoadsTest() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	/**
	 * Retrieve spell list page and check if status is ok
	 * @throws Exception
	 */
	@Test
	public void getSpellListTest() throws Exception {
		this.mockMvc.perform(get("/spells")).andDo(print()).andExpect(status().isOk());
	}
	
	/**
	 * Retrieve unique spell page and check if status is ok
	 * @throws Exception
	 */
	@Test
	public void getSpellViewTest() throws Exception {
		this.mockMvc.perform(get("/spell/1")).andDo(print()).andExpect(status().isOk());
	}
}
