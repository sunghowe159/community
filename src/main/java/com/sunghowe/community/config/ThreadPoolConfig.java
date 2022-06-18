package com.sunghowe.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author SungHowe
 * @title ThreadPoolConfig
 * @description
 * @create 2022-06-18 15:45
 */
@Configuration
@EnableScheduling
@EnableAsync
public class ThreadPoolConfig {
}
