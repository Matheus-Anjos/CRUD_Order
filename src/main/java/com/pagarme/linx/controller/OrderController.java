package com.pagarme.linx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
/*import org.springframework.web.bind.annotation.PatchMapping; */
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagarme.linx.model.Order;
import com.pagarme.linx.repository.OrderRepository;
/*import com.pagarme.linx.service.OrderService;*/

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAllOrder(){
		return ResponseEntity.ok(orderRepository.findAll());
	}
	
	 @GetMapping("/{id}")
	public ResponseEntity<Order> findByIdOrder(@PathVariable (value="id") Long id){
		return orderRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/save")
	public ResponseEntity<Order> post (@RequestBody Order order){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderRepository.save(order));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Order> put (@RequestBody Order order){
		return ResponseEntity.status(HttpStatus.OK).body(orderRepository.save(order));
	}
	
	@PatchMapping("/update/{id}/{status}")
	public ResponseEntity<Order> updateStatusPartially(@PathVariable Long id, @PathVariable String status) {
	try {
		Order order = orderRepository.findById(id).get();
		order.setStatus(status);
		return new ResponseEntity<Order>(orderRepository.save(order), HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}


	


