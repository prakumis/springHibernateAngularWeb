package edu.springweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANSWER")
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private Long id;

	@Column(name="TEXT")
	private String text;

	@Column(name="CORRECT_OPTION")
	private Boolean correctOption;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="QUEST_ID")
	private Question question;

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
	public Boolean getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(Boolean correctOption) {
		this.correctOption = correctOption;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
}
