package com.ojt.movie.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Movie implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 50, nullable = false, unique = true)
	@NotBlank(message = "Required")	
	private String title;
	
	@Column(length = 200)
	@NotBlank(message = "Required")
	private String posterPath;
	
	@Column(nullable = false)
	private int budget;

	@Column(length = 200)
	private String homePage;

	@Column(length = 200)
	@NotBlank(message = "Required")
	private String trailerPath;

	@Column(length = 200)
	@NotBlank(message = "Required")
	private String overview;
	
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;
	
	@Column(columnDefinition = "boolean", nullable = false)
	@ColumnDefault("false")
	private Boolean adult;

	@Column(nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
}
