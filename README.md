# Fitbit Viewer: Interactive Desktop Application 

**Project for Beth Locke's Intro to Software Engineering class at UWO.**

Fitbit Viewer is a cross-platform desktop application that and displays and analyzes health metrics from a user's Fitbit account. It provides a user-friendly solution for tracking statistics, reviewing accolades and monitoring goals. 

*__Note:__ Although this application will run on any platform, graphics are optimized for Mac OS X only.*

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

### Contributors

###### Code Written by:
- Andy Yu
- Robin Wakeman
- Stepan Khomyn
- Johnny Zapras

###### UI Design By:
- [Hannah Russworm](https://github.com/hrusswurm)
- Stepan Khomyn
- [Jenni Street](https://github.com/jstreet2)
- Robin Wakeman

### Modes of Operation
###### Test mode
Offline version of the application; no access to a user account.

###### Online mode 
Fully functional version of the application.  
__To connect to a user account, you will need to:__

1. Log into Fitbit website, and get a Request code from the Authorization server.
2. Trade the request for and Access/Refresh Token pair.
3. Get credentials for the Authorization server: This includes your App ID and a key/secret pair.
4. Place credentials in `/src/main/resources/Team13Credentials.txt`, place refresh/access tokens in `/src/main/resources/Team13Tokens.txt`.

*__Note:__ If everything goes as planned you will get an HTTP response with the code 200, its body will contain a JSON object describing the data you asked for. If it doesn't, and your access token has expired, you will need to ask for a new pair from the authorization server.*

### Build

If you would just like to run the project, you can skip this step. 
A pre-packaged `.jar` file has been provided in the /target directory.  

__However, if you would like to build the project yourself:__

First [install Maven](https://maven.apache.org/install.html).  
In the console:
```
# make a local copy of this repository
git clone https://github.com/robin-wakeman/fitbitViewer.git

# enter the root directory of the respository
cd fitbitViewer

# build project and generate .jar file using maven
mvn compile 
mvn package
```

### Run

From the root directory of the repository:

###### Test (offline) Mode: 
`java -jar target/team13-fitbitApp-1.0-SNAPSHOT-jar-with-dependencies.jar test`

###### Online Mode:
`java -jar target/team13-fitbitApp-1.0-SNAPSHOT-jar-with-dependencies.jar`


### Screenshots 
![Daily Dashboard](../master/screens/Dashboard1.png)
![Daily Dashboard Customization](../master/screens/Dashboard2.png)
![Daily Dashboard Date Change](../master/screens/Dashboard3.png)
![Best Days](../master/screens/BD.png)
![Daily Goals](../master/screens/Goals.png)
![Lifetime Totals](../master/screens/Lifetime.png)
![Accolades](../master/screens/Accolades.png)
![Time Series](../master/screens/TS1.png)
![Time Series Zoom In](../master/screens/TS2.png)
![Heart Rate Zones](../master/screens/HRZ.png)
