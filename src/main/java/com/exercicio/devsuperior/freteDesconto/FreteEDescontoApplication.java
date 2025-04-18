package com.exercicio.devsuperior.freteDesconto;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exercicio.devsuperior.freteDesconto.entities.Order;
import com.exercicio.devsuperior.freteDesconto.services.OrderService;
import com.exercicio.devsuperior.freteDesconto.services.ShippingService;

@SpringBootApplication
public class FreteEDescontoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FreteEDescontoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("código: ");
		Integer code = sc.nextInt();
		System.out.print("Basic value:");
		Double basic = sc.nextDouble();
		System.out.print("discount percentage:");
		Double discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
		
		OrderService os = new OrderService(new ShippingService());
		
		System.out.println("pedido código " + order.getCode());
		System.out.println(os.total(order));
		
		
		sc.close();
	}

}
