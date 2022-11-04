package com.showmual.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ClosetVo {
    
    public int item_id;
    public Long user_id;
    public int small_category_code;
    public String color;
    public String image_path;
}
