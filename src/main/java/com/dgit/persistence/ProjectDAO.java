package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.ProjectVO;

public interface ProjectDAO {
	public int insertProject(ProjectVO project) throws Exception;
	
	public List<ProjectVO> selectListProject() throws Exception;
	
	public ProjectVO selectProjectById(int number) throws Exception;
	
	public int deleteProjectById(int no) throws Exception;
	
	public int updateProject(ProjectVO project) throws Exception;
}
