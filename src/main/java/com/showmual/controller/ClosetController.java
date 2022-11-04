package com.showmual.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.showmual.model.BigCategoryVo;
import com.showmual.model.ClosetVo;
import com.showmual.model.SmallCategoryVo;
import com.showmual.service.ClosetService;

@Controller("closetController")
@RequestMapping(value = "/closet")
public class ClosetController {
    
    @Autowired
    ClosetService closetService;
    
    @Autowired
    BigCategoryVo bigCategoryVo;
    @Autowired
    SmallCategoryVo smallCategoryVo;
    @Autowired
    ClosetVo closetVo;
    
    List<BigCategoryVo> bigCategoryList = new ArrayList<BigCategoryVo>();
    List<SmallCategoryVo> smallCategoryList = new ArrayList<SmallCategoryVo>();
    List<ClosetVo> imagePathList = new ArrayList<ClosetVo>();
    
    // 대분류 항목 가져오기
    @RequestMapping(value="/bigCategoryList", method=RequestMethod.POST)
    @ResponseBody
    public List<BigCategoryVo> selectBigCategory() {
        bigCategoryList = closetService.bigCategoryList();
        
        return bigCategoryList;
    }
    
    // 소분류 항목 가져오기
    @RequestMapping(value="/smallCategoryList", method=RequestMethod.POST)
    @ResponseBody
    public List<SmallCategoryVo> selectSmallCategory(@RequestParam(value = "big_category_code") int big_category_code) {
        smallCategoryList = closetService.smallCategoryList(big_category_code);
        
        return smallCategoryList;
    }
    
    @RequestMapping(value="/imagePathList", method=RequestMethod.GET)
    @ResponseBody
    public List<ClosetVo> selectImagePath(@RequestParam(value = "smallCategoryCode") int smallCategoryCode,
                    @RequestParam(value = "userId") Long userId) {
        imagePathList = closetService.imagePathList(smallCategoryCode, userId);
        
        return imagePathList;
    }
}
