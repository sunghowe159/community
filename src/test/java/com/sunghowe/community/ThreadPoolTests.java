package com.sunghowe.community;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.ContextConfiguration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author SungHowe
 * @title ThreadPoolTests
 * @description
 * @create 2022-06-18 15:26
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class ThreadPoolTests {
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolTests.class);

    // JDK普通线程池
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    // JDK可执行定时任务的线程池
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    // spring普通线程池
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    // spring可执行定时任务的线程池
    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    private void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 1.JDK普通线程池
    @Test
    public void testExecutorService() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                logger.debug("Hello ExecutorService");
            }
        };
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
        sleep(10000);
    }

    // 2.JDK定时任务线程池
    @Test
    public void testScheduledExecutorService() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                logger.debug("Hello ScheduledExecutorService");
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(task, 10000, 1000, TimeUnit.MILLISECONDS);
        sleep(30000);
    }
}
