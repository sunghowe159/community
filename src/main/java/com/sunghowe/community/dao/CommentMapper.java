package com.sunghowe.community.dao;

import com.sunghowe.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SungHowe
 * @title CommentMapper
 * @description
 * @create 2022-05-28 14:42
 */
@Mapper
public interface CommentMapper {

    List<Comment> selectCommentByEntity(int entityType, int entityId, int offset, int limit);

    int selectCountByEntity(int entityType, int entityId);

    int insertComment(Comment comment);
}
