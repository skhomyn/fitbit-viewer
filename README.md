<h1><b>CS2212 - Team 13's Final Submission</b></h1>

<h1>A Fitbit Application</h1>

Team 13 has developed a user-friendly and innovative new application that receives Fitbit data. The user of this application can use it for tracking statistics, reviewing accolades and monitoring their goals.

This application has been developed for Mac OS X and implemented by connecting to Fitbit's API. It was built using the programming language Java. Some libraries used to build this application include: Java.io, Java.beans, Java.lang, Java.awt, Javax.swing, Java.util.


<h1>Installation</h1>

First, we need to generate an ssh key. In Git Bash or Terminal, type: 

"ssh-keygen -t rsa -b 4096" 
"cd ~/.ssh"
"chmod 600 id_rsa"
"cat ~/.ssh/id_rsa.pub"

Then you need to go to BitBucket. Add the public key.
Next, you need to make a directory, type:
				
"mkdir cs2212"

Next, change directory into the directory you just created, type:

"cd cs2212"

To clone team 13’s repository, type:

"git clone ssh://git@repo.gaul.csd.uwo.ca:7999/cs2212_w2016/team13.git"

Now you have successfully cloned the repository. You have access to team 13’s files. 
Now, to make it run as a .jar file, fortunately a pom.xml file has been made, type:

"cd team13"
"mvn compile"
"mvn package"

The above codes placed Team 13’s code into a .jar file.
	
To run the prototype in test mode type:

java -jar target/team13-fitbitApp-1.0-SNAPSHOT-jar-with-dependencies.jar test

To run the prototype in normal mode: 

java -jar target/team13-fitbitApp-1.0-SNAPSHOT-jar-with-dependencies.jar


<h1>Construction</h1>

This application was built using the programming language Java and the UI Design was constructed using Adobe Photoshop CS6.  

Our Maven Dependencies and programs required include: json-20160212.jar, scribejava-apis-2.2.2-CS2212.jar, scribejava-core-2.2.2-CS2212.jar gson-2.2.4.jar, commons-lang3-3.2.1.jar, log4j-api2.0-beta9.jar, log4j-core-2.0-beta9.jar, jdatepicker-1.3.4.jar, jfreechart-1.0.19.jar, jcommon-1.0.23.jar

<h1>Video</h1>

Here is a video of our application in action:
 
https://www.youtube.com/watch?v=YdT6j8WAM5M

<h1>Documentation</h1>

Developers, please view our JavaDoc folder by visiting: team13/doc

