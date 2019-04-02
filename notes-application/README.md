Spring Boot - Notes Application
------------

INTRODUCTION
------------

This project demonstrate spring boot notes application with Thymeleaf

REQUIREMENTS
------------
JDK 1.8+, <br/>
Maven 3.2+,<br/>
Mysql 5.7+,<br/>
Bootstrap 3.3+, Jquery 2.1+

INSTALLATION
------------
 1. Clone project and import as maven project.
 2. Update MYSQL usernane and password under the <strong>application.properties</strong> 
 `spring.datasource.username=` and 
 `spring.datasource.password=`
 
Run Application
------------
1. You can run application
    1. `com.wander.notesapp.notesapplication NotesApplication class` or
    2. `mvn spring-boot:run` or
    3. run  `mvn package` then ` cd target java -jar todoApp.jar` <br/>
    <strong>Hint:</strong> `spring-boot-maven-plugin` is required for java -jar options 
    
    ```
     <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
     </plugin>
    ```
2. [Go-to main page](http://localhost:8080/home) you will be redirected login page
    1. Click registration tab and register with any usermane and password [Go-to register page](http://localhost:8080/register) 
3. Login with your username and password [Go-to login page](http://localhost:8080/login) 
4. Add new note tab is active by default. You can add new notes or modify existing notes
5. Added notes can be viewed by clicking the eye icon, updated by clicking the update icon and deleted by clicking the delete icon.
5. Deleted notes goes to trash box (Delete tab)
    1. Click delete icon delete permanently or
    2. Click restore restore deleted note.
     

###### ThymeLeaf enable hot swapping for dev
`spring.thymeleaf.cache: false
