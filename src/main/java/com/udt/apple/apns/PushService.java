/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udt.apple.apns;

import com.notnoop.apns.*;
import com.notnoop.apns.internal.QueuedApnsService;

/**
 *
 * @author RTL
 */
public class PushService {

    private static QueuedApnsService service;

    static {
        try {
            ApnsServiceBuilder servicebuilder = APNS.newService();
            ApnsService apns = servicebuilder.withAppleDestination(true).withCert(ClassLoader.getSystemResource("apns_prod_ding1ding_cer.p12").getPath(), "uptops").build();
            apns.testConnection();
            service = new QueuedApnsService(apns);
            //service = apns;
            service.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void push(String token, int badge, String body) {
        try {
            PayloadBuilder payload_builder = APNS.newPayload();
            payload_builder.badge(badge).alertBody(body);
            SimpleApnsNotification msg = new SimpleApnsNotification(token, payload_builder.build());
            service.push(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void stop() {
        service.stop();
    }
            
}
