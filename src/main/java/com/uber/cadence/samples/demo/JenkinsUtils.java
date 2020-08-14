package com.uber.cadence.samples.demo;

import static com.uber.cadence.samples.demo.Configuration.JENKINS_PASSWORD;
import static com.uber.cadence.samples.demo.Configuration.JENKINS_USERNAME;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.BuildWithDetails;
import com.offbytwo.jenkins.model.JobWithDetails;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class JenkinsUtils implements Constants {

  /**
   * 根据job名称触发Jenkins构建
   *
   * @param paramJobName name of job
   * @return result of latest build
   */
  public static BuildWithDetails triggerJenkins(String paramJobName, String JENKINS_URL) {
    try {

      JenkinsServer jenkinsServer =
          new JenkinsServer(new URI(JENKINS_URL), JENKINS_USERNAME, JENKINS_PASSWORD);
      JobWithDetails jobWithDetails = jenkinsServer.getJob(paramJobName);
      int nextNum = jobWithDetails.getNextBuildNumber();
      // Map<String, String> param = new HashMap<>();
      // param.put("key", "parameter");
      jobWithDetails.build();
      System.out.println("building this job...");
      while (jobWithDetails.getBuildByNumber(nextNum) == null) {

        Thread.sleep(10000);
       /* Scanner sc =
            new Scanner(
                new File(
                    "C:\\Program Files (x86)\\Jenkins\\jobs\\demo\\builds\\" + nextNum + "\\log"));
        while (sc.hasNextLine()) {
          System.out.println(sc.nextLine());
        }
        */
      }
    } catch (IOException | URISyntaxException | InterruptedException e) {
      e.printStackTrace();
    }

    return null;
  }
}
