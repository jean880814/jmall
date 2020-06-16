package com.jmall.search.repository;

import com.jmall.search.entity.ItemDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ItemDocument, Integer> {
}
