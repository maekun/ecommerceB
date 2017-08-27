package jp.co.rakus.ecommerce_b.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.Topping;

/**
 * トッピングの情報を引き出すリポジトリ
 * 
 * @author hiroshi.igari
 *
 */
@Repository
public class ToppingRepository {
	@Autowired
	NamedParameterJdbcTemplate template;

	@Autowired
	private static final RowMapper<Topping> toppingRowMapper = (rs, i) -> {
		Topping topping = new Topping();
		topping.setId(rs.getInt("id"));
		topping.setName(rs.getString("name"));
		topping.setPriceM(rs.getInt("price_m"));
		topping.setPriceL(rs.getInt("price_l"));
		return topping;
	};

	/**
	 * 全件検索を行うメソッド.
	 * 
	 * @return トッピング全件検索結果
	 */
	public List<Topping> findAll() {
		String sql = "select id,name,price_m,price_l from toppings;";
		List<Topping> toppingList = template.query(sql, toppingRowMapper);
		return toppingList;
	}

	/**
	 * 指定したIDと一致する情報を検索するメソッド。
	 * 
	 * @param id
	 * @return トッピング
	 */
	public Topping load(Integer id) {
		String sql = "select id,name,price_m,price_l from toppings where id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Topping topping = template.queryForObject(sql, param, toppingRowMapper);
		return topping;
	}
}
