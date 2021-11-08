package com.demos.agora.model.post;

import com.demos.agora.model.Image.Image;
import com.demos.agora.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // id

	@Column(nullable = false, length = 100)
	private String title; // 제목

	@Column(nullable = false)
	@Lob
	private String content; // 내용

	@ColumnDefault("0")
	private String price; // 가격

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // cacade : post 삭제시 이미지 다날라감.
	@JsonIgnoreProperties({"post"})
	@ToString.Exclude
	private List<Image> images;

	@ColumnDefault("0") // default값 0이 들어간다.
	private int favorite; // 관심수t

	@ColumnDefault("0")
	private int count; // 조회수

	@ManyToOne // post가 many
	@JoinColumn(name = "userId") // 컬럼명 적기
	private User user;

	private String category;

	@Column(nullable = false)
	private String gu;

	@Column(nullable = false)
	private String dong;

	@CreationTimestamp
	private Timestamp createDate; // 만든시간
}