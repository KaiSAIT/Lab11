package dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import models.User;


public class UserDB {
    public User get(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }
    
    public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
        EntityTransaction trans = em.getTransaction(); 
        
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback(); 
        } finally {
            em.close();
        }
    }

    public User getByUUID(String uuid) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query query = em.createNamedQuery("User.findByResetPasswordUuid");
            query.setParameter("resetPasswordUuid", uuid); 
            User uuidResult = (User)query.getSingleResult();  
            return uuidResult;
        } finally {
            em.close();
        }
    }
}
