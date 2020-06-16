package com.jmall.user.converter;

import com.jmall.user.dal.entitys.Member;
import com.jmall.user.dto.UserLoginResponse;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-12T13:11:51+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class UserConverterMapperImpl implements UserConverterMapper {

    @Override
    public UserLoginResponse converter(Member member) {
        if ( member == null ) {
            return null;
        }

        UserLoginResponse userLoginResponse = new UserLoginResponse();

        userLoginResponse.setId( member.getId() );
        userLoginResponse.setUsername( member.getUsername() );
        userLoginResponse.setPhone( member.getPhone() );
        userLoginResponse.setEmail( member.getEmail() );
        userLoginResponse.setSex( member.getSex() );
        userLoginResponse.setAddress( member.getAddress() );
        userLoginResponse.setFile( member.getFile() );
        userLoginResponse.setDescription( member.getDescription() );
        userLoginResponse.setPoints( member.getPoints() );
        if ( member.getBalance() != null ) {
            userLoginResponse.setBalance( member.getBalance().longValue() );
        }
        if ( member.getState() != null ) {
            userLoginResponse.setState( member.getState() );
        }

        return userLoginResponse;
    }
}
