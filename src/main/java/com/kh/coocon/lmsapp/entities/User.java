package com.kh.coocon.lmsapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="LMS_USERS")
public class User {
	
	private int contract_Id ;
	private int organization_Id;
	private int position_Id;
	private int role;
	private int manager_Id;
	private String dateHired;
	private String identifirer;
	private String phone;
	private String emergency;
	private String login;
	private String country;
	private String calendar;
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
 
    
    @Column(name="SSO_ID", unique=true, nullable=false)
    private String ssoId;
     
    
    @Column(name="PASSWORD", nullable=false)
    private String password;
         
    @Column(name="FIRST_NAME", nullable=false)
    private String firstName;
 
   
    @Column(name="LAST_NAME", nullable=false)
    private String lastName;
 
   
    @Column(name="EMAIL", nullable=false)
    private String email;
 
   
    @Column(name="STATE", nullable=false)
    private String state=State.ACTIVE.getState();
 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "LMS_USER_ROLES", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getSsoId() {
        return ssoId;
    }
 
    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
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
 
    public String getState() {
        return state;
    }
 
    public int getContractId() {
		return contract_Id;
	}

	public void setContractId(int contract_Id) {
		this.contract_Id = contract_Id;
	}

	public int getOrganizationId() {
		return organization_Id;
	}

	public void setOrganizationId(int organization_Id) {
		this.organization_Id = organization_Id;
	}

	public int getPositionId() {
		return position_Id;
	}

	public void setPositionId(int position_Id) {
		this.position_Id = position_Id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getManagerId() {
		return manager_Id;
	}

	public void setManagerId(int manager_Id) {
		this.manager_Id = manager_Id;
	}

	public String getDateHired() {
		return dateHired;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	public String getIdentifirer() {
		return identifirer;
	}

	public void setIdentifirer(String identifirer) {
		this.identifirer = identifirer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public void setState(String state) {
        this.state = state;
    }
 
    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }
 
    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        if (ssoId == null) {
            if (other.ssoId != null)
                return false;
        } else if (!ssoId.equals(other.ssoId))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password
                + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + ", state=" + state + ", userProfiles=" + userProfiles +"]";
    }
 
     
}
