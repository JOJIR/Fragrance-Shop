package com.powerperfume.model;

import org.springframework.stereotype.Component;


	@Entity
	@Table(name="CATEGORY")
	@Component
	public class Categorymodel {

		private String id;
		private String name;
		private String description;
		@Id
		@Column(name = "ID")
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
		
		

}
