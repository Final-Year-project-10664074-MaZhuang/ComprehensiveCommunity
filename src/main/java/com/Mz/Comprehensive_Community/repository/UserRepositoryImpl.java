/**
 * 
 */
package com.Mz.Comprehensive_Community.repository;


import com.Mz.Comprehensive_Community.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 26862
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	private static AtomicLong counter = new AtomicLong();
	
	private final ConcurrentMap<Long, User> userMap =  new ConcurrentHashMap<>();
	
	public User saveOrUpdateUser(User user) {
		
		Long id = user.getId();
		if(id==null) {
			id = counter.incrementAndGet();
			user.setId(id);
		}
		this.userMap.put(id, user);
		return user;
	}

	public void deleteUser(Long id) {
		this.userMap.remove(id);
	}

	public User getUserById(Long id) {
		
		return this.userMap.get(id);
	}

	public List<User> listUsers() {
		return new ArrayList<User>(this.userMap.values());
	}
	
}
