package com.sony.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.sony.entity.LineItem;
import com.sony.entity.Order;
import com.sony.model.CustomerDto;
import com.sony.model.EmployeeDto;
import com.sony.model.LineItemDto;
import com.sony.model.OrderDto;
import com.sony.model.ProductDto;
import com.sony.model.ShipperDto;
import com.sony.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private RestTemplate template;

	@Value("${service.urls.shipper}")
	private String shipperServiceUrl;
	
	@Value("${service.urls.customer}")
	private String customerServiceUrl;

	@Value("${service.urls.employee}")
	private String employeeServiceUrl;

	@Value("${service.urls.product}")
	private  String productServiceUrl;


	public OrderDto getOrderById(Integer id) {
		Optional<Order> op = repo.findById(id);
		if (op.isEmpty()) {
			return null;
		}
		// convert the Order instance to OrderDto instance
		return toOrderDto(op.get());
	}
	
	// pure functions: work on arguments only (and not any member data)
	// pure functions must be marked as static
	private LineItemDto toLineItemDto(LineItem li) {
		LineItemDto dto = new LineItemDto();
		dto.setDiscount(li.getDiscount());
		dto.setQuantity(li.getQuantity());
		dto.setUnitPrice(li.getUnitPrice());
		
		try {
			String url = productServiceUrl + li.getProductId();
			ProductDto p = template.getForObject(url, ProductDto.class);
			dto.setProduct(p);
		}
		catch(Exception ex) {
			log.warn("Error while fetching product with id: " + li.getProductId(), ex);
		}
		return dto;
	}

	private OrderDto toOrderDto(Order order) {
		OrderDto dto = new OrderDto();
		dto.setOrderId(order.getOrderId());
		dto.setOrderDate(order.getOrderDate());
		dto.setRequiredDate(order.getRequiredDate());
		dto.setShippedDate(order.getShippedDate());
		dto.setFreight(order.getFreight());
		dto.setShippedToName(order.getShippedToName());
		dto.setShippedToAddress(order.getShippedToAddress());
		dto.setShippedToCity(order.getShippedToCity());
		dto.setShippedToRegion(order.getShippedToRegion());
		dto.setShippedToCountry(order.getShippedToCountry());
		dto.setShippedToPostalCode(order.getShippedToPostalCode());
		
		// for each LineItem in "order", create and add a LineItemDto object
		List<LineItemDto> lineItems = order.getLineItems()
			.stream()
			.map(this::toLineItemDto)
			.collect(Collectors.toList());
		dto.setLineItems(lineItems);
		
		
		// go and get the customer data from customer-service
		try {
			String url = customerServiceUrl + order.getCustomerId();
			CustomerDto resp = template.getForObject(url, CustomerDto.class);
			dto.setCustomer(resp);
		}
		catch(Exception ex) {
			log.warn("There was an error while fetching customer info", ex);
		}

		// go and get the shipper data from shipper-service
		try {
			String url = shipperServiceUrl + order.getShipperId();
			ShipperDto resp = template.getForObject(url, ShipperDto.class);
			dto.setShippedBy(resp);
		} catch (RestClientException ex) {
			log.warn("There was an error while fetching shipper info", ex);
		}
		
		// go and get the employee data from the employee-service
		try {
			String url = employeeServiceUrl + order.getEmployeeId();
			EmployeeDto resp = WebClient.create(url)
					.get()
					.retrieve()
					.bodyToMono(EmployeeDto.class)
					.block();
			dto.setEmployee(resp);
		}
		catch(Exception ex) {
			log.warn("There was an error while fetching employee info", ex);
		}
		return dto;
	}
}
