package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.student;

public class studentDao {
	private HibernateTemplate hTemp;
	
	//save
	@Transactional
	public int insert(student st) {
		
		//insert
		int i =(Integer)this.hTemp.save(st);
		return i;
	}
	
	//get the single data(object)
	public student setStudent(int studentId) {
		student st =this.hTemp.get(student.class,studentId);
		return st;
	}
	
	//get All student Data(all rows)
	public List<student> getAllStudent(){
		List<student> st =this.hTemp.loadAll(student.class);
		return st;
	}
	
	//deleting the data
	@Transactional
	public void deleteStudent(int studentId) {
		student st =this.hTemp.get(student.class,studentId);
		this.hTemp.delete(st);
	}
	
	//updating data
	@Transactional
	public void updateStudent(student st) {
		this.hTemp.update(st);
		}
	
	

	public HibernateTemplate gethTemp() {
		return hTemp;
	}

	public void sethTemp(HibernateTemplate hTemp) {
		this.hTemp = hTemp;
	}
	
	

}
