package ca.uwo.csd.cs2212.team13;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

public void run() throws IOException {

    // Configure GSON
    final GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(ActivitiesRecord.class, new ActivitiesRecordDeserializer());
    gsonBuilder.setPrettyPrinting();
    
    gsonBuilder.registerTypeAdapter(HeartRateRecord.class, new HeartRateRecordDeserializer());
    final Gson gson = gsonBuilder.create();



    // Read the JSON data
 try (Reader data = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("heartrate.json"), "UTF-8")) {

      // Parse JSON to Java
      final HeartRateRecord hrRecord = gson.fromJson(data, HeartRateRecord.class);
      System.out.println(hrRecord);
    	HeartRateRecord hrzModel = hrRecord;


    }
 
    
    // Read the JSON data
 try (Reader data = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("activities.json"), "UTF-8")) {

      // Parse JSON to Java
     // final ActivitiesRecord actRecord = gson.fromJson(data, ActivitiesRecord.class);
      
<<<<<<< HEAD
      InterfaceView view = new InterfaceView();

		//LifetimeRecord ltModel = actRecord.getLifetime();
		//LifetimeController ltController = new LifetimeController(ltModel, view);
      
		
		view.setVisible(view);
=======
		InterfaceView view = new InterfaceView();
		view.setVisible(view);

		LifetimeRecord ltModel = actRecord.getLifetime();
		LifetimeController ltController = new LifetimeController(ltModel, view);
		
>>>>>>> 92cc61a1dcc635659fb8a9adf1d5a56067af982f

    }


  }
}
