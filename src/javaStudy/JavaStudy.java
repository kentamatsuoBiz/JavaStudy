package javaStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaStudy {

	public static void main(String[] args) {
		// 入力を受け付ける
		Scanner sc = new Scanner(System.in);

		while (true)
		{
			// 問題数※Question.javaの成績gradesに対応させること
			int quizNumbers = 10;
			// 正答数
			int quizgrade = 0;

			// ルール説明分の表示
			System.out.println("ポケモンタイプ相性問題！全" + quizNumbers + "問！");
			System.out.println("");
			System.out.println("番号をカンマで区切り、すべて入力してください");
			System.out.println("良い例：1,2,3　6,4,5　7　 悪い例：123　6 4 5　７");
			System.out.println("--------------------------------------------------");

			// 問題と正答をランダムな順序にする
			List<Integer> questionNumber = new ArrayList<>(Arrays.asList//
			(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17));
			Collections.shuffle(questionNumber);

			// 問題繰り返し
			for (int quizNumber = 1; quizNumber <= quizNumbers; quizNumber++)
			{
				// 正答の宣言
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

				// 第[quizNumber]問に合わせて問題を選択する

				ArrayList<String> correct = new ArrayList<String>();
				for (int j = 0; j < correctAnswer[questionNumber.get(quizNumber - 1)].length; j++)
				{
					correct.add(correctAnswer[questionNumber.get(quizNumber - 1)][j]);
				}

				// 問題を宣言、表示
				Question question1 = new Question(quizNumber, questionNumber.get(quizNumber - 1),
					correct);
				question1.setQuestion();

				// デバック用
				// System.out.println("-----------------デバック用に表示-----------------");
				// System.out.println("出題順序" + questionNumber);// 順序の表示
				// System.out.println("問題番号[" + questionNumber.get(quizNumber - 1) + "]");// 問題の番号
				// System.out.println("正答" + correct);// 正答の表示
				// System.out.println("--------------------------------------------------");

				// 解答を配列として格納、ソートし、Listに変換して比較できるようにする
				String answers = sc.nextLine();
				String[] answer = answers.split(",");
				Arrays.sort(answer);
				List<String> answerlist = Arrays.asList(answer);

				// 解答と正答を表示
				question1.confirmationAnswer(answerlist);
				// 解答と正答を比較した結果を表示し、正答数を取得する
				quizgrade = quizgrade + question1.checkAnswerGetGrade(answerlist);

				// 成績発表
				if (quizNumber == 10)
				{
					question1.printGrade(quizgrade);
				}
			}
			System.out.println("");
			System.out.println("もう一度挑戦・・・[y]を入力");
			System.out.println("終了・・・・・・・[n]を入力");
			System.out.println("--------------------------------------------------");
			String answer = sc.nextLine();
			if (answer.equals("y"))
			{
				continue;
			}
			else
			{
				sc.close();
				break;
			}
		}
	}
}
