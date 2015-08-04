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
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Location
 * 
 */
//@Entity
@Table(name = "MenuMaster", 
uniqueConstraints = @UniqueConstraint(columnNames = {"Name", "Application_Id" }))
public class Page implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", nullable = false)
	private Long id;
	
	@Column(name = "Name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "Category", nullable = false, length = 50)
	private String category;
	
	@Column(name = "URL", nullable = false)
    private String url;
	
	@OneToMany(mappedBy = "myPage", fetch = FetchType.LAZY)
	private Collection<RolePageAssignment> myRoleAssignments;

	@Enumerated(EnumType.STRING)
	@Column(name = "State", length = 50, nullable = false)
	private Status status;

	@Embedded
	private RecordInfo recordInfo;

	public Page() {
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
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Collection<RolePageAssignment> getRoleAssignments() {
		return myRoleAssignments;
	}

	public void setRoleAssignments(
			Collection<RolePageAssignment> roleAssignments) {
		this.myRoleAssignments = roleAssignments;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
