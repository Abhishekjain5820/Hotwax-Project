package com.hotwax.order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotwax.order.entities.OrderItemEntity;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, String> {

	Optional<OrderItemEntity> findByOrderIdAndOrderItemSeqId(String orderId, String orderItemSeqId);

	Optional<com.hotwax.order.entities.OrderItemEntity> findByOrderItemSeqIdAndOrderId(String orderItemSeqId,
			String orderItemId);

}
