package com.ewallet.membership.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "membership")
public class MembershipJpaEntity {

	@Id
	@GeneratedValue
	private Long membershipId;

	private String name;

	private String address;

	private String email;

	private boolean isValid;

	private boolean isCorp;

	public MembershipJpaEntity(String name, String address, String email, boolean validValue, boolean corpValue) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.isValid = validValue;
		this.isCorp = corpValue;
	}
}
