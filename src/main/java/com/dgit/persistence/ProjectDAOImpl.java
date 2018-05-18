package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	SqlSession session;
	
	private static final String namespace = "com.dgit.mapper.ProjectMapper";
	
	@Override
	public int insertProject(ProjectVO project) throws Exception {
		
		return session.insert(namespace+".insertProject", project);
	}

	@Override
	public List<ProjectVO> selectListProject() throws Exception {
		
		return session.selectList(namespace+".selectListProject");
	}

	@Override
	public ProjectVO selectProjectById(int number) throws Exception {
		
		return session.selectOne(namespace+".selectProjectById", number);
	}

	@Override
	public int deleteProjectById(int no) throws Exception {
		
		return session.delete(namespace+".deleteProjectById", no);
	}

	@Override
	public int updateProject(ProjectVO project) throws Exception {
		
		return session.update(namespace+".updateProject", project);
	}

}
