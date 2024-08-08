package com.ewallet.membership.application.port.out;

import com.ewallet.membership.domain.Membership;

public interface FindMembershipPort {
	Membership findMembership(
		Membership.MembershipId membershipId
	);
}
