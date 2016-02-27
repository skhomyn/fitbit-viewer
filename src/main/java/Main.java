/**
 * Copyright 2012-2014 Java Creed.
 * 
 * Licensed under the Apache License, Version 2.0 (the "<em>License</em>");
 * you may not use this file except in compliance with the License. You may 
 * obtain a copy of the License at: 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

  public static void main(final String[] args) throws IOException {
    // Configure GSON
    final GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(ActivitiesRecord.class, new ActivitiesRecordDeserializer());
    gsonBuilder.setPrettyPrinting();
    final Gson gson = gsonBuilder.create();

    // Read the JSON data
    try (Reader data = new InputStreamReader(Main.class.getResourceAsStream("activities.json"), "UTF-8")) {

      // Parse JSON to Java
      final ActivitiesRecord actRecord = gson.fromJson(data, ActivitiesRecord.class);
      
     // System.out.println(actRecord.getBest().getDis_date());
     // System.out.println(actRecord.getLifetime());


		LifetimeView ltView = new LifetimeView();

		LifetimeRecord ltModel = actRecord.getLifetime();
		LifetimeController ltController = new LifetimeController(ltModel, ltView);
		
		ltView.setVisible(true);

    }
  }
}
