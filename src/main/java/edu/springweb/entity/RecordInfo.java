package edu.springweb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Encapsulates audit fields to be captured during create and update operations
 * on the Entity.
 * 
 * @author Praveen
 * 
 */
@Embeddable
public class RecordInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @Enumerated(EnumType.STRING)
	// @Column(name = "State", length = 50, nullable = false)
	// private Status status;

	@Column(name = "CreatedBy", length = 50)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate", length = 19)
	private Date createdDate;

	@Column(name = "ModifiedBy", length = 50)
	private String modifiedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ModifyDate", length = 19)
	private Date modifiedDate;

	public RecordInfo() {
		super();
	}

	public RecordInfo(String createdBy, Date createdDate) {
		super();
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	// public Status getStatus() {
	// return status;
	// }
	//
	// public void setStatus(Status status) {
	// this.status = status;
	// }

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}