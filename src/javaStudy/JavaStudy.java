package javaStudy;

import java.util.Random;
import java.util.Scanner;

public class JavaStudy
{
	public static void main(String[] args)
	{
		// ランダムを使う、入力を受け付ける
		Random random = new Random();
		Scanner sc = new Scanner(System.in);

		// 問題文、選択肢、正答、回答の宣言
		System.out.println("ポケモンタイプ相性問題！");
		String quiz = "タイプの弱点は次のうちどれ？番号を入力してください";
		String choices = "1.草 2.炎 3.水";
		String[] types = {"草", "炎", "水"};
		String[] correctAnswer = {"2", "3", "1"};
		String type = null;
		String correct = null;
		String answer = null;

		// 問題をランダムに選択する
		int i = random.nextInt(types.length);
		type = types[i];
		correct = correctAnswer[i];

		// 選択された問題を表示
		System.out.println(type + quiz);
		System.out.println(choices);

		// 選択肢に沿った解答を受け取る
		while (true)
		{
			answer = sc.next();
			if (answer.equals("1") || answer.equals("2") || answer.equals("3"))
			{
				break;
			}
			else
			{
				System.out.println("正しく入力してください");
			}
		}

		// 解答と正答を比べ、結果を表示する
		if (answer.equals(correct))
		{
			System.out.println("正解！！");
		}
		else
		{
			System.out.println("不正解");
		}
		sc.close();
	}
}
