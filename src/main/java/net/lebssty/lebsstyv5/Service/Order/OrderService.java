package net.lebssty.lebsstyv5.Service.Order;

import net.lebssty.lebsstyv5.Dto.AddressDto;
import net.lebssty.lebsstyv5.Dto.OrderDto;

import java.io.IOException;
import java.util.List;

public interface OrderService {
    public OrderDto createOrder(OrderDto orderDto, AddressDto addressDto) throws IOException;
    OrderDto getOrderById(Long orderId);
    List<OrderDto> listAllOrders();
    List<OrderDto> listOrdersByUserId(Long userId);
}

