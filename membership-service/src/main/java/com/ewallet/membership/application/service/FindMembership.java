package com.ewallet.membership.application.service;

import com.ewallet.membership.application.port.in.FindMembershipCommand;
import com.ewallet.membership.application.port.in.FindMembershipUseCase;
import com.ewallet.membership.application.port.out.FindMembershipPort;
import com.ewallet.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembership implements FindMembershipUseCase {

	private final FindMembershipPort findMembershipPort;

	@Override
	public Membership findMembership(FindMembershipCommand command) {
		return findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
	}
}
