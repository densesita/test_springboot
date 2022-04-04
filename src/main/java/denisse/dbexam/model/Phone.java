package denisse.dbexam.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "phones")
@Access(value = AccessType.PROPERTY)
public class Phone implements Serializable {

	private static final long serialVersionUID = 43756555L;

	private String id;
	private String number;
	private String cityCode;
	private String countryCode;
    private User user;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "NUMBER")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	@Column(name = "CITY_CODE")
	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	@Column(name = "COUNTRY_CODE")
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@JoinColumn(name = "user_id", nullable = true)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
