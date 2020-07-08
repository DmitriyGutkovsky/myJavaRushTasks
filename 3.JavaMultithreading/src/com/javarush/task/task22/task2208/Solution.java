package com.javarush.task.task22.task2208;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
//        map.put("name", "Ivanov");
        map.put("name", null);
//        map.put("country", "Ukraine");
        map.put("country", null);
//        map.put("city", "Kiev");
        map.put("city", null);
//        map.put("age", "18");
        map.put("age", null);

//        System.out.println(map.toString());

        System.out.println(getQuery(map));


    }

    public static String getQuery(Map<String, String> params) {
        if (params.isEmpty()) {
            return "";
        }

        boolean countNull = params.values().stream().allMatch(Objects::isNull);
        if (countNull) {
            return "";
        }
        StringBuilder sb = new StringBuilder();


        for (Map.Entry<String, String> pair : params.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (value != null) {
                sb.append(key).append(" = ").append("'").append(value).append("'").append(" and ");
            }
        }

        int index = sb.lastIndexOf(" and ");
        sb.delete(index, (index + 5));
        return sb.toString();
    }
}
