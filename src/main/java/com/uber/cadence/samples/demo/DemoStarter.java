package com.uber.cadence.samples.demo;

import com.uber.cadence.WorkflowExecution;
import com.uber.cadence.client.WorkflowClient;

public class DemoStarter {

  public static void main(String[] args) {
    WorkflowClient workflowClient = WorkflowClient.newInstance("test-domain");
    DemoWorkflow workflow = workflowClient.newWorkflowStub(DemoWorkflow.class);

    System.out.println("Executing SimpleDemo");

    WorkflowExecution workflowExecution = WorkflowClient.start(workflow::entryOfWorkflow, "spring");
    System.out.println(
        "Started periodic workflow with workflowId=\""
            + workflowExecution.getWorkflowId()
            + "\" and runId=\""
            + workflowExecution.getRunId()
            + "\"");
    System.exit(0);
  }
}
