package com.demoBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="user_password")
public class UserPassword {

	    @Id
	    @Column(name ="user_name")
		private String username;
	    @Column(name = "password")
		private String password;
	    @Column(name = "role")
	    private String role;

		
		public String getUsername() {
			return username;
		}
		public String getPassword() {
			return password;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		

		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
}
