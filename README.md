# Fitbit Viewer: Interactive Desktop Application 

Team 13 has developed a user-friendly and innovative new application that receives Fitbit data. The user of this application can use it for tracking statistics, reviewing accolades and monitoring their goals.

[Demo Video](https://www.youtube.com/watch?v=YdT6j8WAM5M)

_Please note: Graphics of this application are optimized for Mac OS X only._

### Specs & Dependencies 

This application is written entirely in Java and uses a modified MVC pattern for integration with Java Swing. The online mode of this application uses OAuth 2.0 for authentication. Maven is used for build automation. 


Fitbit Viewer also uses several open source libraries: 
- [gson](https://github.com/google/gson) for JSON encoding/decoding 
- [scribeJava](https://github.com/meolocke/scribejava) for authentication  
- [commons lang](https://commons.apache.org/proper/commons-lang/) for manipulation of classes in the java.lang package
- [jFreeChart](http://www.jfree.org/jfreechart/) for the time series charts 
- [jCommon](http://www.jfree.org/jcommon/) for support of the JFreeChart library
- [jDatePicker](https://jdatepicker.org) for the built-in calendar, including some minor modifications of the [constraints](https://github.com/JDatePicker/JDatePicker/tree/master/src/main/java/org/jdatepicker/constraints) classes not included in release 1.3.4
- [log4j](http://logging.apache.org/log4j/2.x/) for logging

Full documentation of this application can be found in our [javadoc](src/doc).

### Modes of Operation
###### Test mode
Offline version of the application; no access to a user account.

###### Online mode 
Fully functional version of the application.  


### Build
First, you will need to [install Maven](https://maven.apache.org/install.html).
Next, generate an ssh key. 
In Git Bash or Terminal, type: 
```
"ssh-keygen -t rsa -b 4096" 
"cd ~/.ssh"
"chmod 600 id_rsa"
"cat ~/.ssh/id_rsa.pub"
```

Go to your repository on the BitBucket website. Add the public key.
Next, you need to make a directory, type:
				
`mkdir cs2212`

Next, change directory into the directory you just created, type:

`cd cs2212`

To clone team 13’s repository, type:

`git clone ssh://git@repo.gaul.csd.uwo.ca:7999/cs2212_w2016/team13.git`

Now you have successfully cloned the repository. You have access to team 13’s files. 
To create the .jar file, type:
```
cd team13
mvn compile
mvn package
```
	
### Run

From the root directory of the repository:

###### Test (offline) Mode: 
`java -jar target/team13-fitbitApp-1.0-SNAPSHOT-jar-with-dependencies.jar test`

###### Online Mode:
`java -jar target/team13-fitbitApp-1.0-SNAPSHOT-jar-with-dependencies.jar`


