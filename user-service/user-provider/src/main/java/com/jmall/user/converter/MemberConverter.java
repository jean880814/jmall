package com.jmall.user.converter;

import com.jmall.user.dal.entitys.Member;
import com.jmall.user.dto.QueryMemberResponse;
import com.jmall.user.dto.UpdateMemberRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MemberConverter {

    @Mappings({})
    QueryMemberResponse member2Res(Member member);

    @Mappings({})
    Member updateReq2Member(UpdateMemberRequest request);
}
