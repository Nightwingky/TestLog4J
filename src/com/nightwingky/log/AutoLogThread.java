package com.nightwingky.log;

import com.nightwingky.servlet.Log4JTestServlet;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AutoLogThread extends Thread{

    //通过正则式来设置输出的时间格式
    private SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    private Logger logger = Logger.getLogger(Log4JTestServlet.class);

    private Random random = new Random();

    //重写run()方法
    public void run() {
        while (true) {
            String str = s.format(new Date());
            chooseLog(random.nextInt(3) + 1, str);
            try {
                //间隔时间1秒
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void chooseLog(int num, String s) {
        switch (num) {
            case 1:
                logger.debug(s);
                break;
            case 2:
                logger.info(s);
                break;
            case 3:
                logger.error(s);
                break;
            default:
                break;
        }
    }
}
