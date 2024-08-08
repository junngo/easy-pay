package com.ewallet.membership.application.port.in;

import com.ewallet.membership.domain.Membership;

public interface RegisterMembershipUseCase {
	Membership registerMembership(RegisterMembershipCommand command);
}
