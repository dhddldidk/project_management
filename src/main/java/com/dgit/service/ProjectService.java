package com.dgit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dgit.domain.ProjectVO;


public interface ProjectService {
public int insertProjectSV(ProjectVO project) throws Exception;
	
	public List<ProjectVO> selectListProjectSV() throws Exception;
	
	public ProjectVO selectProjectByIdSV(int number) throws Exception;
	
	public int deleteProjectByIdSV(int no) throws Exception;
	
	public int updateProjectSV(ProjectVO project) throws Exception;
}
