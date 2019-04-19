CREATE TABLE UserRoles (
	ID SERIAL PRIMARY KEY,
	RoleName VARCHAR(100) NOT NULL,
	Description VARCHAR(255) NOT NULL
);

INSERT INTO UserRoles(ID, RoleName, Description)
VALUES(1, 'Admin', 'Administrator with full access to entire site.');

INSERT INTO UserRoles(ID, RoleName, Description)
VALUES(2, 'SpellAdmin', 'Administrator with access to add, remove, or edit spells.');

INSERT INTO UserRoles(ID, RoleName, Description)
VALUES(3, 'User', 'Basic access with ability to write to their own profile only.');

CREATE TABLE Users (
	ID SERIAL PRIMARY KEY,
	UserName VARCHAR(100) NOT NULL,
	Password VARCHAR(100) NOT NULL,
	RoleID INT REFERENCES UserRoles(ID),
	Active BOOLEAN NOT NULL
);