package com.ewallet.membership.application.service;

import com.ewallet.membership.adapter.out.persistence.MembershipJpaEntity;
import com.ewallet.membership.adapter.out.persistence.MembershipMapper;
import com.ewallet.membership.application.port.in.RegisterMembershipCommand;
import com.ewallet.membership.application.port.in.RegisterMembershipUseCase;
import com.ewallet.membership.application.port.out.RegisterMembershipPort;
import com.ewallet.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

	private final RegisterMembershipPort registerMembershipPort;
	private final MembershipMapper membershipMapper;

	@Override
	public Membership registerMembership(RegisterMembershipCommand command) {
		MembershipJpaEntity jpaEntity =  registerMembershipPort.createMembership(
			new Membership.MembershipName(command.getName()),
			new Membership.MembershipEmail(command.getEmail()),
			new Membership.MembershipAddress(command.getAddress()),
			new Membership.MembershipIsValid(command.isValid()),
			new Membership.MembershipIsCorp(command.isCorp())
		);
		return membershipMapper.mapToDomainEntity(jpaEntity);
	}
}
