
package ca.uwo.csd.cs2212.team13;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

  public class App {
  static Logger logger = LogManager.getLogger (App.class.getName());

  public static void main (String[] args ) throws IOException {
    logger.trace("Entering main");
    logger.warn("Hello Maven/log4j World"); 
    logger.info("My username is team13"); 


	Main run = new Main();
	run.run();

   logger.trace("Exiting main");  
} 

}

 
