package com.kafka.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import com.kafka.model.Employee;

public class Coding {

	public static void main(String[] args) {

		Coding c = new Coding();

		c.general();
		c.employee();
		c.dsa();

	}

	private void general() {

		String str = "Tarun";
		List<String> strList = new ArrayList<>(List.of("Tarun", "jk", "Sourav", "Dilu", "Jk"));
		List<Integer> num = new ArrayList<>(List.of(1, 2, 3, 1, 5, 3));

		// Reverse String
		String reversed = "";
		for (int c = str.length() - 1; c >= 0; c--) {
			reversed += str.charAt(c);
		}

		String reverse = new StringBuilder(str).reverse().toString();

		// Occurrence

		// Integer
		Map<Integer, Integer> intMap = new HashMap<>();
		for (int n : num) {
			intMap.put(n, intMap.getOrDefault(n, 0) + 1);
		}
		Map<Integer, Long> inteMap = num.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));

		// String
		Map<String, Integer> strMap = new HashMap<>();
		for (String c : strList) {
			strMap.put(c, strMap.getOrDefault(c, 0) + 1);
		}
		Map<String, Long> stringMap = strList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		// Find the duplicate

		// Integer
		List<Integer> number = new ArrayList<>(List.of(1, 2, 3, 1, 5));
		Set<Integer> seen = new HashSet<>(number);
		List<Integer> dup = new ArrayList<>();

		num.forEach(e -> {
			if (!seen.add(e))
				dup.add(e);
		});

		List<Integer> dupl = num.stream().filter(e -> !seen.add(e)).collect(Collectors.toList());

		// Even odd

		List<Integer> even = new ArrayList<>();
		List<Integer> odd = new ArrayList<>();

		num.forEach(e -> {
			if (e % 2 == 0) {
				even.add(e);
			} else
				odd.add(e);
		});

		// Running Sum
		int sum = 0;
		List<Integer> runSum = new ArrayList<>();
		for (int i : num) {
			sum += i;
			runSum.add(sum);
		}
		// Total sum of elements in array/list
		int total = num.stream().mapToInt(e -> e).sum();

		// join coma separated

		String names = strList.stream().collect(Collectors.joining(", "));

		// Format element in List of String eg. all the strating letter of string list

		List<String> strings = strList.stream().map(s -> s.substring(0)).collect(Collectors.toList());

		String string = strList.stream().map(e -> e.substring(0)).collect(Collectors.joining());

		// Sort

		List<String> sortedStr = strList.stream().sorted().collect(Collectors.toList());
		List<Integer> sortedInt = num.stream().sorted().collect(Collectors.toList());

		strList.sort(null); // uses list instance method changes the existng

		Collections.sort(strList); // changes the existing

		// Grouping
		Map<Character, List<String>> charMap = strList.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));

		// factor
		int fac = 2;
		List<Integer> factor = new ArrayList<>();
		num.forEach(e -> factor.add(e * fac));

		List<Integer> factorStrm = num.stream().map(e -> e * fac).collect(Collectors.toList());
	}

	private void employee() {

		List<Employee> empList = new ArrayList<>(List.of(new Employee("Tarun", "IT", 10), new Employee("JK", "IT", 12),
				new Employee("Dugu", "BPO", 15), new Employee("Dilu", "HR", 11)));

		// Find top two heights paid employee

		List<Employee> emp = empList.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2)
				.collect(Collectors.toList());

		// Find Max in for each department
		Map<String, Employee> maxEmp = empList
				.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)), Optional::get)));

		// Find the avg salary each Department
		// employee key
		Map<Employee, Double> result = empList.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.averagingDouble(Employee::getSalary)));

		// Dept key
		Map<String, Double> avgSalary = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));

		// Sort by Two Field e.g - first on basis of salary then employee name

		List<Employee> maxEmpSort = empList.stream()
				.sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName))
				.collect(Collectors.toList());

		// Find the employee whose name starts with T
		List<Employee> nme = empList.stream()
				.filter(e -> e.getName().startsWith("T")).collect(Collectors.toList());

	}

	private boolean dsa() {

		// Valid Parenthesis basic

		String s = "({[]})";

		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					;
				// return false;

				char top = stack.pop();

				if ((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '['))
					return false;
			}

		}

		// XOR basic

		int resut = 0;
		List<Integer> num = new ArrayList<>(List.of(-1, -2, -3, 1, 3));
		int nonRepeting = 0;
		for (int n : num) {
			nonRepeting ^= n;
		}

		// xor custom

		Map<Integer, Long> freq = num.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));

		List<Integer> nonRepeating = freq.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey)
				.collect(Collectors.toList());

		// Sliding window basic

		// Flat-map basic

		return stack.isEmpty();
	}

}
