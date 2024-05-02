package net.lebssty.lebsstyv5.Service.Order;

import net.lebssty.lebsstyv5.Dto.AddressDto;
import net.lebssty.lebsstyv5.Dto.OrderDto;
import net.lebssty.lebsstyv5.Entity.Address;
import net.lebssty.lebsstyv5.Entity.CartItems;
import net.lebssty.lebsstyv5.Entity.Order;
import net.lebssty.lebsstyv5.Enum.OrderStutus;
import net.lebssty.lebsstyv5.Repository.AddressRepository;
import net.lebssty.lebsstyv5.Repository.OrderRepository;
import net.lebssty.lebsstyv5.user.Entity.User;
import net.lebssty.lebsstyv5.user.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, AddressRepository addressRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public OrderDto createOrder(OrderDto orderDto, AddressDto addressDto) {
        Order order = new Order();
        order.setCreatedAt(new Date()); // Should set server's current time
        order.setPaymentMethod(orderDto.getPaymentMethod());
        order.setOrderStatus(OrderStutus.Pending); // Set the order status
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setTrackingId(UUID.randomUUID()); // Generate a new tracking ID

        User user = userRepository.findById(orderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + orderDto.getUserId()));
        order.setUser(user);

        // Convert AddressDto to Address entity
        Address address = new Address();
        address.setName(addressDto.getName());
        address.setMobile(addressDto.getMobile());
        address.setHouse(addressDto.getHouse());
        address.setLandmark(addressDto.getLandmark());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setPostalCode(addressDto.getPostalCode());

        // Set the user for the address
        address.setUser(user);

        // Save the address
        Address savedAddress = addressRepository.save(address);
        System.out.println(savedAddress);
        // Set the saved address to the order
        order.setAddress(savedAddress);

        // Create CartItems
        List<CartItems> cartItems = orderDto.getCartItems().stream()
                .map(dto -> {
                    CartItems item = new CartItems();
                    item.setName(dto.getName());
                    item.setPrice(dto.getPrice());
                    item.setQuantity(dto.getQuantity());
                    item.setOrder(order); // Link back to order
                    // Image handling logic should be here if applicable
                    return item;
                })
                .collect(Collectors.toList());

        order.setCartItems(cartItems);

        // Save the order and return its DTO
        return orderRepository.save(order).getDto();
    }



    @Override
    public OrderDto getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .map(Order::getDto)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
    }

    @Override
    public List<OrderDto> listAllOrders() {
        return orderRepository.findAll().stream()
                .map(Order::getDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> listOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(Order::getDto)
                .collect(Collectors.toList());
    }



}

