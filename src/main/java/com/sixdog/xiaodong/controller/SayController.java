package com.sixdog.xiaodong.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sixdog.xiaodong.dto.SayInfo;
import com.sixdog.xiaodong.util.CSVUtil;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class SayController {


	/** Logger实例 */
	static final Logger logger = LoggerFactory.getLogger(SayController.class);

	@RequestMapping(path = "/saveSay",method = RequestMethod.POST)
	public String saveSayWords(@RequestBody SayInfo say) {
		logger.info("--------------------------start");
	    logger.info(say.getTitle());
	    logger.info(say.getContent());
	    String uuid = UUID.randomUUID().toString();
	    try {
			CSVUtil.createCSV(new String[] {uuid,say.getTitle(),say.getContent()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	    logger.info("--------------------------end");
	    return "{\"ret\":\"success\"}";
	}
	
	@RequestMapping(path = "/test")
	public String test() {
		logger.info("--------------------------1");
		logger.debug("--------------------------2");
		logger.info("--------------------------1");
	    return "{'name','zhansgan','age','12'}";
	    
	}
}
