CREATE TABLE developers (
    developer_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    team_id INT,
    PRIMARY KEY(developer_id),
    FOREIGN KEY(team_id) REFERENCES teams(team_id)
) ENGINE=INNODB
GO