package com.sunghowe.community.dao.elasticsearch;

import com.sunghowe.community.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author SungHowe
 * @title DiscussPostRepository
 * @description
 * @create 2022-06-08 19:53
 */
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> {

}
