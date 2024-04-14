package com.solidCore;

import com.solidCore.utils.GuavaCacheUtils;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AquaRepairApplicationTest extends TestCase{

    @Test
    public void PasswordEncode() {
        String password = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        log.info(encode);
    }

    @Autowired
    GuavaCacheUtils guavaCacheUtils;

    @Test
    public void TestGuavaCache() {
        String lulu = "lulu love tongsheng";
        String tongsheng = "tongsheng love lulu";
        String laopo = "laopo love me";
        guavaCacheUtils.put("lulu", lulu);
        log.info("insert lulu success");

        guavaCacheUtils.put("tongsheng", tongsheng);
        log.info("insert tongsheng success");

        guavaCacheUtils.put("laopo", laopo);
        log.info("insert laopo success");

        String cache1 = (String)guavaCacheUtils.get("lulu");
        log.info("get cache value is: {}", cache1);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String cache11 = (String)guavaCacheUtils.get("lulu");
        log.info("get cache value is: {}", cache11);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String cache111 = (String)guavaCacheUtils.get("lulu");
        log.info("get cache value is: {}", cache111);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String cache1111 = (String)guavaCacheUtils.get("lulu");
        log.info("get cache value is: {}", cache1111);
    }

    @Test
    public void TestTimeStamp() {
        long l = System.currentTimeMillis();
        log.info("timestamp is {}", l);
    }
}
