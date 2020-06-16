package com.jmall.user.converter;

import com.jmall.user.dal.entitys.Address;
import com.jmall.user.dto.AddAddressRequest;
import com.jmall.user.dto.AddressDto;
import com.jmall.user.dto.UpdateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressConverter {

    @Mappings({})
    AddressDto address2List(Address addresses);

    /*@Mappings({})
    AddressDto address2Res(Address address);*/

    List<AddressDto> address2List(List<Address> addresses);

    @Mappings({})
    Address req2Address(AddAddressRequest request);

    @Mappings({})
    Address req2Address(UpdateAddressRequest request);
}
