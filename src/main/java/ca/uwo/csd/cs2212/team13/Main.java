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
    final Gson gson = gsonBuilder.create();


    // Read the JSON data
 try (Reader data = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("activities.json"), "UTF-8")) {

      // Parse JSON to Java
      final ActivitiesRecord actRecord = gson.fromJson(data, ActivitiesRecord.class);
      
		InterfaceView view = new InterfaceView();
		view.setVisible(view);

		LifetimeRecord ltModel = actRecord.getLifetime();
		LifetimeController ltController = new LifetimeController(ltModel, view);
		

    }


  }
}
