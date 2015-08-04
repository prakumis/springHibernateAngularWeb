package edu.springweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EVAL_STATS")
public class EvalStats {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="EVAL_ID")
	private Evaluation eval;

	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	@Column(name="MARKS_OBTAINED")
	private String marksObtained;

	@Column(name="STATUS")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Evaluation getEval() {
		return eval;
	}

	public void setEval(Evaluation eval) {
		this.eval = eval;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(String marksObtained) {
		this.marksObtained = marksObtained;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}