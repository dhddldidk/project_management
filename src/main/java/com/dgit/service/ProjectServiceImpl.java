package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.ProjectVO;
import com.dgit.persistence.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDAO dao;
	
	@Override
	public int insertProjectSV(ProjectVO project) throws Exception {
		
		return dao.insertProject(project);
	}

	@Override
	public List<ProjectVO> selectListProjectSV() throws Exception {
		
		return dao.selectListProject();
	}

	@Override
	public ProjectVO selectProjectByIdSV(int number) throws Exception {
		
		return dao.selectProjectById(number);
	}

	@Override
	public int deleteProjectByIdSV(int no) throws Exception {
		
		return dao.deleteProjectById(no);
	}

	@Override
	public int updateProjectSV(ProjectVO project) throws Exception {
		
		return dao.updateProject(project);
	}

}
