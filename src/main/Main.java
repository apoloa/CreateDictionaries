package main;

import gui.Counter;

import java.io.File;

import saveFile.SaveFile;

public class Main {

	public static void main(String[] args) {
		Counter count = new Counter();
		count.start();
		SaveFile save = new SaveFile();

		File carpeta = new File("./dic/");
		for (String strFile : carpeta.list()) {
			ProcessorDic dic = new ProcessorDic(carpeta + "//" + strFile);
			System.out.println("Creando thread para diccionario" + strFile);
			dic.start();
		}

	}
}
