CREATE TABLE teams (
    team_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    team_status ENUM('ACTIVE','DELETED') NOT NULL DEFAULT 'ACTIVE',
    PRIMARY KEY(team_id)
) ENGINE=INNODB
GO