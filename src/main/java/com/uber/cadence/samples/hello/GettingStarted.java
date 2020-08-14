package com.uber.cadence.samples.hello;

import com.uber.cadence.worker.Worker;
import com.uber.cadence.workflow.Workflow;
import com.uber.cadence.workflow.WorkflowMethod;
import org.slf4j.Logger;

public class GettingStarted {

  private static Logger logger = Workflow.getLogger(GettingStarted.class);

  public interface HelloWorld {
    @WorkflowMethod
    void sayHello(String name);
  }

  public static class HelloWorldImpl implements HelloWorld {

    @Override
    public void sayHello(String name) {
      System.out.println("Hello " + name + "!");
    }
  }

  public static void main(String[] args) {
    Worker.Factory factory = new Worker.Factory("test-domain");
    Worker worker = factory.newWorker("HelloWorldTaskList");
    worker.registerWorkflowImplementationTypes(HelloWorldImpl.class);
    factory.start();
  }
}
