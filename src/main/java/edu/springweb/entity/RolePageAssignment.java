package edu.springweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: RolePageAssignment
 * 
 */
//@Entity
@Table(name = "RoleMenuMap")
public class RolePageAssignment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Role_Id", nullable = false)
	private Role myRole;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MenuMaster_Id", nullable = false)
	private Page myPage;

	@Enumerated(EnumType.STRING)
	@Column(name = "State", length = 50, nullable = false)
	private Status status;

	@Embedded
	private RecordInfo recordInfo;

	public RolePageAssignment() {
		super();
	}

	public Role getRole() {
		return myRole;
	}

	public void setRole(Role role) {
		this.myRole = role;
	}

	public Page getPage() {
		return myPage;
	}

	public void setPage(Page page) {
		this.myPage = page;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
