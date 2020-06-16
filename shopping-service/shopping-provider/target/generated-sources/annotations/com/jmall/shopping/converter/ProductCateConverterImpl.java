package com.jmall.shopping.converter;

import com.jmall.shopping.dal.entitys.ItemCat;
import com.jmall.shopping.dto.ProductCateDto;
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
public class ProductCateConverterImpl implements ProductCateConverter {

    @Override
    public ProductCateDto item2Dto(ItemCat itemCat) {
        if ( itemCat == null ) {
            return null;
        }

        ProductCateDto productCateDto = new ProductCateDto();

        productCateDto.setName( itemCat.getName() );
        productCateDto.setIsParent( itemCat.getIsParent() );
        productCateDto.setId( itemCat.getId() );
        productCateDto.setIconUrl( itemCat.getIcon() );
        productCateDto.setParentId( itemCat.getParentId() );

        return productCateDto;
    }

    @Override
    public List<ProductCateDto> items2Dto(List<ItemCat> items) {
        if ( items == null ) {
            return null;
        }

        List<ProductCateDto> list = new ArrayList<ProductCateDto>( items.size() );
        for ( ItemCat itemCat : items ) {
            list.add( item2Dto( itemCat ) );
        }

        return list;
    }
}
