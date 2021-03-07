package javaStudy;

import java.util.List;

public class Question
{
	private int questionId;
	private int questionType;
	List<String> correctAnswers;
	private String[] types = {
		"ノーマル", "ほのお", "みず", "でんき", "くさ", "こおり", "かくとう",
		"どく", "じめん", "ひこう", "エスパー", "むし", "いわ", "ゴースト",
		"ドラゴン", "あく", "はがね", "フェアリー"};

	public Question(int quizNumber, Integer type, List<String> correct)
	{
		this.questionId = quizNumber;
		this.questionType = type;
		this.correctAnswers = correct;
	}

	public void setQuestion()// 問題を表示する
	{
		System.out.print("第" + questionId + "問！　");
		System.out.println(types[questionType] + "タイプの弱点は次のうちどれ？");
		System.out.println(" 1.ノーマル  2.ほのお　  3.みず　　  4.でんき");
		System.out.println(" 5.くさ　　  6.こおり　  7.かくとう  8.どく");
		System.out.println(" 9.じめん　 10.ひこう　 11.エスパー 12.むし");
		System.out.println("13.いわ　　 14.ゴースト 15.ドラゴン 16.あく");
		System.out.println("17.はがね　 18.フェアリー");
		System.out.println("--------------------------------------------------");
	}

	public void confirmationAnswer(List<String> answerlist1)// 解答、正答の表示
	{
		List<String> answerlist = answerlist1;
		System.out.print("解答");
		for (String answer1 : answerlist)
		{
			System.out.print("[" + types[Integer.parseInt(answer1) - 1] + "]");
		}
		System.out.println("");
		System.out.print("正答");
		for (String correct1 : this.correctAnswers)
		{
			System.out.print("[" + types[Integer.parseInt(correct1) - 1] + "]");
		}
		System.out.println("");
	}

	public int checkAnswerGetGrade(List<String> answerlist1)// 解答、正答を比較し、正解なら１を返す
	{
		List<String> answerlist = answerlist1;
		if (answerlist.equals(this.correctAnswers))
		{
			System.out.println("正解！！");
			System.out.println("--------------------------------------------------");
			return 1;
		}
		else
		{
			System.out.println("不正解");
			System.out.println("--------------------------------------------------");
			return 0;
		}
	}

	public void printGrade(int quizgrade)// 正答数に応じた成績を表示する
	{
		System.out.println("成績発表！");
		System.out.println("全" + this.questionId + "問中、" + quizgrade + "問正解！");
		String[] grades = // 問題数10問の場合
			{"ポケモン初心者", "ポケモン初心者", "ポケモン初心者", "ポケモン中級者", "ポケモン中級者",
				"ポケモン上級者", "ポケモン上級者", "ポケモン上級者", "ポケモン上級者", "ポケモンマスター"};
		String grade = grades[quizgrade];
		System.out.println("あなたは" + grade + "！");
	}
}
