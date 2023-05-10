package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository
        extends JpaRepository<Item,Long>, QuerydslPredicateExecutor<Item>
        , ItemRepositoryCustom {

    List<Item> findByItemNm(String itemNm);

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    //JPQL
    // 메소드 이름은 전혀 중요하지 않음
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "select * from item  where item_detail like %:itemDetail% order by price desc" , nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
    //    위의 방식도 아래 방식도 충분히 접근 가능 % 유무 상관X
//    @Query(value = "select * from item i  where i.item_detail like %:itemDetail% order by i.price desc" , nativeQuery = true)
//    @Query(value = "SELECT * FROM item i WHERE i.item_detail LIKE :itemDetail ORDER BY i.price DESC", nativeQuery = true)
//    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);

}
