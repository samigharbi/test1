package com.mow_it_now;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	
	public static final Logger LOGGER=Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		File file=new File(args[0]);
		Loader loader;
		try {
			loader = new Loader(file);			
			loader.deplacer();
			for(Tondeuse tondeuse:loader.getPelouse().getTondeuses()){
				if(LOGGER.isLoggable(Level.INFO))
					LOGGER.info(tondeuse.toString());
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		
		

	}
}
