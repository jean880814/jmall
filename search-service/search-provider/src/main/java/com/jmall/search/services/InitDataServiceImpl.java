package com.jmall.search.services;

import com.jmall.search.InitDataService;
import com.jmall.search.converter.ProductConverter;
import com.jmall.search.dal.entitys.Item;
import com.jmall.search.dal.persistence.ItemMapper;
import com.jmall.search.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@Service
public class InitDataServiceImpl implements InitDataService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ProductConverter productConverter;

    @Override
    public void initItems() {
        List<Item> items=itemMapper.selectAll();
        items.parallelStream().forEach(item->{
            productRepository.save(productConverter.item2Document(item));
        });
    }
}
