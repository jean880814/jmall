package com.jmall.search.converter;

import com.jmall.search.dal.entitys.Item;
import com.jmall.search.dto.ProductDto;
import com.jmall.search.entity.ItemDocument;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-12T13:12:01+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class ProductConverterImpl implements ProductConverter {

    @Override
    public ProductDto item2Dto(ItemDocument item) {
        if ( item == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setPicUrl( item.getImage() );
        if ( item.getId() != null ) {
            productDto.setProductId( item.getId().longValue() );
        }
        productDto.setSubTitle( item.getSell_point() );
        if ( item.getPrice() != null ) {
            productDto.setSalePrice( BigDecimal.valueOf( item.getPrice() ) );
        }
        productDto.setProductName( item.getTitle() );

        return productDto;
    }

    @Override
    public List<ProductDto> items2Dto(List<ItemDocument> items) {
        if ( items == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( items.size() );
        for ( ItemDocument itemDocument : items ) {
            list.add( item2Dto( itemDocument ) );
        }

        return list;
    }

    @Override
    public ItemDocument item2Document(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDocument itemDocument = new ItemDocument();

        itemDocument.setSell_point( item.getSellPoint() );
        itemDocument.setLimit_num( item.getLimitNum() );
        itemDocument.setCid( item.getCid() );
        if ( item.getId() != null ) {
            itemDocument.setId( item.getId().intValue() );
        }
        itemDocument.setImage( item.getImage() );
        itemDocument.setStatus( item.getStatus() );
        itemDocument.setTitle( item.getTitle() );
        itemDocument.setNum( item.getNum() );
        itemDocument.setCreated( item.getCreated() );
        if ( item.getPrice() != null ) {
            itemDocument.setPrice( item.getPrice().doubleValue() );
        }
        itemDocument.setUpdated( item.getUpdated() );

        return itemDocument;
    }
}
