package saveFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

import org.apache.commons.io.FileUtils;

public class SaveFile
{

	private static File dic3;
	private static File dic5;
	private static File dic6;
	private static File dic7;

	private static ArrayDeque<String> words3;
	private static ArrayDeque<String> words5;
	private static ArrayDeque<String> words6;
	private static ArrayDeque<String> words7;

	public SaveFile()
	{
		words3 = new ArrayDeque<String>();
		words5 = new ArrayDeque<String>();
		words6 = new ArrayDeque<String>();
		words7 = new ArrayDeque<String>();

		dic3 = new File("dic3.txt");
		if (!dic3.exists())
		{
			try
			{
				FileUtils.touch(dic3);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dic5 = new File("dic5.txt");
		if (!dic5.exists())
		{
			try
			{
				FileUtils.touch(dic5);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dic6 = new File("dic6.txt");
		if (!dic6.exists())
		{
			try
			{
				FileUtils.touch(dic6);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dic7 = new File("dic7.txt");
		if (!dic7.exists())
		{
			try
			{
				FileUtils.touch(dic7);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static synchronized void Save3Words(String text)
	{

		if (!words3.contains(text))
		{
			words3.add(text);
			try
			{
				FileUtils.writeStringToFile(dic3, text + "\n", true);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static synchronized void Save5Words(String text)
	{
		if (!words5.contains(text))
		{
			words5.add(text);
			try
			{
				FileUtils.writeStringToFile(dic5, text + "\n", true);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static synchronized void Save6Words(String text)
	{
		if (!words6.contains(text))
		{
			words6.add(text);
			try
			{
				FileUtils.writeStringToFile(dic6, text + "\n", true);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static synchronized void Save7Words(String text)
	{
		if (!words7.contains(text))
		{
			words7.add(text);
			try
			{
				FileUtils.writeStringToFile(dic7, text + "\n", true);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
