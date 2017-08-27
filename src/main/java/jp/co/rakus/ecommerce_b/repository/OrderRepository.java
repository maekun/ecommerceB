package jp.co.rakus.ecommerce_b.repository;

import static org.mockito.Matchers.longThat;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.Order;

/**
 * オーダー処理のリポジトリ
 * 
 * @author yuta.honma
 *
 */
@Repository
public class OrderRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	//////自動採番されたid取得に必要
	private SimpleJdbcInsert insert;
	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("orders");
		insert = withTableName.usingGeneratedKeyColumns("id");
	}
	//////
	
	@Autowired
	private static final RowMapper<Order> orderRowMapper = (rs, i) -> {
		long id = rs.getLong("id");
		long userId = rs.getLong("user_id");
		Integer status = rs.getInt("status");
		Integer totalPrice = rs.getInt("total_price");
		Date orderDate = rs.getDate("order_date");
		String destinationName = rs.getString("destination_name");
		String destinationEmail = rs.getString("destination_email");
		String destinationZipcode = rs.getString("destination_zipcode");
		String destinationAddress = rs.getString("destination_address");
		String destinationTel = rs.getString("destination_tel");
		Timestamp deliveryTime = rs.getTimestamp("delivery_time");
		Integer paymentethod = rs.getInt("payment_method");
		return new Order(id, userId, status, totalPrice, orderDate, destinationName, destinationEmail,
				destinationZipcode, destinationAddress, destinationTel, deliveryTime, paymentethod);
	};

	/**
	 * 最初にカートに追加された際に作られるオーダー
	 * 
	 * @param order
	 *            オーダー
	 * @return id付きのオーダー
	 */
	public Order firstInsertItem(Order order) {
		String sql = "insert into orders (user_id, status,total_price) values (:userId,:status,:totalPrice);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(order);

//		本当は自動採番を更新時に一緒に持ちかえりたい
//		// insertしidも持ってくる
//		Number key = insert.executeAndReturnKey(param);
//		System.out.println("OrderRepository:" + key.intValue() + "が割り当てられました");
//		order.setId(key.intValue());

		template.update(sql, param);
		Long userId = order.getUserId();
		
		//TODO:前：ここでnullが返ってきたらInsert失敗してる
		Integer id = findIdByUserIdAndStatus(userId);
		Long longId = Long.parseLong(id.toString());
		order.setId(longId);

		return order;

	}
	
	/**
	 * UserIdを受け取ってステータスが0のカートを検索.
	 * @param userId userId
	 * @return オーダーid。なければnull
	 */
	public Integer findIdByUserIdAndStatus(Long userId){
		String sql = "select id from orders where user_id = :userId and status = 0;";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("userId", userId);
		try {
			Integer id = template.queryForObject(sql, paramMap, Integer.class);
			return id;
			
		} catch (DataAccessException e) {
			System.err.println("OrderRepositoryでステータス0のオーダーが見つかりませんでした");
			return null;
		}
	}

	// public void FirstInsertItem(Order order){
	// String sql = "insert into orders (user_id, status,total_price) values
	// (:user_id, 0, :total_price)";
	// SqlParameterSource param = new BeanPropertySqlParameterSource(order);
	// template.update(sql, param);
	// }
	
	//	public void updateAddItem(Order order) {
	//		String sql = "";
	//
	//	}

	/**
	 * ユーザidでオーダーを一件検索.
	 * 
	 * @param userId
	 * @return 検索結果
	 */
	public Order loadByUserId(Integer userId) {
		String sql = "select id,user_id,status,total_price,order_date,destination_name,destination_email,destination_zipcode,destination_address,destination_tel,delivery_time,payment_method from orders where user_id = :userId and status = 0;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		Order order = template.queryForObject(sql, param, orderRowMapper);
		return order;
	}
	/**
	 * idでオーダーを主キー検索.
	 * 
	 * @param id オーダーid
	 * @return 検索結果
	 */
	public Order loadById(Integer id) {
		String sql = "select id,user_id,status,total_price,order_date,destination_name,destination_email,destination_zipcode,destination_address,destination_tel,delivery_time,payment_method from orders where id = :id and status = 0;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Order order = template.queryForObject(sql, param, orderRowMapper);
		return order;
	}
	
	/**
	 * オーダーを全件削除.
	 */
	public void deleteAll() {
		String sql = "DELETE FROM orders ; ";
		SqlParameterSource param = new MapSqlParameterSource();
		template.update(sql, param);
	}
	

}
