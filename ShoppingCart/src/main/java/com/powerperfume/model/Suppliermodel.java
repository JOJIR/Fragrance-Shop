package com.powerperfume.model;

import org.springframework.stereotype.Component;


	@Entity
	@Table(name = "SUPPLIER")
	@Component
	public class Suppliermodel {
	
		
		@Id
		@Column(name="id")
		private String id;

		private String name;
		
		private String address;

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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		

		
	}
}
