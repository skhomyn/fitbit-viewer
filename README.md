# How to Run Team 13's Prototype

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
Now, to make it run as a .jar file, fortunately a pom file has been made, type:

"cd team13"
"mvn compile"
"mvn package"

The above codes placed Team 13’s code into a .jar file. Type:

"cd target"
	
To run the prototype in test mode type:

"java -jar team13-fitbitApp-1.0-SNAPSHOT-jar-with-dependencies.jar test"

To run the prototype in normal mode: 

"java -jar team13-fitbitApp-1.0-SNAPSHOT-jar-with-dependencies.jar"

