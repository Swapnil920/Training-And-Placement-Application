/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trAndpl.Dao;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;





class MyAuthenticator extends Authenticator{
    private String username,password;
    public MyAuthenticator(String username,String password){
        this.username=username;
        this.password=password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        PasswordAuthentication pwdAuth=new PasswordAuthentication(this.username,this.password);        
        return pwdAuth;
    }
    
}
public class SendMails {
    public static Message Sends(){
                        
        final String username = "sharmaswapnil4492@gmail.com";
        final String password = "ymmtdnoydgowpodw";
        // Step 1
        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        MyAuthenticator myAuth=new MyAuthenticator(username,password);        
        Session session = Session.getInstance(prop,myAuth);                
        Message message = new MimeMessage(session);
       
        
      return message; 
    }
    
    
}

