/*
//package ca.uwo.csd.cs2212.team13;
 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

  public class App {
  static Logger logger = LogManager.getLogger (App.class.getName());
  public static void main ( String[] args ) throws IOException {
    logger.trace("Entering main");
    logger.warn("Hello Maven/log4j World"); 
    logger.info("My username is team13"); 

    // Configure GSON
    final GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(ActivitiesRecord.class, new ActivitiesRecordDeserializer());
    gsonBuilder.setPrettyPrinting();
    final Gson gson = gsonBuilder.create();

    // Read the JSON data
    try (Reader data = new InputStreamReader(Main.class.getResourceAsStream("activities.json"), "UTF-8")) {

      // Parse JSON to Java
      final ActivitiesRecord actRecord = gson.fromJson(data, ActivitiesRecord.class);

		LifetimeView ltView = new LifetimeView();

		LifetimeRecord ltModel = actRecord.getLifetime();
		LifetimeController ltController = new LifetimeController(ltModel, ltView);
		
		ltView.setVisible(true);

}


   logger.trace("Exiting main");  
} 

}
*/
 
