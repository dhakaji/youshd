package com.youshd.dao;

import com.youshd.entities.AffiliateLink;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AffiliateLinkRepository extends CrudRepository<AffiliateLink, Integer> {
    List<AffiliateLink> findByUserIdAndProductId(int userId, int productId);
    AffiliateLink findFirstByAffiliateLink(String affiliateLink);
}
