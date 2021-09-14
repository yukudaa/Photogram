package com.cos.photogramstart.domain.image;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.cos.photogramstart.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor // 전체생성자
@NoArgsConstructor // 빈생성자
@Data
@Entity // 디비에 테이블을 생성
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다.
	private int id;
	private String caption; // 오늘 나 너무 피곤해!!
	private String postImageUrl; // 사진을 전송받아서 그 사진을 서버에 특정 폴더에 저장 - DB에 그 저장된 경로를 insert

	@JoinColumn(name = "userId")
	@ManyToOne
	private User user;

	// 이미지 좋아요

	// 댓글

	private LocalDateTime createDate;

	@PrePersist // 디비에 INSERT가 되기 직전에 실행
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}

}
