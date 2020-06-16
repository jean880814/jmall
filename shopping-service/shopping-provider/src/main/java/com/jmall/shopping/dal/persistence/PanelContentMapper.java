package com.jmall.shopping.dal.persistence;

import com.jmall.commons.tool.tkmapper.TkMapper;
import com.jmall.shopping.dal.entitys.PanelContent;

import java.util.List;

import com.jmall.shopping.dal.entitys.PanelContentItem;
import org.apache.ibatis.annotations.Param;

public interface PanelContentMapper extends TkMapper<PanelContent> {

    List<PanelContentItem> selectPanelContentAndProductWithPanelId(@Param("panelId")Integer panelId);
}