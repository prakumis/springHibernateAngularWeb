package edu.springweb.entity;


/**
 * 
 * @author Praveen
 * 
 */
public enum Status {

	ACTIVE, 
	INACTIVE;
	
	public String getMessage(){
		if(this.equals(ACTIVE)){
			return "activated";
		}
		return "deactivated";
	}

	
	public String getAction() {
		switch (this) {
		case ACTIVE:
			return "Deactivate";
		case INACTIVE:
			return "Activate";
		}
		return null;
	}
}
