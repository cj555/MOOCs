package io.cj555.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj555.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{


}