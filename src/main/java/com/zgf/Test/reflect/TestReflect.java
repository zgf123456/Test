package com.zgf.Test.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.zgf.Test.reflect.model.Chinese;
import com.zgf.Test.reflect.model.Person;

public class TestReflect {
	public static void main(String[] args) {
		Field[] fields = Person.class.getFields();
		Field[] declaredFields = Person.class.getDeclaredFields();
		printFields(fields);
		printFields(declaredFields);

		Field[] cFields = Chinese.class.getFields();
		Field[] cDeclaredFields = Chinese.class.getDeclaredFields();
		Field[] scDeclaredFields = Chinese.class.getSuperclass().getDeclaredFields();
		printFields(cFields);
		printFields(cDeclaredFields);
		printFields(scDeclaredFields);

		printAllFields(Object.class);
		printAllFields(Person.class);
		printAllFields(Chinese.class);
	}

	public static void printFields(Field[] fields) {
		System.out.println("============");
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}

	public static void printAllFields(Class<?> clazz) {
		System.out.println(">>>>>>>>>>>>>>>");
		Set<Field> fieldSet = new HashSet<>();
		Field[] declaredFields = clazz.getDeclaredFields();
		fieldSet.addAll(Arrays.asList(declaredFields));

		Class<?> superClazz = clazz.getSuperclass();
		while (!Object.class.equals(superClazz) && superClazz != null) {
			fieldSet.addAll(Arrays.asList(superClazz.getDeclaredFields()));
			superClazz = superClazz.getSuperclass();
		}

		for (Field field : fieldSet) {
			System.out.println(field.getName());
		}
	}
}
