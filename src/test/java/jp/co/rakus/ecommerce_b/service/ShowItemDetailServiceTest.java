package jp.co.rakus.ecommerce_b.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.rakus.ecommerce_b.domain.Item;
import jp.co.rakus.ecommerce_b.domain.Topping;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowItemDetailServiceTest {

	@Autowired
	ShowItemDetailService showItemDetailService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void すべての記事情報をIDの降順で取得していること() {
		Item item=showItemDetailService.execute(1);
		/** 指定したIDで検索した情報が正しいかのテスト*/
		assertThat("商品名が違います。", item.getName(), is("じゃがバターベーコン"));
		item=showItemDetailService.execute(2);
		assertThat("商品名が違います。", item.getName(), is("アスパラ・ミート"));
		item=showItemDetailService.execute(3);
		assertThat("商品名が違います。", item.getName(), is("熟成ベーコンとマッシュルーム"));
		item=showItemDetailService.execute(18);
		assertThat("商品名が違います。", item.getName(), is("贅沢フォルマッジ"));
		
		/** 全件検索のテスト */
		assertThat("findAll()メソッドが正しく機能していません", item.getToppingList().size(), is(28));
	}

}
