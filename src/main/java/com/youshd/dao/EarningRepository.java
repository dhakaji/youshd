package com.youshd.dao;

import com.youshd.entities.Earning;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EarningRepository extends CrudRepository<Earning, Integer> {
    Earning findFirstByUserIdAndProductId(int userId, int productId);
    List<Earning> findByUserId(int userId);
}
