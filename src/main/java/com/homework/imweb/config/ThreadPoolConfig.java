package com.homework.imweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

@Configuration
public class ThreadPoolConfig {

  @Bean
  ForkJoinPool couponIssueWorkerPool() {
    int dbConnPoolSize = 5;
    int issueWorkerThreadPoolSize = Math.max((dbConnPoolSize - 3), 1);
    return new ForkJoinPool(issueWorkerThreadPoolSize);
  }

  @Bean
  Executor issuedThreadPool() {
    // 발행 태스크는 큐잉하여 하나씩 처리(DB 과부하방지)
    return Executors.newFixedThreadPool(1);
  }




}