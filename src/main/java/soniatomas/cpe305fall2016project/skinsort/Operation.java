package main.java.soniatomas.cpe305fall2016project.skinsort;

import java.util.HashMap;
import java.util.Observable;

public interface Operation { 
  public HashMap<String, Object> execute(HashMap<String, String> parameters);
  public HashMap<String, Object> getVariables();

}
