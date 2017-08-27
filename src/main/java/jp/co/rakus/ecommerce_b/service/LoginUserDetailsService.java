package jp.co.rakus.ecommerce_b.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.ecommerce_b.domain.User;
import jp.co.rakus.ecommerce_b.repository.UserRepository;

/**
 * LoginUserDetailsを作成するサービスクラス.
 * @author hiroki.mae
 *
 */
@Service
@Transactional
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepository.loadByEmail(email);
		return new LoginUser(user);
	}
}
