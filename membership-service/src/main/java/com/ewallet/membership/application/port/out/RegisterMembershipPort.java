package com.ewallet.membership.application.port.out;

import com.ewallet.membership.adapter.out.persistence.MembershipJpaEntity;
import com.ewallet.membership.domain.Membership;

public interface RegisterMembershipPort {
	MembershipJpaEntity createMembership(
		Membership.MembershipName membershipName,
		Membership.MembershipEmail membershipEmail,
		Membership.MembershipAddress membershipAddress,
		Membership.MembershipIsValid membershipIsValid,
		Membership.MembershipIsCorp membershipIsCorp
	);
}
