/**
 * 
 */
package com.Mz.Comprehensive_Community.repository;

import com.Mz.Comprehensive_Community.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author 26862
 *
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
