package com.atguigu.usermanage.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author erdong
 * @create 2019-08-28 15:17
 */
public class StringToDateConverter implements Converter<String, Date> {

    // 日期格式化工具
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        // 判断字段是否为空
        if (!StringUtils.isEmpty(source)) {
            try {  // try{} catch{} 快捷键：ctrl + alt + t
                // 不为空，则格式化
                return FORMATTER.parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
