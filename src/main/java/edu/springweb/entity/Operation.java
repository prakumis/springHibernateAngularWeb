package edu.springweb.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Location
 * 
 */
//@Entity
@Table(name = "PageFunction")
public class Operation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", nullable = false)
	private Long id;

	@Column(name = "FunctionName", nullable = false, length = 50, unique = true)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "State", length = 50, nullable = false)
	private Status status;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "MenuMaster_Id")
	//private Page myPage;
	
	@OneToMany(mappedBy = "myOperation", fetch = FetchType.LAZY)
	private Collection<RoleOperationAssignment> myRoleAssignments;

	@Embedded
	private RecordInfo recordInfo;

	public Operation() {
		super();
	}

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Collection<RoleOperationAssignment> getRoleAssignments() {
		return myRoleAssignments;
	}

	public void setRoleAssignments(
			Collection<RoleOperationAssignment> roleAssignments) {
		this.myRoleAssignments = roleAssignments;
	}

	@Override
	public String toString() {
		return getName();
	}
}
