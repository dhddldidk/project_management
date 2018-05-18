package com.dgit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dgit.domain.ProjectVO;
import com.dgit.service.ProjectService;

@RequestMapping("/board/")
@Controller
public class ProjectController {

	@Autowired
	ProjectService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@RequestMapping(value ="/listProject", method = RequestMethod.GET)
	public void selectListProjectSV(Model model) throws Exception {
		logger.info("list page");
		List<ProjectVO> list = service.selectListProjectSV();
		model.addAttribute("list",list);
	
	}
	
	@RequestMapping(value ="/addProject", method = RequestMethod.GET)
	public void addProject() throws Exception {
		logger.info("addProjectGET");
	
	}
	
	
	/*여기서 주의할 점!! addProject에서 추가하기 버튼을 누르면
	모두 String 형식으로 넘어옴
	ProjectVO 변수가 기본형일 경우에만(String, int, boolean등!!! Date 같은 객체는 안됨) 
	ProjectVO로 그 내용을 자동으로 받을 수 있는데
	시작일과 끝나는 날은 Date 객체로 되어 있어서 
	ProjectVO 변수 이름과 form 안의 name이 같은 경우에는 
	타입이 달라서 에러가 남
	
	이때 둘 중 이름을 바꿔주고, 
	날짜는 SimpleDateFormat을 써서 String을 Date 객체로 바꿔서 넣어주면 됨 */
	@RequestMapping(value ="/addProject", method = RequestMethod.POST)
	public String addProjectPost(ProjectVO vo, String startdateForm, String enddateForm) throws Exception {
		logger.info("addProject Post"+vo.toString());
		/*ResponseEntity<String> entity = null;*/
		logger.info(vo.toString());
		logger.info(startdateForm);
		logger.info(enddateForm);
		
		//String을 Date형식으로 바꿔줌
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date startD = fm.parse(startdateForm);
		Date endD = fm.parse(enddateForm);
		vo.setStartdate(startD);
		vo.setEnddate(endD);
		
		service.insertProjectSV(vo);
		
		return "redirect:/board/listProject";
	}
	
	@RequestMapping(value ="/readProject", method = RequestMethod.GET)
	public void readProject(int projectNo, Model model) throws Exception {
		logger.info("readProject");
		
		ProjectVO sProject = service.selectProjectByIdSV(projectNo);
		
		logger.info("선택된 프로젝트 selectedProject"+sProject);
		model.addAttribute("sProject",sProject);
	
	}
	
	
	@RequestMapping(value ="/deleteProject", method = RequestMethod.GET)
	public String deleteProject(int projectNo) throws Exception {
		logger.info("deleteProject");
		service.deleteProjectByIdSV(projectNo);
		return "redirect:/board/listProject";
	}
	
	
	@RequestMapping(value ="/updateProject", method = RequestMethod.GET)
	public void updateProject(int projectNo, Model model) throws Exception {
		logger.info("updateProjectGET");
		ProjectVO dbProject = service.selectProjectByIdSV(projectNo);
		
		logger.info("dbProject에서 가져온 "+dbProject);
		model.addAttribute("dbProject",dbProject);
	}
	
	@RequestMapping(value ="/updateProject", method = RequestMethod.POST)
	public String updateProjectPOST(ProjectVO vo, String uStartdate, String uEnddate, Model model) throws Exception {
		logger.info("uStartdate"+uStartdate);
		logger.info("updateProjectPOST");
		logger.info("호이호이 뭐임 : "+vo.toString());
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date startD = fm.parse(uStartdate);
		Date endD = fm.parse(uEnddate);
		vo.setStartdate(startD);
		vo.setEnddate(endD);
		logger.info("이거 뭐임 : "+vo.toString());
		service.updateProjectSV(vo); 
		
		model.addAttribute("sProject",vo);
		return "redirect:/board/readProject?projectNo="+vo.getProjectNo();
	}
}
