package listMap_kadai;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private String questionId;
	private String questionLevelId;
	private String questionCatId;
	private String questionSubCatId;
	private String questionSubCatName;
	private String insertUserId;
	private String insertDate;
	private String updateUserId;
	private String updateDate;
	private String deleteFlg;

	List<String> li;

	public Question() {
		li = new ArrayList<>();
	}

	void makeList() {
		li.add(questionId);
		li.add(questionLevelId);
		li.add(questionCatId);
		li.add(questionSubCatId);
		li.add(questionSubCatName);
		li.add(insertUserId);
		li.add(insertDate);
		li.add(updateUserId);
		li.add(updateDate);
		li.add(deleteFlg);
	}

	/**
	 * @return questionId
	 */
	public String getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId セットする questionId
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return questionLevelId
	 */
	public String getQuestionLevelId() {
		return questionLevelId;
	}

	/**
	 * @param questionLevelId セットする questionLevelId
	 */
	public void setQuestionLevelId(String questionLevelId) {
		this.questionLevelId = questionLevelId;
	}

	/**
	 * @return questionCatId
	 */
	public String getQuestionCatId() {
		return questionCatId;
	}

	/**
	 * @param questionCatId セットする questionCatId
	 */
	public void setQuestionCatId(String questionCatId) {
		this.questionCatId = questionCatId;
	}

	/**
	 * @return questionSubCatId
	 */
	public String getQuestionSubCatId() {
		return questionSubCatId;
	}

	/**
	 * @param questionSubCatId セットする questionSubCatId
	 */
	public void setQuestionSubCatId(String questionSubCatId) {
		this.questionSubCatId = questionSubCatId;
	}

	/**
	 * @return questionSubCatName
	 */
	public String getQuestionSubCatName() {
		return questionSubCatName;
	}

	/**
	 * @param questionSubCatName セットする questionSubCatName
	 */
	public void setQuestionSubCatName(String questionSubCatName) {
		this.questionSubCatName = questionSubCatName;
	}

	/**
	 * @return insertUserId
	 */
	public String getInsertUserId() {
		return insertUserId;
	}

	/**
	 * @param insertUserId セットする insertUserId
	 */
	public void setInsertUserId(String insertUserId) {
		this.insertUserId = insertUserId;
	}

	/**
	 * @return insertDate
	 */
	public String getInsertDate() {
		return insertDate;
	}

	/**
	 * @param insertDate セットする insertDate
	 */
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * @return updateUserId
	 */
	public String getUpdateUserId() {
		return updateUserId;
	}

	/**
	 * @param updateUserId セットする updateUserId
	 */
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * @return updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return deleteFlg
	 */
	public String getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * @param deleteFlg セットする deleteFlg
	 */
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

}
