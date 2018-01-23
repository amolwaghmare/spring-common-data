package com.amol.spring.data.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the User database table.
 * 
 */
/**
 * @author Amol Waghmare
 *
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	/*
	 * @GeneratedValue(strategy=GenerationType.AUTO)
	 * Hibernate: select next_val as id_val from hibernate_sequence for update
	 * Hibernate: update hibernate_sequence set next_val= ? where next_val=?
	 */

	@Temporal(TemporalType.DATE)
	private Date birth;

	private String name;
	
	/*
	 * @OneToMany relationship will create a relationship table, i.e
	 * Hibernate: create table user_Address (User_id integer not null, addresses_id integer not null, primary key (User_id, addresses_id))
		Hibernate: alter table user_Address add constraint UK_qf72ctrydl756rkv17l854mm4 unique (addresses_id)
		Hibernate: alter table user_Address add constraint FKrj1a9aypl6d8lxs16q8edcx31 foreign key (addresses_id) references Address (id)
		Hibernate: alter table user_Address add constraint FK40w1r6w78en5tkotx5560fqd1 foreign key (User_id) references user (id)

	 */
	
	//https://docs.oracle.com/javaee/6/api/javax/persistence/OneToMany.html
	@OneToMany (targetEntity=Address.class,cascade=CascadeType.ALL)
	private Set addresses;
	
	
	public Set getAddresses() {
		return addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}
	


	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}