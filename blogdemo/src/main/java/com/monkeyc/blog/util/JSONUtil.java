package com.monkeyc.blog.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monkeyc.blog.exception.SystemException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 解析JSON
 */
public class JSONUtil {
    public static String Myformat(Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new SystemException("JSON解析错误"+object);
        }
    }

    public static <T> T get(HttpServletRequest request,Class<T> clazz){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        try {
            return objectMapper.readValue(request.getInputStream(),clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SystemException("JSON反序列化失败：");
        }
    }
}
