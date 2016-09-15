package com.powerperfume.model;

import org.springframework.stereotype.Component;


	@Entity
	@Table(name = "user")
	@Component
	public class Usermodel {
	

		@Id
		@Column(name="id")
		private String id;
		private String password;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}

}
