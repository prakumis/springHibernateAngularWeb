/**
 * 
 */
package edu.springweb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author Praveen
 *
 */
@Entity
@Table(name="EMP_DETAILS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5390874180338582277L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Size(min=3,max=8)
	private String firstName;

	@Size(min=3, message="Last Name must be min of 3 char long")
	private String lastName;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id: "+this.id+" name: "+this.firstName+" "+this.lastName;
	}
}
