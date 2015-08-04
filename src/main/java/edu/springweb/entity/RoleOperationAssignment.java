package edu.springweb.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: RoleOperationAssignment
 * 
 */
//@Entity
@Table(name = "RolePageFuncMap")
public class RoleOperationAssignment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Role_Id", nullable = false)
	private Role myRole;

	private Operation myOperation;

	
	@Embedded
	private RecordInfo recordInfo;

	public RoleOperationAssignment() {
		super();
	}

	public Role getRole() {
		return myRole;
	}

	public void setRole(Role role) {
		this.myRole = role;
	}


	public RecordInfo getRecordInfo() {
		return recordInfo;
	}

	public void setRecordInfo(RecordInfo recordInfo) {
		this.recordInfo = recordInfo;
	}

	public Operation getOperation() {
		return myOperation;
	}

	public void setOperation(Operation myOperation) {
		this.myOperation = myOperation;
	}
	
}
