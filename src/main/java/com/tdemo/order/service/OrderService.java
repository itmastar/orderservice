package com.tdemo.order.service;

import com.tdemo.order.dto.OrderDTO;
import com.tdemo.order.dto.OrderDTOFromFE;
import com.tdemo.order.dto.UserDTO;
import com.tdemo.order.entity.Order;
import com.tdemo.order.mapper.OrderMapper;
import com.tdemo.order.repo.OrderRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Autowired
    private RestTemplate restTemplate;

    public OrderDTO saveOrder(OrderDTOFromFE orderDTOFromFE) {
       Integer newOrderId= sequenceGenerator.generateNextOrderId();
       UserDTO userDTOFetchedFromUserMS=FetchUserDTOFromUserMS(orderDTOFromFE.getUserId());
       Order orderToBeSaved= new Order(newOrderId,orderDTOFromFE.getFoodItemsDTOList(),orderDTOFromFE.getRestaurantDTO(),userDTOFetchedFromUserMS);
       orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO FetchUserDTOFromUserMS(Integer userId) {
    return  restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/"+userId, UserDTO.class);

    }
}
