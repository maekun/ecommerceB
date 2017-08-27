package jp.co.rakus.ecommerce_b.controller.form;

import java.util.ArrayList;
import java.util.List;

/**
 * トップ画面のピザ検索用フォーム.
 * @author ochi
 *
 */
public class SearchForm {
	/** 検索ワード */
	private String searchWord;

	/**
	 * 検索フォームに入れられた文字列を単語毎に分ける.
	 * @return 検索単語リスト
	 */
	public List<String> getSearchWordList(){
		String[] words1 = searchWord.split("　");

		List<String> searchWordList = new ArrayList<>();

		for (String words2 : words1) {
			String[] result = words2.split(" ");
			for (String word : result) {
				searchWordList.add(word);
			}
		}

		return searchWordList;
		
	}
	
	/** 以降getter/setter */
	
	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

}
