package com.kh.coocon.lmsapp.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
@Table(name="LMS_USERS")
public class User {
	
	private int contract_Id ;
	private int organization_Id;
	private int manager_Id;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateHired;
	private String identifirer;
	private String phone;
	private String emergency;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="position_id")
	private Position position;

	
	private String country;
	private String calendar;
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
 
    
    @Column(name="SSO_ID", unique=true, nullable=false)
    private String ssoId;
     
    
    @Column(name="PASSWORD", nullable=false)
    private String password;
         
    @Column(name="FIRST_NAME" )
    private String firstName;
 
   
    @Column(name="LAST_NAME")
    private String lastName;
 
   
    @Column(name="EMAIL", nullable=false)
    private String email;
 
   
    @Column(name="STATE", nullable=false)
    private String state=State.ACTIVE.getState();
 
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "LMS_USER_ROLES", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
 
    
    public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getContract_Id() {
		return contract_Id;
	}

	public void setContract_Id(int contract_Id) {
		this.contract_Id = contract_Id;
	}

	public int getOrganization_Id() {
		return organization_Id;
	}

	public void setOrganization_Id(int organization_Id) {
		this.organization_Id = organization_Id;
	}

	

	public int getManager_Id() {
		return manager_Id;
	}

	public void setManager_Id(int manager_Id) {
		this.manager_Id = manager_Id;
	}
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

	

	

	public int getManagerId() {
		return manager_Id;
	}

	public void setManagerId(int manager_Id) {
		this.manager_Id = manager_Id;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
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
