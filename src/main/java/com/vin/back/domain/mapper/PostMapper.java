package com.vin.back.domain.mapper;

import java.util.List;

import com.vin.back.application.dto.CommentDTO;
import com.vin.back.application.dto.HashtagDTO;
import com.vin.back.application.dto.LikeDTO;
import com.vin.back.application.dto.PostDTO;
import com.vin.back.application.dto.ShortUserDTO;
import com.vin.back.domain.model.PostEntity;

public class PostMapper {
    public static List<PostDTO> toDTO(List<PostEntity> postEntities) {
        return postEntities.stream().map(post -> {
            ShortUserDTO user = UserMapper.toDTO(post.getUserEntity());
            List<HashtagDTO> hashtags = HashtagMapper.toDTOFromPH(post.getPostHashtagEntities());
            List<LikeDTO> likes = LikeMapper.toDTO(post.getLikeEntities());
            List<CommentDTO> comments = CommentMapper.toDTO(post.getCommentEntities());
            return new PostDTO(post,user, hashtags, likes, comments);
        }).toList();
    }

    public static PostDTO toDTO(PostEntity postEntity) {
        ShortUserDTO user = UserMapper.toDTO(postEntity.getUserEntity());
        List<HashtagDTO> hashtags = HashtagMapper.toDTOFromPH(postEntity.getPostHashtagEntities());
        List<LikeDTO> likes = LikeMapper.toDTO(postEntity.getLikeEntities());
        List<CommentDTO> comments = CommentMapper.toDTO(postEntity.getCommentEntities());
        return new PostDTO(postEntity,user, hashtags, likes, comments);
    }

    public static PostEntity toEntity(PostDTO postDTO) {
        PostEntity entity = new PostEntity();
        entity.setId(postDTO.getId());
        entity.setUserEntity(UserMapper.toEntity(postDTO.getUser()));

        entity.setContent(postDTO.getContent());
        entity.setImageAttached(postDTO.getImageAttached());
        entity.setUploadDate(postDTO.getUploadDate());
        entity.setModified(postDTO.isModified());

        entity.setPostHashtagEntities(PostHashtagMapper.toEntity(postDTO.getHashtags(), entity));

        entity.setLikeEntities(LikeMapper.toEntity(postDTO.getLikes()));
        entity.setCommentEntities(CommentMapper.toEntity(postDTO.getComments()));

        return entity;
    }
    }

