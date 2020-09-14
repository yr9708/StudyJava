package com.mvc.complete.common.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAop {
	public void beforeLog(JoinPoint join) {
		Logger log = LoggerFactory.getLogger(join.getTarget()+"");
		log.info("--------AOP 시작---------");
		
		Object[] args = join.getArgs();
		if(args!=null) {
			log.info("method : "+join.getSignature().getName());
			for(int i=0; i<args.length; i++) {
				log.info(i + "번째 : "+args[i] );
			}
		}
	}
	
	public void afterLog(JoinPoint join) {
		Logger log = LoggerFactory.getLogger(join.getTarget()+"");
		log.info("--------------AOP 끝----------");
	}
	
	public void afterThrowingLog(JoinPoint join) {
		Logger log = LoggerFactory.getLogger(join.getTarget()+"");
		log.info("---------------ERROR-------------");
		log.info("ERROR : "+join.getArgs());
		log.info("ERROR : "+join.toString());
	}
}
