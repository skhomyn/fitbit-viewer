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

    if (args.length == 0)
    {
      logger.trace("No arguments passed");
      logger.warn("We need to build a program. And we have to do it quickly");
      logger.warn("Run with argument test to test");
    }
    //Check if argument is test
    else if (args.length == 1 && args[1].equals("test"))
    {
      logger.trace("Running test mode");
      Main run = new Main();
      run.run();
    }
    else
    {
      logger.trace("Unvalid arguments passed for now…");
    }
    logger.trace("Exiting main");  
  }
}

 
