/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trAndpl.pojo;

/**
 *
 * @author Dell
 */
public class ResultPojo extends ParticipantsPojo {
    private String pId;
    private String jobId;
    private double percentage;
    private String selectedByHr;
    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getSelectedByHr() {
        return selectedByHr;
    }

    public void setSelectedByHr(String selectedByHr) {
        this.selectedByHr = selectedByHr;
    }
    
}

