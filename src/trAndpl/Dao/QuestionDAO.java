package trAndpl.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trAndpl.dbutil.DbConnection;
import trAndpl.pojo.QuesPojo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class QuestionDAO {
    public static boolean setPaper(List<QuesPojo> questionList) throws SQLException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into sys.QUESTIONS values(?,?,?,?,?,?,?,?)");
        int count=0;
        for(QuesPojo question:questionList){
            ps.setString(1, question.getJobId());
            ps.setInt(2, question.getQno());
            ps.setString(3, question.getQuestion());
            ps.setString(4, question.getOption1());
            ps.setString(5, question.getOption2());
            ps.setString(6, question.getOption3());
            ps.setString(7, question.getOption4());
            ps.setInt(8, question.getCorrectOption());
            int res=ps.executeUpdate();
            if(res==1)
                count++;
        }
        if(count==questionList.size())
            return true;
        return false;
    }
    public static List<QuesPojo> getQuestionPaperByJobId(String jobId)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from sys.QUESTIONS where jobid=?");
        ps.setString(1, jobId);
        ResultSet rs=ps.executeQuery(); 
        List<QuesPojo> questionsList = new ArrayList<>();
        while(rs.next())
        {
            QuesPojo que=new QuesPojo();
            que.setJobId(rs.getString(1));
            que.setQno(rs.getInt(2));
            que.setQuestion(rs.getString(3));
            que.setOption1(rs.getString(4));
            que.setOption2(rs.getString(5));
            que.setOption3(rs.getString(6));
            que.setOption4(rs.getString(7));
            que.setCorrectOption(rs.getInt(8));
            questionsList.add(que);
        }   
        return questionsList;
    }
 


public static boolean editQuestionPaper(List<QuesPojo> questionsList)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update sys.QUESTIONS set question=?,option1=?,option2=?,option3=?,option4=?,correctoption=? where jobid=? and Qno=?");
        int count=0;
        for(QuesPojo que:questionsList)
        {
                        
            ps.setString(1,que.getQuestion());
            ps.setString(2,que.getOption1());
            ps.setString(3,que.getOption2());
            ps.setString(4,que.getOption3());
            ps.setString(5,que.getOption4());
            ps.setInt(6,que.getCorrectOption());
            ps.setString(7,que.getJobId());
            ps.setInt(8,que.getQno());
            int res=ps.executeUpdate();            
            if(res==1)
                ++count;
        }
        if(count==questionsList.size())
            return true;
        return false;    
    }

}
