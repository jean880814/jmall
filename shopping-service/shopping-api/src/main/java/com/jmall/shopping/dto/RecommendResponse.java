package com.jmall.shopping.dto;
import com.jmall.commons.result.AbstractResponse;
import lombok.Data;

import java.util.Set;

@Data
public class RecommendResponse extends AbstractResponse {

    private Set<PanelDto> panelContentItemDtos;

}
