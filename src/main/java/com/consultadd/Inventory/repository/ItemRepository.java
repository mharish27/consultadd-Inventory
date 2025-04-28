package com.consultadd.Inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consultadd.Inventory.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
