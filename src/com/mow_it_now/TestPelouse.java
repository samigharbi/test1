package com.mow_it_now;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mow_it_now.controlers.Loader;
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
  public static final String FILE_NAME=System.getProperty("user.dir"+File.pathSeparator+"tondeuse.txt");

  public static void main(String[] args) {
    /*if ((args==null)||(args.length == 0)) {
      LOGGER.log(Level.SEVERE, "Vous devez spécifier un fichier.");
      return;
    }
    Path path;
    try{
      path=FileSystems.getDefault().getPath(args[0]);
    }catch(InvalidPathException e){
      LOGGER.log(Level.SEVERE, "Le chemin {0} est invalide.", args[0]);
      throw e;
    }
    
    File file = new File(path.toString());
    if (!file.exists()) {
      LOGGER.log(Level.SEVERE, "Le fichier {0} est introuvable.", args[0]);
      return;
    }
    if (!file.canRead()) {
      LOGGER.log(Level.SEVERE, "Vous n''avez pas le droit de lire le fichier {0}", args[0]);
      return;
    }*/
    File file=new File(FILE_NAME);
    Loader loader;
    try {
      loader = new Loader(file);
      loader.deplacer();
      for (Tondeuse tondeuse : loader.getPelouse().getTondeuses()) {
	if (LOGGER.isLoggable(Level.INFO)) {
	  LOGGER.info(tondeuse.toString());
	}
      }
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "erreur d'entrée sortie.", e);
    }

  }
}
