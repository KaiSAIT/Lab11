package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {
    
    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                

                String to = user.getEmail();
                String subject = "Notes App Login";
                String template = path + "/emailtemplates/login.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                
                GmailService.sendMail(to, subject, template, tags);

                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public User resetPassword(String email, String path, String url) throws Exception {
        UserDB userdb = new UserDB();
        
        User user = userDB.get(email);
        
        String receiver = user.getEmail(email);
        String subject = "NotesKeeper Password";
        String template = path + "/emailtemplates/resetpassword.html";
        String uuid = UUID.randomUUID().toString();
        user.setForgotPasswordUuid(uuid);
        userDB.update(user);
        String link = url + "?uuid" + uuid;
        
        HashMap<String, String> tags = new HashMap<>();
        tags.put("firstname", user.getFirstnName());
        tags.put("lastname", user.getLastName());
        tags.put("link", link);
        
        GmailService.sendMail(receiver, subject, template, tags);
        
        return user;
    }
    
    public boolean changePassword(String uuid, String password) {
        UserDB = new UserDB();
        
        try {
            User user - userDB.getByUUID(uuid);
            user.setPassword(password);
            user.setResetPasswordUuid(null);
            userDB.update(user);
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
