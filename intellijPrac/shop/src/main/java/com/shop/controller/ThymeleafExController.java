package com.shop.controller;

import com.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ThymeleafExController {
    @RequestMapping(value="/thymeleaf/ex01")
    public String thymeleafExam01(Model model){
        model.addAttribute("data","타임리프 예제");
        return "thymeleafEx/thymeleafEx01";
    }

    @RequestMapping(value = "/thymeleaf/ex02")
    public String thymeleafExam02(Model model) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품의 상세한 설명");
        itemDto.setItemNm("더미 상품");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeleafEx02";
    }
}
