CREATE TABLE developers_skills (
    developer_id INT NOT NULL,
    skill_id SMALLINT NOT NULL,
    PRIMARY KEY(developer_id, skill_id),
    FOREIGN KEY (developer_id) REFERENCES developers(developer_id),
    FOREIGN KEY (skill_id) REFERENCES skills(skill_id)
) ENGINE=INNODB
GO