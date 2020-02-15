/**
 * 
 */
package com.Mz.Comprehensive_Community.repository;

import com.Mz.Comprehensive_Community.domain.User;

import java.util.List;

/**
 * @author 26862
 *
 */
public interface UserRepository {
	User saveOrUpdateUser(User user);
	
	void deleteUser(Long id);
	
	User getUserById(Long id);
	
	List<User> listUsers();
}
