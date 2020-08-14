package com.uber.cadence.samples.demo;

import com.uber.cadence.activity.ActivityOptions;
import com.uber.cadence.workflow.Workflow;
import java.io.FileNotFoundException;
import java.time.Duration;

public class DemoWorkflowImpl implements DemoWorkflow {

  @Override
  public String entryOfWorkflow(String str) {
    ActivityOptions ao =
        new ActivityOptions.Builder()
            .setScheduleToCloseTimeout(Duration.ofSeconds(100))
            .setTaskList("demo")
            .build();
    DeployK8sActivity activityInterface1 = Workflow.newActivityStub(DeployK8sActivity.class, ao);
    activityInterface1.execute(null);
    DeployVMActivity activityInterface2 = Workflow.newActivityStub(DeployVMActivity.class, ao);
    try {
      activityInterface2.execute(null);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    DeployK8sActivity activityInterface3 = Workflow.newActivityStub(DeployK8sActivity.class, ao);
    activityInterface3.execute(null);
    DeployK8sActivity activityInterface4 = Workflow.newActivityStub(DeployK8sActivity.class, ao);
    activityInterface4.execute(null);

    System.out.println("end the workflow execution");
    return null;
  }
}
