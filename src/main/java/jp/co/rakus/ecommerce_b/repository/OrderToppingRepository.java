package jp.co.rakus.ecommerce_b.repository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.OrderTopping;

/**
 * OrderToppingのRepository
 * 
 * @author akihiko.yahiro
 *
 */
@Repository
public class OrderToppingRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	//////自動採番されたid取得に必要
	private SimpleJdbcInsert insert;
	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("order_toppings");
		insert = withTableName.usingGeneratedKeyColumns("id");
	}
	//////

	@Autowired
	private static final RowMapper<OrderTopping> orderToppingRowMappar = (rs, i) -> {
		OrderTopping orderTopping = new OrderTopping();
		orderTopping.setId((rs.getInt("id")));
		orderTopping.setOrderItemId(rs.getInt("order_item_id"));
		orderTopping.setToppingId(rs.getInt("topping_id"));
		return orderTopping;
	};

	/**
	 * idで主キー検索
	 * @param id id
	 * @return トッピング
	 */
	public OrderTopping load(Integer id) {
		String sql = "SELECT id, order_item_id, topping_id from order_toppings WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		OrderTopping orderTopping = template.queryForObject(sql, param, orderToppingRowMappar);
		return orderTopping;

	}
	/**
	 * テスト用
	 * ToppingIdで一件検索
	 * @param toppingId toppingId
	 * @return トッピング
	 */
	public OrderTopping loadByToppingId(Integer toppingId) {
		String sql = "SELECT id, order_item_id, topping_id from order_toppings WHERE topping_id = :toppingId;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("toppingId", toppingId);
		OrderTopping orderTopping = template.queryForObject(sql, param, orderToppingRowMappar);
		return orderTopping;
		
	}

	/**
	 * ショッピングカート内に記載するトッピングのリスト
	 * 
	 * @return 全件検索済みのリスト
	 */
	public List<OrderTopping> findAll() {
		String sql = "SELECT id, order_item_id, topping_id from order_toppings ORDER BY id;";
		List<OrderTopping> OrderToppingList = template.query(sql, orderToppingRowMappar);
		return OrderToppingList;
	}

	/**
	 * ピザとトッピングの紐づけ詳細を一件削除.
	 * 
	 * @param id id
	 */
	public void delete(Integer id) {
		String sql = "DELETE FROM order_toppings WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource("id", id);
		template.update(sql, param);
	}
	/**
	 * ピザとトッピングの紐づけ詳細を全件削除.
	 */
	public void deleteAll() {
		String sql = "DELETE FROM order_toppings ; ";
		SqlParameterSource param = new MapSqlParameterSource();
		template.update(sql, param);
	}

	/**
	 * ピザとトッピングの紐づけ詳細を一件追加する.
	 * @param orderTopping どのピザにどのトッピングがついているかの情報
	 * return id付きのOrderTopping
	 */
	public OrderTopping insert(OrderTopping orderTopping){
		SqlParameterSource param = new BeanPropertySqlParameterSource(orderTopping);
		
		Number key = insert.executeAndReturnKey(param);
		orderTopping.setId(key.intValue());
		System.out.println(key.intValue() + "が割り当てられました");
		return orderTopping;
	}
}
