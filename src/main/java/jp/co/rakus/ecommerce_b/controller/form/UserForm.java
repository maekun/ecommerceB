package jp.co.rakus.ecommerce_b.controller.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * ユーザを表すフォームクラス.
 * @author hiroki.mae
 *
 */
//FIXME:バリデーション付ける
public class UserForm {
	
	/** ユーザID*/
	private String id;
	
	/** ユーザ氏名*/
	@NotBlank(message="名前を入力してください")
	@Size(message="名前が長すぎます", max= 16)
//	@Min(message="名前が短すぎます", value = 2)
//	@Max(message="名前が長すぎます", value > 16)
	private String name;
	
	/** メールアドレス*/
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="アドレスが不正です")
	private String email;
	
	/** パスワード*/
//	@NotBlank(message="パスワードを入力してください")
	@Size(min = 8,max = 16,message="半角英数8~16文字以内で入力してください")
	@Pattern(regexp="[a-zA-Z0-9]*",message="半角英数8~16文字以内で入力してください")
	private String password;
	
	/** 確認用パスワード*/
//	@NotBlank(message="確認用パスワードを入力してください")
	@Size(min = 8,max = 16,message="半角英数8~16文字以内で入力してください")
	@Pattern(regexp="[a-zA-Z0-9]*",message="半角英数8~16文字以内で入力してください")
	private String confirmationPassword;
	
	/** 住所*/
	@NotBlank(message="住所を入力してください")
	private String address;
	
	//TODO:ハイフン入力されても無視して数字だけ抽出する
	/** 電話番号*/
//	@NotBlank(message="電話番号を入力してください")
	@Pattern(regexp="[0-9]*",message="電話番号を入力してください")
	@Size(min = 10,max = 11,message="電話番号をハイフンなしで入力してください")
	private String telephone;
	
	
	public Long getLongId() {
		return Long.parseLong(this.id);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getConfirmationPassword() {
		return confirmationPassword;
	}
	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}
	
	
}