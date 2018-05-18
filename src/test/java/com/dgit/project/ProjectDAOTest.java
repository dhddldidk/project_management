package com.dgit.project;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.ProjectVO;
import com.dgit.persistence.ProjectDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ProjectDAOTest {

	@Autowired
	ProjectDAO dao;
	
	//@Test
	public void test1InsertProject() throws Exception {
		ProjectVO vo = new ProjectVO();
		Date now = new Date();
		
		vo.setProjectNo(10);
		vo.setProjectTitle("Spring으로 프로젝트 관리 시스템");
		vo.setProjectContent("열심히 해 봅니다.");
		vo.setStartdate(now);
		vo.setEnddate(now);
		vo.setProcess("준비");
		
		dao.insertProject(vo);
	}
	
	//@Test
	public void test2SelectListProject() throws Exception {
		List<ProjectVO> list = dao.selectListProject();
		for(ProjectVO vo : list){
			System.out.println("검색된 모든 list : "+list);
		}
	}
	
	//@Test
	public void test3SelectProjectById() throws Exception{
		ProjectVO vo = dao.selectProjectById(2);
		System.out.println("검색된 하나의 list : "+vo);
	}
	//@Test
	public void test4DeleteProjectById() throws Exception{
		dao.deleteProjectById(2);
	}
	@Test
	public void test5UpdateProject() throws Exception{
		ProjectVO vo = new ProjectVO();
		Date now = new Date();
		vo.setProjectNo(3);
		vo.setProjectTitle("프로젝트 수정입니다.");
		vo.setProjectContent("수정중인 내용들 입니다.");
		vo.setStartdate(now);
		vo.setEnddate(now);
		vo.setProcess("진행");
		dao.updateProject(vo);
	}
}
