# team-manager-jdbc

## Overview

The small console application for managing teams, developers, and their skills using JDBC and RDBMS MySQL.

## Prerequisites

- Install the latest version of Java and set up environment variables *(if necessary)*.

  > [JDK](https://www.oracle.com/java/technologies/javase-downloads.html)<br>
  > **or**<br>
  > [OpenJDK](https://openjdk.java.net/install/)

- Install the Git.

  > [Git](https://git-scm.com/downloads)

- Install the MySQL server.

  > [MySQL](https://www.mysql.com/downloads/)

- Install a Java IDE (for example: Intellij IDEA, Eclipse, NetBeans).

  > [Intellij IDEA](https://www.jetbrains.com/idea/download/#section=windows) (recommended)<br>
  > [Eclipse](https://www.eclipse.org/downloads/)<br>
  > [NetBeans](https://netbeans.apache.org/download/)

## Run the example

1. Clone the repository.<br>

    `git clone https://github.com/MelnykVL/team-manager-jdbc.git`

2. Open the project with the Intellij IDEA.
3. Load Maven changes.
4. Set your settings in **liquibase.properties** file.
5. Create the database called ***team_manager***.
6. Using Maven in Intellij IDEA, run `liquibase:update` to create tables in the database.
7. Run the project.
