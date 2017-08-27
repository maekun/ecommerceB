package jp.co.rakus.ecommerce_b.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.controller.form.UserForm;
import jp.co.rakus.ecommerce_b.domain.User;
import jp.co.rakus.ecommerce_b.service.UserRegisterService;

/**
 * ユーザ登録をするコントローラクラス.
 * 
 * @author hiroki.mae
 *
 */
@Controller
@RequestMapping("/")
public class UserRegisterController {

	@ModelAttribute
	public UserForm setUpUserForm() {
		return new UserForm();
	}

	@Autowired
	private UserRegisterService userRegisterService;
	// TODO:@BeanでAutowiredできる様にSecurityConfig書き直す
	private StandardPasswordEncoder encoder = new StandardPasswordEncoder();

	/**
	 * 新規ユーザ登録フォームへ遷移.
	 * 
	 * @return 新規登録画面
	 */
	@RequestMapping("/")
	public String toRegisterForm() {

		return "user/user_register";
	}

	/**
	 * 新規ユーザ登録をする.
	 * 
	 * @return ログイン画面
	 */
	@RequestMapping("/register")
	public String register(@Validated UserForm form, BindingResult result) {

		if (result.hasErrors()) {
			return toRegisterForm();
		}

		// 入力されたパスワードと確認用パスワードが合致するか判定
		String password = form.getPassword();
		String confirmationPassword = form.getConfirmationPassword();
		String encodedPassword = encoder.encode(password);

		if (!(password.equals(confirmationPassword))) {
			result.rejectValue("password", null, "パスワードと確認用パスワードが合致しません");
			return toRegisterForm();
		}
		User user = userRegisterService.loadByEmail(form.getEmail());
		if (user != null) {
			result.rejectValue("email", null, "そのメールアドレスはすでに使われています");
			return toRegisterForm();
		}

		User newUser = new User();
		BeanUtils.copyProperties(form, newUser);
		newUser.setPassword(encodedPassword);

		userRegisterService.save(newUser);
		
		return "redirect:/loginform";
	}
}
