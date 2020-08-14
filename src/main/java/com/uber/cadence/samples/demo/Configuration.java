package com.uber.cadence.samples.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Configuration {
  public static List<String> classNames = new ArrayList<>();
  static String stopURL;
  static String deployURL;
  static String startupURL;
  static String JENKINS_USERNAME;
  static String JENKINS_PASSWORD;
  static String JENKINS_JOBNAME;

  public static void proper() {
    Properties properties = new Properties();
    FileReader fileReader = null;
    try {
      fileReader = new FileReader("src\\config.properties");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    try {
      properties.load(fileReader);
    } catch (IOException e) {
      e.printStackTrace();
    }
    stopURL = properties.getProperty("StopURL");
    deployURL = properties.getProperty("DeployURL");
    startupURL = properties.getProperty("StartupURL");
    JENKINS_USERNAME = properties.getProperty("JENKINS_USERNAME");
    JENKINS_PASSWORD = properties.getProperty("JENKINS_PASSWORD");
    JENKINS_JOBNAME = properties.getProperty("JENKINS_JOBNAME");
    classNames.add(properties.getProperty("hc.more.VM.stop.activityClassName"));
    classNames.add(properties.getProperty("hc.more.K8s.stop.activityClassName"));
    classNames.add(properties.getProperty("hc.more.VM.deploy.activityClassName"));
    classNames.add(properties.getProperty("hc.more.K8s.deploy.activityClassName"));
  }
}
