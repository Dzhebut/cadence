package com.uber.cadence.samples.demo;

import java.io.FileNotFoundException;
import java.util.Map;

public interface DeployVMActivity {
  public String execute(Map<String, String> inputParam) throws FileNotFoundException;
}
