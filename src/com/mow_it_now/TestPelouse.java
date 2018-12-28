package com.mow_it_now;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mow_it_now.controlers.Monitor;
import com.mow_it_now.controlers.PelouseFactory;
import com.mow_it_now.models.Tondeuse;

/**
 * 
 * @author sami gharbi (sami.gharbi@gmail.com)
 * 
 *         classe qui gère une pelouse
 * 
 */
public class TestPelouse {

  private static final Logger LOGGER = Logger.getLogger(TestPelouse.class
      .getName());
  public static final String CONFIG_FILE = "./resources/config.properties";
  public static final String CURRENT_DIRECTORY = System.getProperty("user.dir");

  public static void main(String[] args) {

    Properties properties = new Properties();
    
    PelouseFactory pelouseFactory;
    try {
      properties.load(new FileInputStream(CONFIG_FILE));
      String fileName = properties.getProperty("file_name");
      String path = CURRENT_DIRECTORY + File.separatorChar + fileName;
      InputStream file = new FileInputStream(path);
      pelouseFactory = new PelouseFactory(file);
      Monitor monitor = new Monitor(pelouseFactory.createPelouse());
      monitor.deplacer();
      for (Tondeuse tondeuse : monitor.getPelouse().getTondeuses()) {
	if (LOGGER.isLoggable(Level.INFO)) {
	  LOGGER.info(tondeuse.toString());
	}
      }
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "erreur d'entrée sortie.", e);
    }

  }
}
