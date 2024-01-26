package com.E_commerceProject.E_commerceProject.repsitory;

import com.E_commerceProject.E_commerceProject.entity.Order;
import com.E_commerceProject.E_commerceProject.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUserIdAndOrderStatus(Long userId,OrderStatus orderStatus);
}
