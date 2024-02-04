package com.eshop.repository;

import com.eshop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> , QuerydslPredicateExecutor<Item> {
    List<Item> findByItemNm(String itemNm); //findByItemNm = item이름을 통해 조회하는 쿼리 메소드

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail); //findByItemNm = 상품을 상품명과 상품 상세설명을 or 조건을 이용하여 조회하는 쿼리 메소드이다.

    List<Item> findByPriceLessThan(Integer price); //파라미터로 넘어온 price 변수보다 값이 작은 상품 데이터를 조회하는 쿼리 메소드이다.

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price); //OrderBy로 정렬 처리하기

    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
//    @Query(nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);


}
