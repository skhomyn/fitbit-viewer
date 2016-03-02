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
      
		InterfaceView view = new InterfaceView();
		view.setVisible(view);
		
		BestDaysRecord bdModel = actRecord.getBest();
		BestDaysController bdController = new BestDaysController(bdModel, view);

		LifetimeRecord ltModel = actRecord.getLifetime();
		LifetimeController ltController = new LifetimeController(ltModel, view);
    }


  }
}
