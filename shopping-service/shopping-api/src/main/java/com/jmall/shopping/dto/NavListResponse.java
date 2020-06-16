package com.jmall.shopping.dto;

import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

@Data
public class NavListResponse extends AbstractResponse {

    private List<PanelContentDto> pannelContentDtos;
}
