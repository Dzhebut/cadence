package com.uber.cadence.samples.demo;

import java.util.Map;

public class ShutdownK8sActivityImp implements ShutdownK8sActivity {
  @Override
  public String execute(Map<String, String> inputParam) {
    System.out.println("ShutdownK8sActivity::execute");
    return null;
  }
}
