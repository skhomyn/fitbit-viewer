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
    gsonBuilder.registerTypeAdapter(DailyRecord.class, new DailyRecordDeserializer());
    gsonBuilder.registerTypeAdapter(HeartRateRecord.class, new HeartRateRecordDeserializer());
    gsonBuilder.setPrettyPrinting();
    final Gson gson = gsonBuilder.create();


    InterfaceView view = new InterfaceView();
    view.setVisible(view);
    
    // Read the JSON data
    try (Reader data = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("heartrate.json"), "UTF-8")) {

      // Parse JSON to Java
      final HeartRateRecord hrRecord = gson.fromJson(data, HeartRateRecord.class);
      HRZController hrController = new HRZController(hrRecord, view);
      
      //System.out.println(hrRecord);
      //HeartRateRecord hrzModel = hrRecord;
    }
	
    // Read the JSON data
    try (Reader data = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("date.json"), "UTF-8")) {

      // Parse JSON to Java
      final DailyRecord ddModel = gson.fromJson(data, DailyRecord.class);
      
		  //DailyRecord ddModel = new DailyRecord();
		  DailyDashboardController ddController = new DailyDashboardController(ddModel, view);
		  ddController.DailyDashboardInitialize();	
    }

   try (Reader data = new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("activities.json"), "UTF-8")) {

      // Parse JSON to Java
      final ActivitiesRecord actRecord = gson.fromJson(data, ActivitiesRecord.class);

		  BestDaysRecord bdModel = actRecord.getBest();
		  BestDaysController bdController = new BestDaysController(bdModel, view);

		  LifetimeRecord ltModel = actRecord.getLifetime();
		  LifetimeController ltController = new LifetimeController(ltModel, view);
    }
  }
}
