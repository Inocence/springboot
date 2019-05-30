package com.baiyu.hello.service.impl;

import com.baiyu.hello.mapper.CategoryMapper;
import com.baiyu.hello.pojo.Category;
import com.baiyu.hello.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "category")
public class CategoryServiceImpl implements CategoryService {
    @Autowired(required = false)
    private CategoryMapper categoryMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Cacheable("'category' + #p0")
    public Category get(int id) {

        return categoryMapper.get(id);
    }
}
