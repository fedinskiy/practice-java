package ru.fedinskiy.resources;


import ru.fedinskiy.exceptions.IllegalSymbolsException;
import ru.fedinskiy.exceptions.ResourceTooLargeException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fedinskiy on 06.02.17.
 */
public abstract class ResourceContent {
	private String resourceName;
	private ArrayList<Integer> numberArray;
	
	protected ResourceContent(String resourceName) {
		this.resourceName = resourceName;
		this.numberArray = new ArrayList<>();
	}
	
	protected void prepareStore(long dataSize) throws ResourceTooLargeException {
		final int MAX_WORD_TO_SIZE_RATIO = 2;
		if ((dataSize / MAX_WORD_TO_SIZE_RATIO) > Integer.MAX_VALUE) {
			throw new ResourceTooLargeException("Ресурс  слишком велик!");
		}
		this.numberArray = new ArrayList<Integer>(
				(int) (dataSize / MAX_WORD_TO_SIZE_RATIO));
	}
	public synchronized void addLine(String line) throws IllegalSymbolsException {
		addLineToArray(line);
	}
	protected void addLineToArray(String line) throws IllegalSymbolsException {
		final String SPACES = "[\\s]";
		String word;
		
		String[] lineContent;
		if (line.isEmpty()) {
			return;
		}
	
		if (!isStringContainsAcceptableSymbolsOnly(line)) {
			throw new IllegalSymbolsException(line, resourceName);
		}
		lineContent = line.split(SPACES);
		for (String stringPiece : lineContent) {
			word=stringPiece;
//			word = cleanWord(stringPiece);
			if (!word.isEmpty()) {
				numberArray.add(Integer.valueOf(word));
			}
		}
	}
	protected void read(BufferedReader in)
			throws IOException, IllegalSymbolsException {
		String line;
		if (null == numberArray) {
			numberArray = new ArrayList<>();
		}
		
		line = in.readLine();
		while (null != line) {
			addLineToArray(line);
			line = in.readLine();
		}
		numberArray.trimToSize();
	}
	public synchronized void addNumber(String number){
		numberArray.add(Integer.valueOf(number));
	}
//	public synchronized void addWord(String word){
//		numberArray.add(word);
//	}
//	private String cleanWord(String stringPiece) {
//		final String NOT_WORD = "[^\\p{IsAlphabetic}-]+";
//
//		return stringPiece.replaceAll(NOT_WORD, "");
//	}
	
	public List getAllNumbers(){
		return this.numberArray;
	}
	
//	/**
//	 * @param store
//	 * @throws WordAlreadyAddedException
//	 * @implSpec Проверяет все слова, прочитанные из ресурса,
//	 * на наличие в данном хранилище.
//	 */
//	public boolean addNewWordsToStore(WordsStore store) throws WordAlreadyAddedException {
//		for (String word : this.numberArray) {
//			System.out.println("пишем слово " + word + " из источника " + this
//					.resourceName);
//
//			if (!store.addNewWord(word))
//				break;
//		}
//		return !store.isHasDoubles();
//	}
	private boolean isNumber(String pieceForCheck) {
		
		System.out.println("Обработка строки " + pieceForCheck);
		final String ALLOWED_SYMBOLS = "[\\-]?[0-9]*";
		return pieceForCheck.matches(ALLOWED_SYMBOLS);
	}
	private boolean isStringContainsAcceptableSymbolsOnly(String wordForCheck) {
		final String ALLOWED_SYMBOLS = "[А-Яа-яЁё0-9\\s\\d,.\\--—?!№%\":*();" +
				"\\[\\]]*";
		
		System.out.println("Обработка строки " + wordForCheck);
		return wordForCheck.matches(ALLOWED_SYMBOLS);
	}
	
	public int getSize() {
		return numberArray.size();
	}
}
