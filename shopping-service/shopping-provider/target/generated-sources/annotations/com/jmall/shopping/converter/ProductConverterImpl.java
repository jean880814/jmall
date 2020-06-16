package com.jmall.shopping.converter;

import com.jmall.shopping.dal.entitys.Item;
import com.jmall.shopping.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-12T13:11:57+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class ProductConverterImpl implements ProductConverter {

    @Override
    public ProductDto item2Dto(Item item) {
        if ( item == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setPicUrl( item.getImageBig() );
        productDto.setProductId( item.getId() );
        productDto.setSubTitle( item.getSellPoint() );
        productDto.setSalePrice( item.getPrice() );
        productDto.setProductName( item.getTitle() );

        return productDto;
    }

    @Override
    public List<ProductDto> items2Dto(List<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( items.size() );
        for ( Item item : items ) {
            list.add( item2Dto( item ) );
        }

        return list;
    }
}
