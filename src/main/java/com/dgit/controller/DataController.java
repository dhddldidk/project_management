package com.dgit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dgit.domain.ProjectVO;
import com.dgit.service.ProjectService;


@RequestMapping("/board/*")
@RestController
public class DataController {
	private static final Logger logger = LoggerFactory.getLogger(DataController.class);
	
	@Autowired
	private ProjectService service;
	
	//프로젝트 추가
	/*@RequestMapping(value ="/addProject", method = RequestMethod.POST)
	public ResponseEntity<String> addProjectPost(@RequestBody ProjectVO vo) throws Exception {
		logger.info("addProject로 갑시당!!!!!!!!!!!!!!!!!!!!!!!!"+vo.toString());
		ResponseEntity<String> entity = null;
		
		try{
			service.insertProjectSV(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}*/

}
