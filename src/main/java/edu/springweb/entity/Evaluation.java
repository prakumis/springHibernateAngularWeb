package edu.springweb.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EVALUATION")
public class Evaluation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private Long id;

	@Column(name="NAME")
	private String name;

	@Column(name="DESCRIPTION")
	private String desc;

	@Column(name="TOTAL_QUESTIONS")
	private Integer totalQuestions;

	@Column(name="MAX_QUESTIONS")
	private Integer maxQuestions;

	@Column(name="PASSING_QUESTIONS")
	private Integer passingQuestions;

	@Column(name="DIVISION")
	private String divisionName;

	@Column(name="SECTION")
	private String sectionName;

	@Column(name="YEAR")
	private String year;

	@OneToMany(mappedBy="evaluation")
	private Set<Question> questions = new HashSet<Question>(0);

	@OneToMany(mappedBy="eval")
	private Set<EvalStats> evalStats = new HashSet<EvalStats>(0);

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public Integer getMaxQuestions() {
		return maxQuestions;
	}
	public void setMaxQuestions(Integer maxQuestions) {
		this.maxQuestions = maxQuestions;
	}
	public Integer getPassingQuestions() {
		return passingQuestions;
	}
	public void setPassingQuestions(Integer passingQuestions) {
		this.passingQuestions = passingQuestions;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}


}
