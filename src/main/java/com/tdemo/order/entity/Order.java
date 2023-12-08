package com.tdemo.order.entity;

import com.tdemo.order.dto.FoodItemsDTO;
import com.tdemo.order.dto.RestaurantDTO;
import com.tdemo.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="order")
public class Order {

    private Integer orderId;
    private List<FoodItemsDTO> foodItemsDTOList;
    private RestaurantDTO restaurantDTO;
    private UserDTO userDTO;
}
