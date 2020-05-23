package com.example.bbb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService{



    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Transactional
    @Override
    public void add() {

        Order order = new Order();
        order.setName("o3");

        OrderItem item = new OrderItem();
        item.setName("i31");

        OrderItem item1 = new OrderItem();
        item1.setName("i32");

        order.getSet().add(item);
        order.getSet().add(item1);

        item.setOrder(order);
        item1.setOrder(order);

        Order o = orderDao.save(order);
        item.setOrderId(o.getId());
        item1.setOrderId(o.getId());
        orderItemDao.save(item);
        orderItemDao.save(item1);

    }

    @Override
    public Order findByOrderId(Long id) {
        return orderDao.findByOrderId(id);
    }
}
