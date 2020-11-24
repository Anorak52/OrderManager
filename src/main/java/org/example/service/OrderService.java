package org.example.service;

import org.example.entity.Order;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order){
        orderRepository.save(order);
    }

    public boolean deleteOrder(Long orderId) {
        if(orderRepository.findById(orderId).isPresent()) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

    public Order findOrderById(Long orderId) {
        Optional<Order> orderFromDb = orderRepository.findById(orderId);
        return orderFromDb.orElse(new Order());
    }

    public List<Order> allOrder() {
        return orderRepository.findAll();
    }

    public List<Order> orderGetList(Long idMin) {
        return em.createQuery("SELECT u FROM Order u WHERE u.id > :paramId", Order.class)
                .setParameter("paramId", idMin).getResultList();
    }

    @Transactional
    public void mergeWithExistingAndUpdate(Long orderId) {
        final Order existingOrder = findOrderById(orderId);

        existingOrder.setUsername(existingOrder.getUsername());
        existingOrder.setOrderComment(existingOrder.getOrderComment());
        existingOrder.setCreatureDate(existingOrder.getCreatureDate());
        //existingOrder.setIdOfRemoved(existingOrder.getIdOfRemoved());
        existingOrder.setId(existingOrder.getId());
        //existingOrder.setIdOfCreature(existingOrder.getIdOfCreature());
        //existingOrder.setIdOfRemoved(existingOrder.getIdOfRemoved());
        //existingOrder.setIdOfCreature(existingOrder.getIdOfCreature());

        em.flush();
    }

     /*   public void update(Order order) {
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
    }*/
}
