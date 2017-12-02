package com.brasajava.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
public class CapoeiraMember implements Serializable{

	private static final long serialVersionUID = -234515550310965228L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String capoeiraName;
	private String graduation;
	@Column(name="actual_group")
	private String group;
	@ElementCollection
	@CollectionTable(name="capoeira_groups")
	@Column(name="been_groups")
	private List<String> groups;
	private LocalDate startDate;
	private String image;
	private String description;
	@OneToMany(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinTable(name="capoeira_teachers_students",
	joinColumns = @JoinColumn(name="teachers", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="students", referencedColumnName="id"))
	@JsonIgnore
	private List<CapoeiraMember> teachers;
	@OneToMany(mappedBy="teachers", fetch=FetchType.EAGER)
	private List<CapoeiraMember> students;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCapoeiraName() {
		return capoeiraName;
	}
	public void setCapoeiraName(String capoeiraName) {
		this.capoeiraName = capoeiraName;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<String> getGroups() {
		return groups;
	}
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CapoeiraMember> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<CapoeiraMember> teachers) {
		this.teachers = teachers;
	}
	public List<CapoeiraMember> getStudents() {
		return students;
	}
	public void setStudents(List<CapoeiraMember> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "CapoeiraMember {id=" + id + ", capoeiraName=" + capoeiraName + ", graduation=" + graduation + ", group="
				+ group + ", groups=" + groups + ", startDate=" + startDate + ", image=" + image + ", description="
				+ description + ", teachers=" + teachers.size() + ", students=" + students.size() + "}";
	}
	

}
