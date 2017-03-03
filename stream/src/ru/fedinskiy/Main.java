package ru.fedinskiy;

import ru.fedinskiy.exceptions.IllegalSymbolsException;
import ru.fedinskiy.exceptions.WrongResourceException;
import ru.fedinskiy.resources.ResourceContentFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) {
		/**
		 * 1)читаем ресурс
		 * 2) вытаскиваем числа
		 * 3) прибавляем
		 *
		 */
		final int size = args.length;
		
		final ExecutorService executorService = Executors.newFixedThreadPool(size);
		final Predicate<Number> isPositive = (Number n) -> (n.longValue() > 0);
		final Predicate<Number> isEven = (Number n) -> (n.longValue() % 2 == 0);
		final ToIntFunction<Integer> toInteger = Integer::valueOf;
		final ArrayList<Future<List<Integer>>> results = new ArrayList<>(size);
		
		
		for (int i = 0; i < size; i++) {
			String path = args[i];
			results.add(executorService.submit(new Callable<List<Integer>>() {
				@Override
				public List call() throws Exception {
					return ResourceContentFactory.createChecker(path).getAllNumbers();
				}
			}));
		}
		
		
		int summ = 0;
		for (int i = 0; i < size; i++) {
			try {
				Collector<? super Integer, ? extends Object, ? extends Object> summator;
				final IntSummaryStatistics collect = (IntSummaryStatistics) results.get(i).get().stream().filter
						(isPositive).filter(isEven).collect(Collectors.summarizingInt(toInteger));
				summ += collect.getSum();
				System.out.println(summ);
			} catch (WrongResourceException e) {
				e.printStackTrace();
			} catch (IllegalSymbolsException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Total "+summ);
		executorService.shutdown();
	}
}
