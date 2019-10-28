package listMap_kadai;

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

		//		for (String key : m_question.keySet()) {
		//			String value = (String) m_question.get(key);
		//			System.out.println(key + "：" + value);
		//		}

		for (Map.Entry<String, Object> param : m_question.entrySet()) {
			System.out.print(param.getKey() + " : ");
			System.out.println(param.getValue());
		}

		System.out.println();

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

		//		for (Map.Entry<String, Object> param1 : m_question02.entrySet()) {
		//			System.out.print(param1.getKey() + " : ");
		//			System.out.println(param1.getValue());
		//		}

		List<Map<String, Object>> list01 = new ArrayList<>();
		list01.add(m_question);
		list01.add(m_question02);

		List<Question> question01 = new ArrayList<>();

		for (Map<String, Object> map : list01) {
			Question que = new Question();
			que.setQuestionId((String) map.get("QUESTION_ID"));
			que.setQuestionLevelId((String) map.get("QUESTION_LEVEL_ID"));
			que.setQuestionCatId((String) map.get("QUESTION_CAT_ID"));
			que.setQuestionSubCatId((String) map.get("QUESTION_SUB_CAT_ID"));
			que.setQuestionSubCatName((String) map.get("QUESTION_SUB_CAT_NAME"));
			que.setInsertUserId((String) map.get("INSERT_USER_ID"));
			que.setInsertDate((String) map.get("INSERT_DATE"));
			que.setUpdateUserId((String) map.get("UPDATE_USER_ID"));
			que.setUpdateDate((String) map.get("UPDATE_DATE"));
			que.setDeleteFlg((String) map.get("DELETE_FLG"));
			que.makeList();
			question01.add(que);
		}

		for (Question list : question01) {
			for (String list02 : list.li) {
				System.out.println(list02);
			}
			System.out.println();
		}
	}
}
