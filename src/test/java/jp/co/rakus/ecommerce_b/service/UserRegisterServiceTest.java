package jp.co.rakus.ecommerce_b.service;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.rakus.ecommerce_b.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegisterServiceTest {
	
	@Autowired
	private UserRegisterService userRegisterService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		User user = new User("test太郎","test@gmail.com","testpass","address","1234567890");
		userRegisterService.save(user);
	}

	@After
	public void tearDown() throws Exception {
		userRegisterService.deleteByEmail("test@gmail.com");
	}

	@Test
	public void ユーザを未登録のメールアドレスで一件検索したらnullが返ってくること() {
		//Integer save(User user) {
		User user = userRegisterService.loadByEmail("fails@gmail.com");
		assertThat("TC1:", user,nullValue());
	}
	
	@Test
	public void 新規登録がUsersテーブルにしっかり反映されること() {
		//Integer save(User user) {
		User user = userRegisterService.loadByEmail("test@gmail.com");
		assertThat("TC2:新規登録が失敗しています", user.getName(),is("test太郎"));
	}
	
}
