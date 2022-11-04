package com.showmual.entity.closet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "closet_tbl")
public class ClosetEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_Increment인 컬럼
    private int itemId;
    
    private Long userId;
    private int smallCategoryCode;
    private String color;
    private String imagePath;
    
    
}
