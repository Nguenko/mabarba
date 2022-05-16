package com.project.mabarba.helpers;

import org.springframework.data.domain.Page;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionalUtilities <T> {

    Map<String, Object> response = new HashMap<>();

    public Map<String, Object> paginator (Page<T> page){
        Function<Page<T>, Map<String, Object>> mapFunction= (salonP) -> {
            response.put("content", salonP.getContent());
            response.put("totalPage", salonP.getTotalPages());
            response.put("totalElement", salonP.getTotalElements());
            response.put("currentPage", salonP.getNumber());
            return  response;
        };

         return mapFunction.apply(page);
    }
}
