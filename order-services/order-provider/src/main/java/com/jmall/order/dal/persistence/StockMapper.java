package com.jmall.order.dal.persistence;

import com.jmall.commons.tool.tkmapper.TkMapper;
import com.jmall.order.dal.entitys.Stock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper extends TkMapper<Stock> {
 void updateStock(Stock stock);
 Stock selectStockForUpdate(Long itemId);
 Stock selectStock(Long itemId);
 List<Stock> findStocksForUpdate(@Param("itemIds") List<Long> itemIds);
}