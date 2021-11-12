DROP TABLE IF EXISTS Language_Table;

CREATE TABLE Language_Table
(
	id integer AUTO_INCREMENT,
	foreign_word VARCHAR(255),
	word_type VARCHAR(255),
	word_translation VARCHAR(255),
	word_category VARCHAR(255),
	priority_word boolean NOT NULL,
	memorised_word boolean NOT NULL
);