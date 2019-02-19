package astralplane.spell.model;

import org.springframework.stereotype.Component;

/**
 * Command Object for filter form on '/spells' template
 * Properties may be different than their Model/Entity counterparts to allow use of Nulls
 * @author ianww
 *
 */

@Component
public class SpellFilterFormModel {

	private String name;
	private Integer level;
	private String school;
	private Boolean ritual;
	private String castingTime;
	
	public SpellFilterFormModel() {}
	
	// Populates select list using thymeleaf
	public enum schoolsEnum {
		Abjuration, Conjuration, Divination, Enchantment, Evocation, Illusion, Necromancy, Transmutation
	}
	
	/*
	 * Getters and Setters
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	public String getSchool() {
		return school;
	}
	
	public void setRitual(Boolean ritual) {
		this.ritual = ritual;
	}
	
	public Boolean getRitual() {
		return ritual;
	}
	
	public void setCastingTime(String castingTime) {
		this.castingTime = castingTime;
	}
	
	public String getCastingTime() {
		return castingTime;
	}

}
