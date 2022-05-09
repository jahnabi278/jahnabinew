package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> 
{

}
