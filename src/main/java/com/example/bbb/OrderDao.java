package com.example.bbb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDao extends JpaRepository<Order,Long> {

    @Query(value = "select order_id,order_name from t_order  where order_id=?1",nativeQuery = true)
    Order findByOrderId(Long  id);


}
