package com.uber.cadence.samples.demo;

import java.util.Map;

public class DeployK8sActivityImp implements DeployK8sActivity {
  @Override
  public String execute(Map<String, String> inputParam) {
    System.out.println("DeployK8sActivity::execute");
    return "";
  }
}
