package com.baiyu.hello.controller;

import com.baiyu.hello.mapper.CategoryMapper;
import com.baiyu.hello.pojo.Category;
import com.baiyu.hello.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired(required = false)
    private CategoryMapper categoryMapper;
    @Autowired(required = false)
    private CategoryService categoryService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("list")
    public String list(Model model) {
        List<Category> cs = categoryMapper.list();
        model.addAttribute("cs", cs);
        return "list";
    }

    @RequestMapping("/category")
    public void category(@RequestBody Category category) throws Exception {
        System.out.println("springboot接受到浏览器以JSON格式提交的数据："+category);
    }

    @GetMapping("/category/{id}")
    public Category category(@PathVariable int id) throws Exception {
        System.out.println(redisTemplate.opsForValue().get("category123"));
        return categoryService.get(id);
    }
}
