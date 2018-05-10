package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "pass")
	private String pass;
	
	@Column(name = "premiumAccount")
	private Date premiumAccount;
	
	public User() {}
	
	public User(String name, String pass, Date premiumAccount) {
		this.name = name;
		this.pass = pass;
		this.premiumAccount = premiumAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getPremiumAccount() {
		return premiumAccount;
	}

	public void setPremiumAccount(Date premiumAccount) {
		this.premiumAccount = premiumAccount;
	}
}
