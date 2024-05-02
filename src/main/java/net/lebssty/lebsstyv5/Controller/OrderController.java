package net.lebssty.lebsstyv5.Controller;


import net.lebssty.lebsstyv5.Dto.AddressDto;
import net.lebssty.lebsstyv5.Dto.OrderDto;
import net.lebssty.lebsstyv5.Service.Order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto, AddressDto addressDto) throws IOException {
        OrderDto createdOrder = orderService.createOrder(orderDto,addressDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        OrderDto orderDto = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> listAllOrders() {
        List<OrderDto> orderDtos = orderService.listAllOrders();
        return ResponseEntity.ok(orderDtos);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> listOrdersByUserId(@PathVariable Long userId) {
        List<OrderDto> orderDtos = orderService.listOrdersByUserId(userId);
        return ResponseEntity.ok(orderDtos);
    }
}

