package com.msj.service;

import com.msj.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sj
 * @version 1.0
 * @date 2020/9/20 17:55
 */
public interface ItemService {
    List<Item> getAll();

    List<Item> getByOrderId(@Param("orderId") int orderId);

    Item findById(@Param("id") int id);

    int insert(Item item);

    int delete(@Param("id") int id);

    int update(Item item);
}
