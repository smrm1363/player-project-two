# **Players game**

This is a test project for showing my skills in Java. The project runs two instances of the Player class in the same process.

I did not do the additional challenge because my shortage of time but if we want to run the player game in two different process, we could have two different jar files and run them at the same time.
The solution for sharing queues is using an external queue broker and both players programs call the queues. 
I used Adapter design pattern and if I wanted to implement the project for running in two separate process I should implement another adapter for using to the outer queue. 
# **How to run:**
Follow these steps:

- Use "mvn install" command to build the jar file
- Then go to the created target directory  
- run the application via bellow command:

java -jar player-project-1.0.jar

-------------------------------------------------------------------------

Although this project is just a sample and not complete I hope this test project satisfies you about my technical skills.

Thank you for your  consideration,

Mohammadreza Mirali 