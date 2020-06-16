package com.jmall.shopping.dal.persistence;

import com.jmall.commons.tool.tkmapper.TkMapper;
import com.jmall.shopping.dal.entitys.Panel;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PanelMapper extends TkMapper<Panel> {

    List<Panel> selectPanelContentById(@Param("panelId")Integer panelId);
}