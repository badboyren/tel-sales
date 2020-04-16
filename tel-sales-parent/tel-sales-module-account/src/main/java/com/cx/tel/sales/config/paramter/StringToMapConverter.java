package com.cx.tel.sales.config.paramter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * eg:DmsFileView:properties
 * @author sucl
 * @since 2018/11/21
 */
@Component
public class StringToMapConverter implements Converter<String,Map<String,Object>> {

    @SuppressWarnings("unchecked")
	public Map<String, Object> convert(String source) {
        if(source.startsWith("{") && source.endsWith("}")){
            return (Map<String, Object>)JSON.parse(source);
        }
        return null;
    }
}
