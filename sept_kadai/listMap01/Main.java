package listMap01;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Map<String, Object> m_question = new LinkedHashMap<String, Object>();

		m_question.put("QUESTION_ID", "010101001");
		m_question.put("QUESTION_LEVEL_ID", "01");
		m_question.put("QUESTION_CAT_ID", "01");
		m_question.put("QUESTION_SUB_CAT_ID", "01");
		m_question.put("QUESTION_SUB_CAT_NAME", "宣言とアクセス制御");
		m_question.put("INSERT_USER_ID", "CEVIA_001");
		m_question.put("INSERT_DATE", "2015-03-10 00:00:00.0");
		m_question.put("UPDATE_USER_ID", "CEVIA_001");
		m_question.put("UPDATE_DATE", "2015-03-10 00:00:00.0");
		m_question.put("DELETE_FLG", "0");

		//		for (Map.Entry<String, Object> param : m_question.entrySet()) {
		//			System.out.println(param.getKey());
		//			System.out.println(param.getValue());
		//		}

		System.out.println();

		// List, Mapは命名にも必ず入れるようにする

		Map<String, Object> m_question02 = new LinkedHashMap<String, Object>();

		m_question02.put("QUESTION_ID", "010101002");
		m_question02.put("QUESTION_LEVEL_ID", "01");
		m_question02.put("QUESTION_CAT_ID", "01");
		m_question02.put("QUESTION_SUB_CAT_ID", "01");
		m_question02.put("QUESTION_SUB_CAT_NAME", "宣言とアクセス制御");
		m_question02.put("INSERT_USER_ID", "CEVIA_001");
		m_question02.put("INSERT_DATE", "2015-03-10 00:00:00.0");
		m_question02.put("UPDATE_USER_ID", "CEVIA_001");
		m_question02.put("UPDATE_DATE", "2015-03-10 00:00:00.0");
		m_question02.put("DELETE_FLG", "0");

		List<Map<String, Object>> mQuestion = new ArrayList<>();
		mQuestion.add(m_question);
		mQuestion.add(m_question02);

		List<Question> questions = new ArrayList<>();

		for (Map<String, Object> map : mQuestion) {
			Question q = new Question();
			q.setQuestionId((String) map.get("QUESTION_ID"));
			q.setQuestionLevelId((String) map.get("QUESTION_LEVEL_ID"));
			q.setQuestionCatId((String) map.get("QUESTION_CAT_ID"));
			q.setQuestionSubCatId((String) map.get("QUESTION_SUB_CAT_ID"));
			q.setQuestionSubCatName((String) map.get("QUESTION_SUB_CAT_NAME"));
			q.setInsertUserId((String) map.get("INSERT_USER_ID"));
			q.setInsertDate((String) map.get("INSERT_DATE"));
			q.setUpdateUserId((String) map.get("UPDATE_USER_ID"));
			q.setUpdateDate((String) map.get("UPDATE_DATE"));
			q.setDeleteFlg((String) map.get("DELETE_FLG"));
			q.makeQueList();
			questions.add(q);
		}

		for (Question list : questions) {
			for (String list02 : list.a) {
				System.out.println(list02);
			}
			System.out.println();
		}

	}
}
