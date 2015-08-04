/**
 * 
 */
package edu.springweb.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Praveen
 *
 */

@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private Long id;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="DATE_DOB")
	private Date dateOfBirth;

	@Column(name="DATE_DOJ")
	private Date dateOfJoining;

	@Column(name="MOTHER_NAME")
	private String motherName;

	@Column(name="FATHER_NAME")
	private String fatherName;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="USER_TYPE")
	private String type;

	@Column(name="STATUS")
	private String status;

	@OneToMany(mappedBy="user")
	private Set<EvalStats> evalStats = new HashSet<EvalStats>(0);

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<EvalStats> getEvalStats() {
		return evalStats;
	}

	public void setEvalStats(Set<EvalStats> evalStats) {
		this.evalStats = evalStats;
	}
	
}
