package com.demos.agora.model.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ImageRepository extends JpaRepository<Image, Integer>{
	
	@Query(value = "SELECT * FROM image where postId=?1",nativeQuery = true)
	List<Image> 게시물사진찾기(int postId);

}
