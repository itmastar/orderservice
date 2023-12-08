package com.tdemo.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {
    
    private List<FoodItemsDTO> foodItemsDTOList;
    private Integer userId;
    private RestaurantDTO restaurantDTO;
}
