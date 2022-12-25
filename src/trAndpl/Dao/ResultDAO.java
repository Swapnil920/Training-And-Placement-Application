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
import trAndpl.pojo.ParticipantJobPojo;
import trAndpl.pojo.ParticipantResultPojo;
import trAndpl.pojo.ParticipantsPojo;
import trAndpl.pojo.ResultPojo;

/**
 *
 * @author Dell
 */
public class ResultDAO {
    public static boolean applyForJob(ResultPojo result)throws SQLException
    {
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("Select * from sys.RESULT where participantid=? and jobsid=?");
         ps.setString(1,result.getpId());
         ps.setString(2,result.getJobId());
         ResultSet rs=ps.executeQuery();
         if(rs.next()){
             return false;
         }
         ps=conn.prepareStatement("insert into sys.RESULT values(?,?,?,?)");
         ps.setString(1, result.getpId());
         ps.setString(2, result.getJobId());
         ps.setDouble(3, result.getPercentage());
         ps.setString(4, result.getSelectedByHr());
         return 1==ps.executeUpdate();
    }
 public static List<ParticipantJobPojo> getAllAppliedJobs(String particpantId)throws SQLException
    {
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("Select jobid,jobtitle,companyname,tags from sys.JOBS j,sys.RESULT r,sys.HR h where j.jobid=r.jobsid and j.hrid=h.hrid and participantid=? and percentage=-1");
         ps.setString(1, particpantId);
         List<ParticipantJobPojo> allAppliedJobsList=new ArrayList<>();
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
             ParticipantJobPojo pj=new ParticipantJobPojo();
             pj.setJobId(rs.getString(1));
             pj.setJobTitle(rs.getString(2));
             pj.setCompanyName(rs.getString(3));
             pj.setTags(rs.getString(4));
             allAppliedJobsList.add(pj);            
         }
         return allAppliedJobsList;
         
    }

 public static boolean setResult(ResultPojo rs)throws SQLException
    {
        PreparedStatement ps;
        ps=DbConnection.getConnection().prepareStatement("update sys.RESULT set percentage=? where participantid=? and jobsid=?");
        ps.setDouble(1,rs.getPercentage());
        ps.setString(2,rs.getpId());
        ps.setString(3,rs.getJobId());
        return 1==ps.executeUpdate();
    }
 public static List<ParticipantResultPojo> getAllCompletedJobs(String participantId)throws SQLException {
        
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select jobid,jobtitle,companyname,tags,percentage from sys.JOBS j,sys.HR h,sys.RESULT r where r.jobsid=j.jobid and j.hrid=h.hrid and participantId=? and percentage!=-1 order by jobid ");
        ps.setString(1, participantId);
        ResultSet rs=ps.executeQuery(); 
        List<ParticipantResultPojo> allResultList=new ArrayList<>();
        
         while(rs.next()){
             ParticipantResultPojo obj=new ParticipantResultPojo();
             obj.setJobId(rs.getString(1));
             obj.setJobTitle(rs.getString(2));
             obj.setCompanyName(rs.getString(3));
             obj.setTags(rs.getString(4));
             obj.setPercentage(rs.getDouble(5));
             allResultList.add(obj);             
         }
         return allResultList;
    }
 public static List<ParticipantsPojo> ViewAllPtResult( )throws SQLException {
        
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select participantid,jobsid,jobtitle,name,percentage from sys.RESULT r,sys.JOBS j,sys.USERS u where r.percentage!=-1 and r.jobsid=j.jobid and r.participantid=u.id" );
        ResultSet rs=ps.executeQuery(); 
        List<ParticipantsPojo> allResultList=new ArrayList<>();
        
         while(rs.next()){
             ParticipantsPojo obj=new ParticipantsPojo();
             obj.setId(rs.getString(1));
             obj.setJobId(rs.getString(2));
             obj.setJobTitle(rs.getString(3));
             obj.setName(rs.getString(4));
             obj.setPercentage(rs.getDouble(5));
             allResultList.add(obj);             
         }
         return allResultList;


    
 }
 public static boolean setSelectedByHr(String pId,String jobId)throws SQLException
    {
        PreparedStatement ps;
        ps=DbConnection.getConnection().prepareStatement("update sys.RESULT set selectedbyhr='Yes' where participantid=? and jobsid=?");
        ps.setString(1,pId);
        ps.setString(2,jobId);
        return 1==ps.executeUpdate();
}
 public static List<ParticipantsPojo> ViewAllSelectedPt( )throws SQLException {
        
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select participantid,userid,jobsid,jobtitle,name,skills,percentage from sys.RESULT r,sys.JOBS j,sys.PARTICIPANTS p,sys.USERS u where Selectedbyhr='Yes' and r.participantid=p.pid and r.jobsid=j.jobid and r.participantid=u.id" );
        ResultSet rs=ps.executeQuery(); 
        List<ParticipantsPojo> allResultList=new ArrayList<>();
        
         while(rs.next()){
             ParticipantsPojo obj=new ParticipantsPojo();
             obj.setId(rs.getString(1));
             obj.setUserId(rs.getString(2));
             obj.setJobId(rs.getString(3));
             obj.setJobTitle(rs.getString(4));
             obj.setName(rs.getString(5));
             obj.setSkills(rs.getString(6));
             obj.setPercentage(rs.getDouble(7));
             allResultList.add(obj);             
         }
         return allResultList;
 }
 
 public static ParticipantsPojo FetchData(String pId)throws SQLException {
       
      Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select userid,name,jobsid,jobtitle from sys.USERS u,sys.JOBS j,sys.RESULT r where r.participantid=u.id and r.jobsid=j.jobid and id=?");    
        ps.setString(1,pId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        ParticipantsPojo pt=new ParticipantsPojo();
        pt.setUserId(rs.getString(1));
        pt.setName(rs.getString(2));
        pt.setJobId(rs.getString(3));
        pt.setJobTitle(rs.getString(4));
        return pt;
  }
}


