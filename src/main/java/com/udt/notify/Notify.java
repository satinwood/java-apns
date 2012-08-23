/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udt.notify;

import com.udt.apple.apns.PushService;
import com.udt.db.DeviceBind;
import com.udt.db.HibernateUtil;
import com.udt.db.Push;
import com.udt.email.Email;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author RTL
 */
public class Notify {

    public static Session session;

    static {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Push> result = session.createSQLQuery("select * from push").addEntity(Push.class).list();
        for (Push o : result) {
            //sendMail(o);
            sendAppleNotify(o);
        }
        session.getTransaction().commit();
        //session.close();       
    }

    public static void sendMail(Push o) {
        // send mail;
        String to_addr = o.getEmail();
        String from_addr = "no-reply@ding1ding.com";
        String subject = "[降价通知]" + o.getName();
        String body = new String();
        String link = "www.ding1ding.com/product/index/pid/" + o.getProductId();
        body = "<p>尊敬的盯一盯客户：</p>"
                + "<p>您好！您所关注的商品【" + o.getName() + "】"
                + "的价格已经调整到预设的阈值，请择机购买。详细信息请查阅下列网络链接。</p>"
                + "<br>"
                + "<p>商城：" + o.getStoreName() + " 期望价格：" + o.getPriceThreshold() + "￥"
                + "<br>"
                + "" + "<a href=" + link + ">" + link + "</a>"
                + "<br>"
                + "<p>如果您不想被打扰，请忽略此信息。</p>"
                + "<p>谢谢！</p>"
                + "<br>"
                + "<br>"
                + "<p>" + "盯一盯网络客户服务部" + "<br>"
                + "" + "http://www.ding1ding.com" + "<br>"
                + "</p>";
        Email.sendMail(to_addr, from_addr, subject, body);
    }

    public static void sendAppleNotify(Push o) {
        String token;
        String payload = "[降价通知]" + o.getName();
        List<DeviceBind> result = session.createSQLQuery("select * from device_bind where account_id = " + o.getAccountId())
                .addEntity(DeviceBind.class).list();
        for (DeviceBind device : result) {
            token = device.getToken();
            PushService.push(token, 6, payload);
        }
        PushService.stop();
    }
}
