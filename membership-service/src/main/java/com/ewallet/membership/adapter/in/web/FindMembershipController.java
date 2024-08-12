package com.ewallet.membership.adapter.in.web;

import com.ewallet.common.WebAdapter;
import com.ewallet.membership.application.port.in.FindMembershipCommand;
import com.ewallet.membership.application.port.in.FindMembershipUseCase;
import com.ewallet.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

	private final FindMembershipUseCase findMembershipUseCase;

	@GetMapping(path = "/membership/{membershipId}")
	ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId){

		FindMembershipCommand command = FindMembershipCommand.builder()
			.membershipId(membershipId)
			.build();
		return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
	}
}
