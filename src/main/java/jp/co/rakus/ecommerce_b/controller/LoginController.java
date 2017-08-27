package jp.co.rakus.ecommerce_b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ecommerce_b.controller.form.LoginUserForm;

/**
 * ログインフォーム画面のコントローラクラス.
 * @author hiroki.mae
 *
 */
@Controller
@RequestMapping("/loginform")
public class LoginController {
	
	@ModelAttribute
	public LoginUserForm setUpLoginUserForm(){
		return new LoginUserForm();
	}

	/**
	 * ログインフォームへ遷移.
	 * 
	 * @return ログイン画面
	 */
	@RequestMapping("")
	public String toLoginForm(String error,Model model) {
		if("true".equals(error)){
			model.addAttribute("loginErrorMessage", "メールアドレス、またはパスワードが間違っています");
		}
		return "user/loginform";
	}
}
