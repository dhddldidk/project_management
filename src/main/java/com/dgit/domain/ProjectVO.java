package com.dgit.domain;

import java.util.Date;

public class ProjectVO {
	private int projectNo;
	private String projectTitle;
	private String projectContent;
	private Date startdate;
	private Date enddate;
	private String process;

	public ProjectVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectVO(int projectNo, String projectTitle, String projectContent, Date startdate, Date enddate,
			String process) {
		super();
		this.projectNo = projectNo;
		this.projectTitle = projectTitle;
		this.projectContent = projectContent;
		this.startdate = startdate;
		this.enddate = enddate;
		this.process = process;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	@Override
	public String toString() {
		return "ProjectVO [projectNo=" + projectNo + ", projectTitle=" + projectTitle + ", projectContent="
				+ projectContent + ", startdate=" + startdate + ", enddate=" + enddate + ", process=" + process + "]";
	}

}
