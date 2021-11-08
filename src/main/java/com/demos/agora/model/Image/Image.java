package com.demos.agora.model.Image;

import com.demos.agora.model.post.Post;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String uri;
	
	@ManyToOne
	@JoinColumn(name="postId")
	@ToString.Exclude
	private Post post;
}
