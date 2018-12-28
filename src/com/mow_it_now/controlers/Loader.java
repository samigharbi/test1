package com.mow_it_now.controlers;

import java.io.IOException;

import com.mow_it_now.models.Pelouse;

public interface Loader {

  Pelouse createPelouse() throws IOException;
}
