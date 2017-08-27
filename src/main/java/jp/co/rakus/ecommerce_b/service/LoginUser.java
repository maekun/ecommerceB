package jp.co.rakus.ecommerce_b.service;

import org.springframework.security.core.authority.AuthorityUtils;

import jp.co.rakus.ecommerce_b.domain.User;

/**
 * ログインユーザを持つ詳細情報クラス.
 * @author hiroki.mae
 *
 */
public class LoginUser extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 1L;
	
	/** ログインユーザ*/
	private final User user;
	
	public LoginUser(User user){
		super(user.getEmail(),user.getPassword(),AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	
}
