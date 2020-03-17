package com.sixdog.xiaodong.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sixdog.xiaodong.util.CSVUtil;


@RestController
public class HomeController {

	/** Logger实例 */
	static final Logger logger = LoggerFactory.getLogger(SayController.class);

	@RequestMapping(path = "/getSay",method = RequestMethod.GET)
	@ResponseBody
	public List<String[]> getSayWords() {
		List<String[]> list = new ArrayList<String[]>();
		try {
			list = CSVUtil.readCSV();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}
