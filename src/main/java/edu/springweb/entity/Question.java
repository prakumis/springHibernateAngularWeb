package edu.springweb.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUESTION")
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private Long id;

	@Column(name="TEXT")
	private String text;

	@Column(name="QUEST_TYPE")
	private String type;

	@Column(name="GROUP_NAME")
	private String groupName;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVAL_ID")		// primaryKey of owner table
	private Evaluation evaluation;

	@OneToMany(mappedBy="question")
	private Set<Answer> answers = new HashSet<Answer>(0);

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
}
