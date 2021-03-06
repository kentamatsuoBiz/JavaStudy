package javaStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JavaStudy {

	public static void main(String[] args) {
		// ランダムを使う、入力を受け付ける
		Random random = new Random();
		Scanner sc = new Scanner(System.in);

		// ルール説明分の表示
		System.out.println("ポケモンタイプ相性問題！");
		System.out.println("");
		System.out.println("番号をカンマで区切ってすべて入力してください");
		System.out.println("良い例：1,2,3　6,4,5　　悪い例：123　6 4 5");
		System.out.println("----------------------------------------------");

		// 問題繰り返し
		int quizCorrect = 0;
		int quizNumbers = 10;// 問題数※成績gradesに対応させること
		for (int quizNumber = 1; quizNumber <= quizNumbers; quizNumber++)
		{

			// 問題文、選択肢、正答の宣言
			String quiz = "タイプの弱点は次のうちどれ？";
			String choices0 = " 1.ノーマル  2.ほのお　  3.みず　　  4.でんき";
			String choices1 = " 5.くさ　　  6.こおり　  7.かくとう  8.どく";
			String choices2 = " 9.じめん　 10.ひこう　 11.エスパー 12.むし";
			String choices3 = "13.いわ　　 14.ゴースト 15.ドラゴン 16.あく";
			String choices4 = "17.はがね　 18.フェアリー";
			String[] types = {
				"ノーマル", "ほのお", "みず", "でんき", "くさ", "こおり", "かくとう",
				"どく", "じめん", "ひこう", "エスパー", "むし", "いわ", "ゴースト",
				"ドラゴン", "あく", "はがね", "フェアリー"
			};
			String[][] correctAnswer = {
				{"7"}, // 1.ノーマル_7.かくとう
				{"13", "3", "9"}, // 2.ほのお_3.みず9.じめん13.いわ
				{"4", "5"}, // 3.みず_4.でんき5.くさ
				{"9"}, // 4.でんき_9.じめん
				{"10", "12", "2", "6", "8"}, // 5.くさ_2.ほのお6.こおり8.どく10.ひこう12.むし
				{"13", "17", "2", "7"}, // 6.こおり_2.ほのお7.かくとう13.いわ17.はがね
				{"10", "11", "18"}, // 7.かくとう_10.ひこう11.エスパー18.フェアリー
				{"11", "9"}, // 8.どく_9.じめん11.エスパー
				{"3", "5", "6"}, // 9.じめん_3.みず5.くさ6.こおり
				{"13", "4", "6"}, // 10.ひこう_4.でんき6.こおり13.いわ
				{"12", "14", "16"}, // 11.エスパー_12.むし14.ゴースト16.あく
				{"10", "13", "2"}, // 12.むし_2.ほのお10.ひこう13.いわ
				{"17", "3", "5", "7", "9"}, // 13.いわ_3.みず5.くさ7.かくとう9.じめん17.はがね
				{"14", "16"}, // 14.ゴースト_14.ゴースト16.あく
				{"15", "18", "6"}, // 15.ドラゴン_6.こおり15.ドラゴン18.フェアリー
				{"12", "18", "7"}, // 16.あく_7.かくとう12.むし18.フェアリー
				{"2", "7", "9"}, // 17.はがね_2.ほのお7.かくとう9.じめん
				{"17", "8"} // 18.フェアリー_8.どく17.はがね
			};

			// 変数の宣言
			String type = null;
			ArrayList<String> correct = new ArrayList<String>();
			String answers = null;

			// 問題と正答をランダムに選択する
			int i = random.nextInt(types.length);
			type = types[i];
			for (int j = 0; j < correctAnswer[i].length; j++)
			{
				correct.add(correctAnswer[i][j]);
			}

			// 選択された問題を表示
			System.out.println("第" + quizNumber + "問！　" + type + quiz);
			System.out.println(choices0);
			System.out.println(choices1);
			System.out.println(choices2);
			System.out.println(choices3);
			System.out.println(choices4);

			// 解答を配列として格納、ソートし、Listに変換して比較できるようにする
			answers = sc.nextLine();
			String[] answer = answers.split(",");
			Arrays.sort(answer);
			List<String> answerlist = Arrays.asList(answer);

			// 入力が正しいか判断する※未実装
			/*
			 * ile (true) { if (answer[0].equals("1")||answer[0].equals("2")||answer[0].equals("3"))
			 * { break; } else { System.out.println("入力が正しく有りません");
			 * System.out.println("番号をカンマで区切ってすべて入力してください");
			 * System.out.println("良い例：1,2,3　6,3,5　　悪い例：123　6 3 5");
			 * System.out.println("----------------------------------------------"); } }
			 */

			// 解答と正答を表示
			System.out.print("解答");
			for (String answer1 : answerlist)
			{
				System.out.print("[" + types[Integer.parseInt(answer1) - 1] + "]");
			}
			System.out.println("");
			System.out.print("正答");
			for (String correct1 : correct)
			{
				System.out.print("[" + types[Integer.parseInt(correct1) - 1] + "]");
			}
			System.out.println("");

			// 出題した問題と正答をリストから削除※未実装
			/*
			 * List<String> typeslist = Arrays.asList(types); List<String[]> correctAnswerlist =
			 * Arrays.asList(correctAnswer); typeslist.remove("types[i]"); for(int j = 0; j <
			 * correctAnswer[i].length; j++) { correctAnswerlist.remove(correctAnswer[i][j]); }
			 */

			// 解答と正答を比べ、結果を表示する
			if (answerlist.equals(correct))
			{
				System.out.println("正解！！");
				System.out.println("----------------------------------------------");
				quizCorrect++;
			}
			else
			{
				System.out.println("不正解");
				System.out.println("----------------------------------------------");
			}
		}

		// 成績発表
		System.out.println("成績発表！");
		System.out.println("全" + quizNumbers + "問中、" + quizCorrect + "問正解！");
		String[] grades = // 問題数10問の場合
			{"ポケモン初心者", "ポケモン初心者", "ポケモン初心者", "ポケモン中級者", "ポケモン中級者",
				"ポケモン上級者", "ポケモン上級者", "ポケモン上級者", "ポケモン上級者", "ポケモンマスター"};
		String grade = grades[quizCorrect];
		System.out.println("あなたは" + grade + "！");

		sc.close();

	}

}
