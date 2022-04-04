package denisse.dbexam.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import denisse.dbexam.util.StatusEnum;

@Entity
@Table(name = "users")
@Access(value = AccessType.PROPERTY)
public class User implements Serializable {

	private static final long serialVersionUID = 15159965367L;

	private String id;
	private String name;          
	private String email;
	private String password;
    private StatusEnum status;
	private Date created;
	private Date modified;
	private Date lastLogin;
	private String token;
	private Boolean isActive;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "STATUS")
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "CREATED")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	@Column(name = "MODIFIED")
	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	@Column(name = "LAST_LOGIN")
	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	@Column(name = "TOKEN")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	@Column(name = "ACTIVE")
	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}





}
