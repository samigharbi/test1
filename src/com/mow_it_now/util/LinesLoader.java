package com.mow_it_now.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads File into String lines
 * 
 * @author sami
 * 
 */
public class LinesLoader {
  private InputStream inputStream;

  
  public LinesLoader(InputStream inputStream) {
    super();
    this.inputStream = inputStream;
  }


  public List<String> getLines() throws IOException {
    List<String> lines = new ArrayList<>();

    try (BufferedReader b = new BufferedReader(new InputStreamReader(inputStream,Charset.defaultCharset()))) {
      String line;
      while ((line = b.readLine()) != null) {
	lines.add(line);
      }
    }

    return lines;
  }
}
