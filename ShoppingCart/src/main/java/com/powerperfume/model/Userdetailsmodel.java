package com.powerperfume.model;

import org.springframework.stereotype.Component;


	@Entity
	@Table(name = "USER_DETAILS")
	@Component
	public class Userdetailsmodel {

		
		@Id
		@Column(name="id")
		@Column(name = "mail_id")
		private String mailID;
		
		private String address;
		
		@Column(name = "contact_number")
		private String contactNumber;

		public String getMailID() {
			return mailID;
		}

		public void setMailID(String mailID) {
			this.mailID = mailID;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
}