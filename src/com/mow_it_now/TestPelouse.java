package com.mow_it_now;

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
  public static final String RESOURCES_FOLDER = "/resources/";
  public static final String CONFIG_FILE = RESOURCES_FOLDER
      + "config.properties";

  public static void main(String[] args) {

   System.out.println("salut");
  }
}
