package com.ojt.movie.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "Required")
	private String name;
	
	@Column(length = 100,nullable = false, unique = true)
	@NotBlank(message = "Required")
	private String password;
	
	@Column(length = 100,nullable = false, unique = true)
	@NotBlank(message = "Required")	
	private String gmail;
	
	@Column(columnDefinition = "ENUM('active', 'deactivated', 'banned', 'violated') NOT NULL")
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	
	@Column(columnDefinition = "ENUM('admin', 'user') NOT NULL")
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@Column(nullable = false)	
	@Temporal(TemporalType.DATE)
	private LocalDate startJoinDate;
	private LocalDate lastJoinDate;
	private int accessCount;
	
	@Column(nullable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;

}
