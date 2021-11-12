DROP TABLE IF EXISTS LanguageTable CASCADE;

CREATE TABLE LanguageTable
(
	id integer AUTO_INCREMENT,
	foreignWord VARCHAR(255),
	wordType VARCHAR(255),
	wordTranslation VARCHAR(255),
	wordCategory VARCHAR(255),
	priorityWord boolean NOT NULL,
	memorisedWord boolean NOT NULL
);