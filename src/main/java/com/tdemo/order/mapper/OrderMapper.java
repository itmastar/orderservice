package com.tdemo.order.mapper;

import com.tdemo.order.dto.OrderDTO;
import com.tdemo.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE= Mappers.getMapper(OrderMapper.class);
    OrderDTO mapOrderToOrderDTO(Order order);
    Order mapOrderDTOToOrder(OrderDTO orderDTO);
}
