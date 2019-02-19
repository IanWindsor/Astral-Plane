CREATE TABLE spell (
	ID SERIAL PRIMARY KEY,
	Name VARCHAR(100) NOT NULL,
	Description TEXT NOT NULL,
	AtHigherLevelsDescription TEXT NULL,
	Level INT NOT NULL,
	School VARCHAR(255) NOT NULL,
	Ritual BOOLEAN NOT NULL,
	CastingTime VARCHAR(25) NOT NULL,
	Components VARCHAR(255) NOT NULL,
	Concentration BOOLEAN NOT NULL,
	Source VARCHAR(50) NOT NULL
);

COPY spell(id,name,level,school,ritual,castingtime,components,concentration,source,description,athigherlevelsdescription) 
FROM 'D:\Projects\Astral Plane Java\AstralPlane\src\main\resources\db\data\SpellListCSV.csv' DELIMITER ',' CSV HEADER;