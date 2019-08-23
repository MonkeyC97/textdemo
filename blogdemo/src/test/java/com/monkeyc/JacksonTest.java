package com.monkeyc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monkeyc.blog.entity.Article;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {
    @Test
    public void testJackson(){
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setId(1);
        article.setContent("Myblog");
        article.setContent("内容");
        article.setCreateTime(new Date());
        articles.add(article);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        try {
            String result = objectMapper.writeValueAsString(articles);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
