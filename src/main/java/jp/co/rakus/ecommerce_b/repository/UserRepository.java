package jp.co.rakus.ecommerce_b.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.User;

/**
 * Usersテーブルを操作するリポジトリクラス.
 * 
 * @author hiroki.mae
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Autowired
	private static final RowMapper<User> userRowMapper = (rs, i) -> {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setAddress(rs.getString("address"));
		user.setTelephone(rs.getString("telephone"));
		return user;
	};

	/**
	 * メールアドレスで一件検索.
	 * 
	 * @param email
	 *            メールアドレス
	 * @return 検索結果(例外の場合nullを返す)
	 */
	public User loadByEmail(String email) {
		String sql = "select * from users where email = :email ;";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("email", email);
		try {
			User user = template.queryForObject(sql, paramMap, userRowMapper);
			return user;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	//TODO:登録済みのユーザだった場合、テーブルデータを上書きする.
	/**
	 * ユーザを一件登録.
	 *
	 * @param user
	 *            ユーザ情報
	 * @return 更新した行数
	 */
	public Integer save(User user) {
		SqlParameterSource paramMap = new BeanPropertySqlParameterSource(user);
		String sql = "INSERT INTO users (name,email,password,address,telephone) values (:name,:email,:password,:address,:telephone);";
		try {
			Integer resultRow = template.update(sql, paramMap);
			return resultRow;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * メールアドレスで一件削除.
	 * 
	 * @param email
	 *            メールアドレス
	 * @return 更新した行数
	 */
	public Integer deleteByEmail(String email) {

		String sql = "delete from users where email = :email ;";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("email", email);
		try {
			Integer resultRow = template.update(sql, paramMap);
			return resultRow;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
