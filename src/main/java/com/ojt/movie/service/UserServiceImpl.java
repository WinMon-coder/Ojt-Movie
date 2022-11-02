package com.ojt.movie.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ojt.movie.entity.User;
import com.ojt.movie.entity.UserRole;
import com.ojt.movie.entity.UserStatus;
import com.ojt.movie.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder pwEncoder;
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User get(int id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User create(User user) {
		// Check IF user with same gmail exists
		User tempGmailCheckUser = userRepository.findByName(user.getGmail());
		if(tempGmailCheckUser != null) {
			return null;
		}
		user.setUserRole(UserRole.user);
		user.setStartJoinDate(LocalDate.now());
		user.setUserStatus(UserStatus.active);
		user.setPassword(pwEncoder.encode(user.getPassword()));
		user.setCreatedAt(LocalDateTime.now());
		return userRepository.save(user);
	}

	@Override
	public User update(int id, User user) {
		User toUpdateUser = this.get(id);
		if(toUpdateUser == null) {
			return null;
		}
		toUpdateUser.setName(user.getName());
		toUpdateUser.setGmail(user.getGmail());
		toUpdateUser.setUpdatedAt(LocalDateTime.now());
		userRepository.save(toUpdateUser);
		return toUpdateUser;
	}

	@Override
	public boolean delete(int id) {
		User user = this.get(id);
		if (user == null) {
			return false;
		}
		userRepository.deleteById(id);
		return true;
	}

	@Override
	public User checkLoginUser(String gmail, String password) {
		User user = userRepository.findByGmail(gmail);
		if(user == null) {
			return null;
		}
		if(!pwEncoder.matches(password, user.getPassword())) {
			return null;
		}
		
	return user;
	}

	@Override
	public User updateStatus(int id, String status) {
		User toUpdateUser = this.get(id);
		if (toUpdateUser == null) {
			return null;
		}
		try {
			toUpdateUser.setUserStatus(UserStatus.valueOf(status));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
		toUpdateUser.setUpdatedAt(LocalDateTime.now());
		userRepository.save(toUpdateUser);
		return toUpdateUser;
	}

	@Override
	public List<String> getAllStatus() {
		List<String> userStatusList = new ArrayList<>();
		for (UserStatus status : Arrays.asList(UserStatus.values())) {
			userStatusList.add(status.toString());
		}
		return userStatusList;
	}

}
