package com.uber.cadence.samples.demo;

import static com.uber.cadence.samples.demo.Configuration.JENKINS_JOBNAME;

import com.offbytwo.jenkins.model.BuildWithDetails;
import java.util.Map;

public class DeployVMActivityImp implements DeployVMActivity {

  @Override
  public String execute(Map<String, String> inputParam) {
    System.out.println("DeployVMActivity::execute");
    BuildWithDetails buildWithDetails =
        JenkinsUtils.triggerJenkins(JENKINS_JOBNAME, Configuration.deployURL);

    return "";
  }
}
