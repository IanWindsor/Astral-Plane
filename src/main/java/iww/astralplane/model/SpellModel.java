package iww.astralplane.model;

public class SpellModel {
	private int id;
	private String name;
	private String description;
	private String atHigherLevelsDescription;
	private int level;
	private String school;
	private boolean ritual;
	private String castingTime;
	private String components;
	private boolean concentration;
	private String source;

	public SpellModel(int id, String name, String description, String atHigherLevelsDescription, int level,
			String school, boolean ritual, String castingTime, String components, boolean concentration,
			String source) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.atHigherLevelsDescription = atHigherLevelsDescription;
		this.level = level;
		this.school = school;
		this.ritual = ritual;
		this.castingTime = castingTime;
		this.components = components;
		this.concentration = concentration;
		this.source = source;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setAtHigherLevelsDescription(String atHigherLevelsDescription) {
		this.atHigherLevelsDescription = atHigherLevelsDescription;
	}

	public String getAtHigherLevelsDescription() {
		return atHigherLevelsDescription;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setRitual(boolean ritual) {
		this.ritual = ritual;
	}

	public boolean getRitual() {
		return ritual;
	}

	public void setCastingTime(String castingTime) {
		this.castingTime = castingTime;
	}

	public String getCastingTime() {
		return castingTime;
	}

	public void setComponents(String components) {
		this.components = components;
	}

	public String getComponents() {
		return components;
	}

	public void setConcentration(boolean concentration) {
		this.concentration = concentration;
	}

	public boolean getConcentration() {
		return concentration;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	@Override
	public String toString() {
		return new String("Id: " + id + ", Name: " + name + ", Description: " + description + ", At Higher Levels: "
				+ atHigherLevelsDescription + ", Level: " + level + ", School: " + school + ", Ritual: " + ritual
				+ ", Casting Time: " + castingTime + ", Components: " + components + ", Concentration: " + concentration
				+ ", Source: " + source);
	}
}
