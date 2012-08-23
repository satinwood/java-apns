package com.notnoop.apns;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import com.notnoop.exceptions.NetworkIOException;

/**
 * Silly Tests
 */
public class APNSTest {

    @Test
    public void testInstances() {
        assertThat(APNS.newPayload(), is(PayloadBuilder.class));
        assertThat(APNS.newService(), is(ApnsServiceBuilder.class));
    }

    @Test
    public void payloadShouldGetNewInstances() {
        assertNotSame(APNS.newPayload(), APNS.newPayload());
    }

    @Test
    public void newServiceGetNewInstances() {
        assertNotSame(APNS.newService(), APNS.newService());
    }

//    @Test
//    public void testUdtService() {
//        try {
//            ApnsServiceBuilder servicebuilder = new ApnsServiceBuilder();
//            ApnsService service = servicebuilder.withAppleDestination(true).withCert(ClassLoader.getSystemResource("apns_prod_ding1ding_cer.p12").getPath(), "uptops").build();
//            service.testConnection();
//            PayloadBuilder payload_builder = new PayloadBuilder();
//            payload_builder.badge(1).alertBody("This comes from Leon123");
//            String token = "1fab51a25e0d5ff1fa2033b64086d2fb76336c37cea239cf9b1ed2af3c9ab201";
//            SimpleApnsNotification msg = new SimpleApnsNotification(token, payload_builder.build());
//            service.push(msg);
//            System.out.println(msg.toString() + payload_builder.toString());
//        } catch (NetworkIOException e) {
//            e.printStackTrace();
//        }
//    }
}
