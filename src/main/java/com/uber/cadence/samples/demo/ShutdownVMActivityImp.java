package com.uber.cadence.samples.demo;

import java.util.Map;

public class ShutdownVMActivityImp implements ShutdownVMActivity {
  @Override
  public String execute(Map<String, String> inputParam) {
    System.out.println("ShutdownVMActivity::execute");
    return "";
  }
}
