package com.exercicio.devsuperior.freteDesconto.services;

import org.springframework.stereotype.Service;

import com.exercicio.devsuperior.freteDesconto.entities.Order;

@Service
public class OrderService {

	private ShippingService service;
	
	public OrderService(ShippingService service) {
		super();
		this.service = service;
	}

	public Double total(Order order) {
		Double minusTotal = order.getBasic() * (order.getDiscount() / 100) - service.shipment(order);
		return order.getBasic() - minusTotal;
	}
}
