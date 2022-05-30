package com.pagarme.linx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pagarme.linx.model.Order;

@Repository
public interface OrderRepository extends JpaRepository< Order, Long> {
		public List<Order>findAllByNameProductContainingIgnoreCase(String nameProduct);
		
	
}
