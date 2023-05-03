#Children's TTRPG Character Sheet Creator
#####Written by Kalie Schrader<br>
This project is a Spring Boot-based application designed to help children create their own custom characters for Dungeons and Dragons! It is easy to use, interactive, and engaging. Through the use of visual aids and simple desciptions, children should be able to use the application all by themselves to learn and discover D&D!
***
Features
--
* Intuitive and simple user interface that is easy to navigate
* Customizable character creation options, including race, class, ability scores, weapons, spells, and more
* Colorful art to represent classes and races that was commissioned custom for the site!
* A page to view all of a users previous character sheets, so children can make as many as they want and revisit them
* Secure login features with parent email and encrypted passwords
* Parent information page to explain what they should expect from the page before their child signs on
***
Core Java and Convention Rubric Requirements
--
1. The project package structure should be shown in class, where the models, DAO/repositories, services, controllers, and exceptions, etc., have a package. Views or templates do not require a package
2. Each class should include comments to describe the class and the methods
3. Have the project pushed into GitHub from the early stage of development and hosted on GitHub with a “readme” file documenting an overview of your project
4. Standard Java naming conventions should be followed
5. Utilize Java classes with constant variables. The value of these variables can be requested parameters, SQL queries used in the DAO, names of HTML pages, or URL patterns to forward a request to
6. Have at least four models and corresponding tables in a relational database
7. Apply exception handling
***
Database Rubric Requirements
--
1. Use MySQL as your DBMS
2. Include a schema diagram of the tables and the SQL you used for the database
3. The database configuration file must be set up correctly in your Spring application through “spring initializr”
4. Include at least three custom queries
5. Use Hibernate or Jakarta Persistence API (JPA) directly or through Spring Data JPA
6. Your application should include examples for all four CRUD operations
***
Front-end Rubric Requirements
--
1. Use CSS to style the Web pages. Use an external CSS stylesheet. (Here I have used Bootstrap)
2. Your application should include six different views/pages.
3. Use HTML to lay out the pages and Thymeleaf to make the pages dynamic.
4. Use at least one JavaScript script linked from an external script file. (Here I have used Bootstrap and internal JQuery)
5. Include a navigation section that is included across multiple pages
***
Spring Framework Rubric Requirements
--
1. Use Spring Boot to develop your project
2. Models should be annotated for binding using Spring data binding through Jakarta and/or Hibernate validation
3. Include and implement at least two repositories and two service classes/interfaces
4. Include at least two ways to create a managed bean/object
5. Use correct implementations of dependency injection with appropriate use of the @Autowired annotation .
6. Include at least one example of session management
7. Use Transaction and request/response logging
8. Implement Web Services ( JAX-WS, JAX-RS, or Spring REST )
9. Include sign-up and login functionality with hashing passwords using bcrypt
***
Unit Testing Rubric Requirements
--
1. Test each query method created in the repositories
2. Test at least one method in each service class
3. Include at least one parameterized test
***
Presentation Rubric Requirements
--
1. Create a short overview of your application
2. Highlight the business use cases of your presentation
3. Highlight how your application works from the technical perspective (high level)
4. Highlight what you have learned from this case study development
5. Discuss additional features that you think could be added in the future 
