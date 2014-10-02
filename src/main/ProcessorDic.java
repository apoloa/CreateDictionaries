package main;

import gui.Counter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

import saveFile.SaveFile;

public class ProcessorDic extends Thread
{

	private File file;
	private ArrayDeque<Character> passDic;
	private ArrayDeque<Character> passDic3;

	public ProcessorDic(String path)
	{
		file = new File(path);
		int i = 0;
		try
		{

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			// Lectura del fichero

			while ((br.readLine()) != null)
			{
				i++;
			}
			br.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Invocando Contador");
		Counter.addMax(i);
		passDic = new ArrayDeque<Character>();
		List<Character> list = Arrays.asList(new Character[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
				'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z' });
		passDic.addAll(list);

		passDic3 = new ArrayDeque<Character>();
		List<Character> list3 = Arrays.asList(new Character[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
				'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ':', '.', ';',
				',', '_', '+', '<', '>', '?', '=', '(', ')', '/', '%', '#', '0', '1', '2', '3',
				'4', '5', '6', '7', '8', '9' });
		passDic.addAll(list3);

	}

	private boolean comprobarDic(String text)
	{
		char[] textChar = text.toCharArray();
		for (char element : textChar)
		{
			if (!passDic.contains(element))
			{
				return false;
			}
		}

		return true;
	}

	private boolean comprobarDic3(String text)
	{
		char[] textChar = text.toCharArray();
		for (char element : textChar)
		{
			if (!passDic.contains(element))
			{
				return false;
			}
		}

		return true;
	}

	@Override
	public void run()
	{

		FileReader fr = null;
		try
		{
			fr = new FileReader(file);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		// Lectura del fichero
		String palabra;
		try
		{
			while ((palabra = br.readLine()) != null)
			{
				Counter.count();
				switch (palabra.trim().length())
				{
				case 3:
					if (comprobarDic3(palabra.trim()))
					{
						SaveFile.Save3Words(palabra.trim());
					}

					break;
				case 5:
					String textformated = palabra.toLowerCase().replace("/t", " ").trim();
					if (comprobarDic(textformated))
					{
						SaveFile.Save5Words(textformated);
					}

					break;
				case 6:
					String text2 = palabra.toLowerCase().replace("/t", " ").trim();
					if (comprobarDic(text2))
					{
						SaveFile.Save6Words(text2);
					}
					break;
				case 7:
					String text3 = palabra.toLowerCase().replace("/t", " ").trim();
					if (comprobarDic(text3))
					{
						SaveFile.Save7Words(text3);
					}
					break;
				}
			}
			br.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
