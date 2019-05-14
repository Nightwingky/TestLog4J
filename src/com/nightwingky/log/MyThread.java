package com.nightwingky.log;

import com.nightwingky.servlet.Log4JTestServlet;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread{

    //通过正则式来设置输出的时间格式
    private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    private Logger logger = Logger.getLogger(Log4JTestServlet.class);

    //重写run()方法
    public void run() {
        while (true) {
            String str = s.format(new Date());
//            System.out.println(str);
            logger.info(str);
            try {
                //间隔时间1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
