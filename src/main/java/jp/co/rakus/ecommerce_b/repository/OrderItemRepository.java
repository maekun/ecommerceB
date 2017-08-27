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

import jp.co.rakus.ecommerce_b.domain.OrderItem;

/**
 * OrderItemREpositoryの作成
 * @author akihiko.yahiro
 *
 */
@Repository
public class OrderItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	//////自動採番されたid取得に必要
	private SimpleJdbcInsert insert;
	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("order_items");
		insert = withTableName.usingGeneratedKeyColumns("id");
	}
	//////

	@Autowired
	private static final RowMapper<OrderItem> orderItemRowMappar = (rs, i) -> {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(rs.getLong("id"));
		orderItem.setItemId(rs.getLong("item_id"));
		orderItem.setOrderId(rs.getLong("order_id"));
		orderItem.setQuantity(rs.getInt("quantity"));
		/**一度String型でもってきて、Char型に変換しました。*/
		String str = rs.getString("size");
        char size = str.charAt(0);
		orderItem.setSize(size);
		return orderItem;
	};

	/**
	 * ショッピングカート内に記載する商品一覧のリスト
	 * @return　全件検索済みのリスト
	 */
	public List<OrderItem> findAll() {
		String sql = "SELECT id, item_id, order_id, quantity, size from order_items ORDER BY id;";
		List<OrderItem> orderItemList = template.query(sql, orderItemRowMappar);
		return orderItemList;
	}
	
	/**
	 * 引数idで指定された注文商品を、ショッピングカートから削除するメソッド
	 * @param id　削除したい注文商品
	 */
	public void delete(Integer id) {
		String sql = "DELETE FROM order_items WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource("id", id);
		template.update(sql, param);
	}
	
	/**
	 * カートに入ったピザの詳細を一件追加する.
	 * @param item 注文が入ったピザ
	 * @return 注文id付きピザ
	 */
	public OrderItem insert(OrderItem item){
//		String sql = "insert into order_items (item_id,order_id,quantity,size) values (:item_id,:order_id,:quantity,:size);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		
		Number key = insert.executeAndReturnKey(param);
		item.setLongId(key.intValue());
		System.out.println("OrderItemRepository:" + key.intValue() + "が割り当てられました");
		return item;
	}
	/**
	 * idで主キー検索
	 * @param id id
	 * @return トッピング付きピザ
	 */
	public OrderItem load(Integer id) {
		String sql = "select id,item_id,order_id,quantity,size from order_items where id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		OrderItem orderItem = template.queryForObject(sql, param, orderItemRowMappar);
		return orderItem;

	}
	/**
	 * テスト用<br>
	 * itemidで一件検索
	 * @param itemId itemId
	 * @return トッピング付きピザ
	 */
	public OrderItem loadByItemId(Integer itemId) {
		String sql = "select id,item_id,order_id,quantity,size from order_items where item_id = :itemId;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("itemId", itemId);
		OrderItem orderItem = template.queryForObject(sql, param, orderItemRowMappar);
		return orderItem;
		
	}
	/**
	 * 注文のピザを全件削除.
	 */
	public void deleteAll() {
		String sql = "DELETE FROM order_items ; ";
		SqlParameterSource param = new MapSqlParameterSource();
		template.update(sql, param);
	}
	
}
