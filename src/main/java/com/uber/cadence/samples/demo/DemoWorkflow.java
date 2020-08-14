package com.uber.cadence.samples.demo;

import com.uber.cadence.workflow.WorkflowMethod;

public interface DemoWorkflow {

  @WorkflowMethod(taskList = "demo", executionStartToCloseTimeoutSeconds = 200)
  String entryOfWorkflow(String str);
}
