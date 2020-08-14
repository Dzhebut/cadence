package com.uber.cadence.samples.demo;

import com.uber.cadence.worker.Worker;

public class DemoWorker {

  public static void main(String[] args) {

    Worker.Factory factory = new Worker.Factory("test-domain");
    final Worker worker = factory.newWorker("demo");
    Configuration.proper();
    worker.registerWorkflowImplementationTypes(DemoWorkflowImpl.class);
    worker.registerActivitiesImplementations(
        new ShutdownVMActivityImp(),
        new ShutdownK8sActivityImp(),
        new DeployVMActivityImp(),
        new DeployK8sActivityImp());
    // Start all workers created by this factory.
    factory.start();
    System.out.println("Worker started for task list: demo");
  }
}
