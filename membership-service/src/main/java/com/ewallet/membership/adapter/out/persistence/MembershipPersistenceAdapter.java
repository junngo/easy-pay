package com.ewallet.membership.adapter.out.persistence;

import com.ewallet.common.PersistenceAdapter;
import com.ewallet.membership.application.port.out.FindMembershipPort;
import com.ewallet.membership.application.port.out.RegisterMembershipPort;
import com.ewallet.membership.domain.Membership;
import com.ewallet.membership.domain.Membership.MembershipAddress;
import com.ewallet.membership.domain.Membership.MembershipEmail;
import com.ewallet.membership.domain.Membership.MembershipId;
import com.ewallet.membership.domain.Membership.MembershipIsCorp;
import com.ewallet.membership.domain.Membership.MembershipIsValid;
import com.ewallet.membership.domain.Membership.MembershipName;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

	private final SpringDataMembershipRepository membershipRepository;
	private final MembershipMapper membershipMapper;

	@Override
	public MembershipJpaEntity createMembership(MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress,
		MembershipIsValid membershipIsValid, MembershipIsCorp membershipIsCorp) {
		return membershipRepository.save(
			new MembershipJpaEntity(
				membershipName.getNameValue(),
				membershipEmail.getEmailValue(),
				membershipAddress.getAddressValue(),
				membershipIsValid.isValidValue(),
				membershipIsCorp.isCorpValue()
			)
		);
	}

	@Override
	public Membership findMembership(MembershipId membershipId) {
		return membershipMapper.mapToDomainEntity(
			membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()))
		);
	}
}
