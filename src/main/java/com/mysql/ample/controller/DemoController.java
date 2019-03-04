package com.mysql.ample.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.ample.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	DemoService demoService;
	
	/**
	 * 
	 * testOne：31000毫秒左右  
	 * 
	 * testTwo：79000毫秒左右（非索引） 加上索引和testOne时间差不多  
	 * 
	 * testThree：160毫秒左右
	 * 
	 * testFour: 750毫秒左右 
	 * 
	 * 以上时间多运行几次会所有时间更少
	 * 
	 */
	
	/**
	 * 访问的url地址
	 * http://localhost:8888/demo/{xxxxxxx}
	 */
	
	/**
	 * 行级锁大并发
	 */
	@RequestMapping(value = "/testOne", method = RequestMethod.GET)
	public void testOne(){
		ExecutorService pool = Executors.newCachedThreadPool();
		AtomicInteger num = new AtomicInteger(1);
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++){
			pool.execute(new Runnable() {
				public void run() {
					demoService.updateForId(num.getAndIncrement());
				}
			});
		}
		//关闭线程池
		pool.shutdown();
		// 阻塞线程池判断线程池里的线程是否执行完毕
		while (!pool.isTerminated()) {} 
		// 统计时间
		logger.info("testOne消耗时间为:{}",System.currentTimeMillis() - start);
	}
	
	/**
	 * 表级锁大并发
	 */
	@RequestMapping(value = "/testTwo", method = RequestMethod.GET)
	public void testTwo(){
		ExecutorService pool = Executors.newCachedThreadPool();
		AtomicInteger num = new AtomicInteger(1);
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++){
			pool.execute(new Runnable() {
				public void run() {
					demoService.updateForIdOther(num.getAndIncrement());
				}
			});
		}
		//关闭线程池
		pool.shutdown();
		// 阻塞线程池判断线程池里的线程是否执行完毕
		while (!pool.isTerminated()) {} 
		// 统计时间
		logger.info("testTwo消耗时间为:{}",System.currentTimeMillis() - start);
	}
	
	/**
	 * 行级锁小并发
	 */
	@RequestMapping(value = "/testThree", method = RequestMethod.GET)
	public void testThree(){
		ExecutorService pool = Executors.newCachedThreadPool();
		AtomicInteger num = new AtomicInteger(1);
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++){
			pool.execute(new Runnable() {
				public void run() {
					demoService.updateForId(num.getAndIncrement());
				}
			});
		}
		//关闭线程池
		pool.shutdown();
		// 阻塞线程池判断线程池里的线程是否执行完毕
		while (!pool.isTerminated()) {} 
		// 统计时间
		logger.info("testThree消耗时间为:{}",System.currentTimeMillis() - start);
	}
	
	/**
	 * 表级锁小并发
	 */
	@RequestMapping(value = "/testFour", method = RequestMethod.GET)
	public void testFour(){
		ExecutorService pool = Executors.newCachedThreadPool();
		AtomicInteger num = new AtomicInteger(1);
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100; i++){
			pool.execute(new Runnable() {
				public void run() {
					demoService.updateForIdOther(num.getAndIncrement());
				}
			});
		}
		//关闭线程池
		pool.shutdown();
		// 阻塞线程池判断线程池里的线程是否执行完毕
		while (!pool.isTerminated()) {} 
		// 统计时间
		logger.info("testFour消耗时间为:{}",System.currentTimeMillis() - start);
	}
	
	/**
	 * 线程池统计总耗时
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 百度查：线程池执行完毕、线程池阻塞返回结果
		// 实际研发中更应该使用Future或FutureTask做该需求
		
		ExecutorService pool = Executors.newCachedThreadPool();
		long start = System.currentTimeMillis();  
		for (int i = 0; i < 10; i++) {  
			/*pool.submit(() -> {  
		        try {  
		            Thread.sleep(5000);  
		        } catch (InterruptedException e) {  
		            e.printStackTrace();  
		        }  
		        System.out.println(Thread.currentThread().getName() + " done.");  
		    });*/  
			pool.execute(new Runnable() {
				public void run() {
					try {  
			            Thread.sleep(100);  
			        } catch (InterruptedException e) {  
			            e.printStackTrace();  
			        }  
			        // System.out.println(Thread.currentThread().getName() + " done.");
				}
			});
		}  
		pool.shutdown();
		while (!pool.isTerminated()) {}  
		System.out.println("线程池阻塞时间: " + (System.currentTimeMillis() - start) + "ms"); 
		
		long start02 = System.currentTimeMillis();
		for(int i = 0; i < 10; i++){
			Thread t1 = new Thread(new Runnable() {
				
				public void run() {
					try {  
			            Thread.sleep(100);  
			        } catch (InterruptedException e) {  
			            e.printStackTrace();  
			        }
					// System.out.println(Thread.currentThread().getName() + " done.");
				}
			});
			t1.start();
			try {
				t1.join();
			} catch (Exception e) {}
		}
		System.out.println("join阻塞时间: " + (System.currentTimeMillis() - start02) + "ms"); 
	}
	
}
