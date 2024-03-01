package com.eshop.dto;

import com.eshop.entity.ItemImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class ItemImgDto {
    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper();

    public static ItemImgDto of(ItemImg itemImg) {
        return modelMapper.map(itemImg, ItemImgDto.class); //key로 itemImg 객체, value로 ItemImgDto클래스
    }
}
