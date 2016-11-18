package main.java.soniatomas.cpe305fall2016project.skinsort;

@SuppressWarnings("serial")
public class DatabaseException extends Exception {
  public DatabaseException() {
    super("DatabaseException: Error connecting to database;");
  }
}
