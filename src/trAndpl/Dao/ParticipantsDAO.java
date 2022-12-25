/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trAndpl.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trAndpl.dbutil.DbConnection;
import trAndpl.pojo.ParticipantsPojo;

/**
 *
 * @author Dell
 */

public class ParticipantsDAO {
    private File file;
    
    public static int getNewParticipantId()throws SQLException{
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select max(pid) from  sys.PARTICIPANTS");
        int pId=101;
        rs.next();
        String strid=rs.getString(1);
        if(strid!=null){
        String id=strid.substring(3);
        pId=Integer.parseInt(id)+101;
        }
        return pId;
    }
    public static int addNewParticipant(ParticipantsPojo pt)throws SQLException,FileNotFoundException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select userid from sys.USERS where userid=?");
        ps.setString(1, pt.getUserId().toUpperCase().trim());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            return -1;
        }
        ps=conn.prepareStatement("Insert into sys.USERS values(?,?,?,?,?,?)");
        ps.setString(1, pt.getUserId());
        ps.setString(2, pt.getId());
        ps.setString(3, pt.getName());
        ps.setString(4, pt.getPassword());
        ps.setString(5, pt.getType());
        ps.setString(6, "Y");
        int x=ps.executeUpdate();
        int y=0;
        if(x==1){
            ps=conn.prepareStatement("Insert into sys.PARTICIPANTS values(?,?,?,?,?)");
            ps.setString(1, pt.getId());
            ps.setString(2, pt.getPhone());
            ps.setString(3, pt.getSkills());
            ps.setString(4, pt.getQualifications());
            File f=pt.getResume();
            InputStream fin=new FileInputStream(f.getPath());
            ps.setBlob(5, fin);
            y=ps.executeUpdate();
        }
        return y;
        
    }
    public static ParticipantsPojo getParticipantById(String id)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select name,userid,phone from sys.USERS,sys.PARTICIPANTS where pid=id and pid=?");    
        ps.setString(1,id);
        ResultSet rs=ps.executeQuery();
        rs.next();
        ParticipantsPojo pt=new ParticipantsPojo();
        pt.setName(rs.getString(1));
        pt.setUserId(rs.getString(2));
        pt.setPhone(rs.getString(3));
        return pt;
    }
    public static boolean updateResume(String pId,File Resume)throws SQLException,FileNotFoundException
    {
        PreparedStatement ps;
        ps=DbConnection.getConnection().prepareStatement("update sys.PARTICIPANTS set resume=? where pid=?");
        FileInputStream fobj = new FileInputStream(Resume);
        ps.setBlob(1,fobj);
        ps.setString(2,pId);
        return 1==ps.executeUpdate();   
    }
  public static List<ParticipantsPojo> getAllParticipants( )throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select id,userid,name,phone,skills,qualification from sys.USERS u,sys.PARTICIPANTS p where u.id=p.pid");  
        ResultSet rs=ps.executeQuery();
        List<ParticipantsPojo> allparticipants=new ArrayList<>();
         while(rs.next()){
             ParticipantsPojo obj=new ParticipantsPojo();
             obj.setId(rs.getString(1));
             obj.setUserId(rs.getString(2));
             obj.setName(rs.getString(3));
             obj.setPhone(rs.getString(4));
             obj.setSkills(rs.getString(5));
             obj.setQualifications(rs.getString(6));
             allparticipants.add(obj);             
         }
       return allparticipants;

}
   public static ParticipantsPojo ViewUserProfile(String pid)throws SQLException
    { 
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select userid,name,phone,skills,qualification,password from sys.USERS u,sys.PARTICIPANTS p where u.id=p.pid and pid=?");    
        ps.setString(1,pid);
        ResultSet rs=ps.executeQuery();
        rs.next();
        ParticipantsPojo pt=new ParticipantsPojo();
        pt.setUserId(rs.getString(1));
        pt.setName(rs.getString(2));
        pt.setPhone(rs.getString(3));
        pt.setSkills(rs.getString(4));
        pt.setQualifications(rs.getString(5));
        pt.setPassword(rs.getString(6));
        return pt;
   }
}

         