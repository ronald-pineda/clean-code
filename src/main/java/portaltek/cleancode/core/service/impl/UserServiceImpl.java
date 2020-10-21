/**
 * 
 */
package portaltek.cleancode.core.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portaltek.cleancode.spi.datastore.repository.UserRepo;
import portaltek.cleancode.spi.datastore.model.Role;
import portaltek.cleancode.spi.datastore.model.User;
import portaltek.cleancode.core.service.RoleService;
import portaltek.cleancode.core.service.UserService;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private UserRepo userRepo;
	private RoleService roleService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepo userRepo,
												 PasswordEncoder passwordEncoder,
												 RoleService roleService) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.roleService = roleService;
	}

	@Override
	public User findUserByUsername(String username) {

		return userRepo.findByUsername(username);
	}

	@Override
	public User create(User u) {
		String hashedPass = passwordEncoder.encode(u.getPassword());
		u.setPassword(hashedPass);
		u.setEnabled(true);
		Role role = roleService.read(2);
		u.addRole(role);
		return userRepo.save(u);
	}

	@Override
	public User read(Long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public User update(User u) {
		return userRepo.save(u);
	}

	@Override
	public void delete(Long id) {
		userRepo.deleteById(id);
	}
}
