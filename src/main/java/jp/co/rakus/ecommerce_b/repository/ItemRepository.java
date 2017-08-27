package jp.co.rakus.ecommerce_b.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ecommerce_b.domain.Item;

/**
 * Item(商品)用リポジトリ.
 * @author ochi
 *
 */
@Repository
public class ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * Item(商品)ドメイン用RowMapper.
	 * @return Item(商品)
	 */
	private static final RowMapper<Item> itemRowMapper = (rs, i) -> {
		Item item = new Item();
		item.setId(rs.getLong("id"));
		item.setName(rs.getString("name"));
		item.setDescription(rs.getString("description"));
		item.setPriceM(rs.getInt("price_m"));
		item.setPriceL(rs.getInt("price_l"));
		item.setImagePath(rs.getString("image_path"));
		item.setDeleted(rs.getBoolean("deleted"));
		return item;
	};

	/**
	 * Item(商品)の全件検索.
	 * @return 検索結果のItem(商品)リスト
	 */
	public List<Item> findAll(){
		String sql = "select id, name, description, price_m, price_l, image_path, deleted from items order by id";

		List<Item> itemList = template.query(sql, itemRowMapper);

		return itemList;
	}

	/**
	 * Item(商品)の1件検索.
	 * orderItemとの紐付けで必要な為、八尋が作成しました.
	 * @param id itemのid
	 * @return　検索結果のItem(商品)
	 */
	public Item load(Integer id){
		String sql 
			= "select id, name, description, price_m, price_l, image_path, deleted from items where id = :id order by id;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		
		Item item = template.queryForObject(sql, param, itemRowMapper);
		
		return item;
	}
	
	/**
	 * Item(商品)の名前検索.
	 * @return 検索結果のItem(商品)リスト
	 */
	public List<Item> findByName(String name){
		String sql = "select id, name, description, price_m, price_l, image_path, deleted from items where name like :name order by id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%" + name + "%");
		
		List<Item> itemList = template.query(sql, param, itemRowMapper);
		
		return itemList;
	}
	
}