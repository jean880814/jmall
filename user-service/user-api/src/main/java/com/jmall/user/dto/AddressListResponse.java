package com.jmall.user.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

@Data
public class AddressListResponse extends AbstractResponse {

    private List<AddressDto> addressDtos;
}
