/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udt.apple.apns;
import com.udt.db.HibernateUtil;
import com.udt.db.Observer;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * @author RTL
 */
public class PushService {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Observer> result = session.createSQLQuery("select * from observer")
                .addEntity(Observer.class).list();
        for(Observer o : result) {
            System.out.println("id : " + o.getObserverId());
            System.out.println("\tname : " + o.getName());
            System.out.println("\tgroup_id : " + o.getProductId());
            System.out.println("\temail : " + o.getEmail());
        }
        session.getTransaction().commit();
        //session.close();       
        
    }
    
}
