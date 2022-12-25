/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trAndpl.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trAndpl.dbutil.DbConnection;
import trAndpl.pojo.JobPojo;
import trAndpl.pojo.ParticipantJobPojo;

/**
 *
 * @author Dell
 */
public class JobDAO {
    public static int getNewJobId()throws SQLException {
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select max(jobid) from sys.JOBS");
        int jobId=101;
        rs.next();
        String strid=rs.getString(1);
        if(strid!=null){
            String id=strid.substring(4);
            jobId=Integer.parseInt(id)+1;
        }
        return jobId;
    }
   public static boolean addNewJob(JobPojo job)throws SQLException{
       Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("insert into sys.JOBS values(?,?,?,?,?)");
       ps.setString(1,job.getJobId());
       ps.setString(2, job.getJobTitle());
       ps.setString(3, job.getHrId());
       ps.setString(4, job.getTags());
       ps.setInt(5, job.getStatus());
       return 1==ps.executeUpdate();
       
   }
   public static List<JobPojo>getAllActiveJobsByCurrent(String hrId)throws SQLException{
       Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("Select jobid, jobtitle,tags,status from sys.JOBS where hrid=? and status!=-1");
       ps.setString(1, hrId);
       ResultSet rs=ps.executeQuery();
       List<JobPojo> allJobslist=new ArrayList<>();
       while(rs.next()){
           JobPojo obj=new JobPojo();
           obj.setJobId(rs.getString(1));
           obj.setJobTitle(rs.getString(2));
           obj.setTags(rs.getString(3));
           obj.setStatus(rs.getInt(4));
           allJobslist.add(obj);
           
       }
       return allJobslist;
   }
   public static boolean removejobsbyjobId(String jobId)throws SQLException{
       Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("update sys.JOBS set status=-1 where jobid=?");
       ps.setString(1, jobId);
       return ps.executeUpdate()==1; 
       
   }
   public static List<JobPojo> getAllEditableJobsByCurrentHr(String hrId)throws SQLException{
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("Select jobid,jobtitle,tags,status from sys.JOBS where hrid=? and status=0");
         ps.setString(1,hrId);
         ResultSet rs=ps.executeQuery();
         List<JobPojo> allJobsList=new ArrayList<>();
         while(rs.next()){
             JobPojo obj=new JobPojo();
             obj.setJobId(rs.getString(1));
             obj.setJobTitle(rs.getString(2));
             obj.setTags(rs.getString(3));
             obj.setStatus(rs.getInt(4));
             allJobsList.add(obj);             
         }
         return allJobsList;
    }
    public static boolean editJobByJobId(JobPojo job)throws SQLException{
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update sys.JOBS set jobtitle=?, tags=? where jobid=?");
         ps.setString(1,job.getJobTitle());
         ps.setString(2, job.getTags());
         ps.setString(3,job.getJobId());
         return 1==ps.executeUpdate();
    }
     public static boolean setJobStatus(String jobId)throws SQLException{
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update sys.JOBS set status=1 where jobid=?");
         ps.setString(1, jobId);
         return 1==ps.executeUpdate();
 }
      public static List<JobPojo>getAllOpenJobsByCurrentHr(String hrId)throws SQLException{
       Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("Select jobid, jobtitle,tags,status from sys.JOBS where hrid=? and status=1 order by jobid");
       ps.setString(1, hrId);
       ResultSet rs=ps.executeQuery();
       List<JobPojo> allJobslist=new ArrayList<>();
       while(rs.next()){
           JobPojo obj=new JobPojo();
           obj.setJobId(rs.getString(1));
           obj.setJobTitle(rs.getString(2));
           obj.setTags(rs.getString(3));
           obj.setStatus(rs.getInt(4));
           allJobslist.add(obj);
           
       }
       return allJobslist;
   }
      public static List<ParticipantJobPojo> getAllAvailableJobs()throws SQLException
    {
        Statement st=DbConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select jobid,jobtitle,companyname,tags,j.hrid from sys.JOBS j,sys.HR h where j.hrid=h.hrid and status=1 order by jobid "); 
        List<ParticipantJobPojo> allOpenJobsList=new ArrayList<>();
         while(rs.next()){
             ParticipantJobPojo obj=new ParticipantJobPojo();
             obj.setJobId(rs.getString(1));
             obj.setJobTitle(rs.getString(2));
             obj.setCompanyName(rs.getString(3));
             obj.setTags(rs.getString(4));
             obj.setHrId(rs.getString(5));
             allOpenJobsList.add(obj);             
         }
         return allOpenJobsList;
    }
     
public static List<ParticipantJobPojo> getAllJobs()throws SQLException
      {
        Statement st=DbConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select jobid,jobtitle,companyname,tags,status from sys.JOBS j,sys.HR h where j.hrid=h.hrid"); 
        List<ParticipantJobPojo> allJobsList=new ArrayList<>();
         while(rs.next()){
             ParticipantJobPojo obj=new ParticipantJobPojo();
             obj.setJobId(rs.getString(1));
             obj.setJobTitle(rs.getString(2));
             obj.setCompanyName(rs.getString(3));
             obj.setTags(rs.getString(4));
             obj.setStatus(rs.getInt(5));
             allJobsList.add(obj);             
         }
         return allJobsList;
    }
}







