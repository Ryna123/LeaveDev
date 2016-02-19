package com.kh.coocon.lmsapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="lms_organization")
public class Organization {
	@Column(name="organization_id")
	private int id;
	private String name;
	private int parent_id;
	private int supervisor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}
	
	
	
	

}
