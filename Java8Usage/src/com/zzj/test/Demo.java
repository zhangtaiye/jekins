package com.zzj.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.zzj.domain.Person;

public class Demo
{

    public static void main(String[] args)
    {
        List<Person> lists = new ArrayList<Person>();
        lists.add(new Person("����1", 1));
        lists.add(new Person("����2", 4));
        lists.add(new Person("����3", 1));
        lists.add(new Person("����4", 3));
        lists.add(new Person("����5", 67));
        lists.add(new Person("����6", 8));
        lists.add(new Person("����6", 1));
        // lists.add(new Person("����7", null));
        // lists.add(new Person(null, 18));
        // lists.add(new Person(null, null));
        /*lists.add(null);
        lists.stream().forEach(p -> {
            if(p !=null) {
                System.out.println(p.getName());
            }
        });*/
        // listת��string ȡ�����е�����
        List<String> names = lists.stream().map(p -> p.getName()).collect(Collectors.toList());
        // names.stream().forEach(a -> System.out.print(a));

        // ȡ�������������13��
        List<String> names2 = lists.stream().filter(f -> (f.getAge() != null && f.getAge() > 13)).map(p -> p.getName()).collect(Collectors.toList());
        // names2.stream().forEach(a -> System.out.print(a));

        // listת��string ȥ��������ͬ��
        List<String> names3 = lists.stream().map(p -> p.getName()).distinct().collect(Collectors.toList());
        // names3.stream().forEach(a -> System.out.print(a));

        // �������併��
        lists.stream().filter(f -> f.getAge() != null).collect(Collectors.toList()).sort((Person p1, Person p2) -> p2.getAge().compareTo(p1.getAge()));
        // lists.stream().forEach(a -> System.out.print(a.getAge()));

        // listת��map(��ȷ��ʽ)
        Map<String, Integer> streamMap = lists.stream().collect(HashMap::new, (m, v) -> m.put(v.getName(), v.getAge()), HashMap::putAll);
        // System.out.println(streamMap);

        // �ظ�ʱ���ظ�key��������ɼ���(��ָ��)
        Map<String, List<Integer>> keyMap = lists.stream().collect(Collectors.toMap(Person::getName, p -> {
            List<Integer> ageList = new ArrayList<Integer>();
            ageList.add(p.getAge());
            return ageList;
        }, (List<Integer> value1, List<Integer> value2) -> {
            value1.addAll(value2);
            return value1;
        }));
        // System.out.println(keyMap);

        Person p1 = null;
        Person p2 = new Person(null, 23);
        String str1 = Optional.ofNullable(p2).map(a -> a.getName()).orElse("ffff");
        // System.out.println(str1);

        // ����(���� key Ϊ�յķ���)
        Map<String, List<Person>> groups = lists.stream().collect(Collectors.groupingBy(Person::getName));
        // System.out.println(groups);

        // ������ƽ��ֵ ���� ��ָ�����
        // double avgAge = lists.stream().collect(Collectors.averagingInt(Person::getAge));
        // System.out.println(avgAge);

        // ����null
        String nameStr = lists.stream().map(Person::getName).collect(Collectors.joining(", "));
        // System.out.println(nameStr);

        List<Integer> asList = Arrays.asList(1, 2, 3);
        // ���������κ�һ��Ԫ�� �� С��5 �ŷ���true ��һ��Ԫ�ش���5 ���᷵��false
        boolean allMatch = asList.stream().allMatch(i -> i < 5);
        //System.out.println(allMatch);
        
        List<Integer> asList1 = Arrays.asList(8, 9, 10);
        // ���������κ�һ��Ԫ�� ������ С��5 �ŷ���true ��һ��Ԫ��С��5 ���᷵��false
        boolean noneMatch = asList1.stream().noneMatch(i -> i < 5);
        //System.out.println(noneMatch);
        
        List<Integer> asList2 = Arrays.asList(8, 9, 3);
        // ֻҪ���κ�һ��Ԫ�� С�� 5 ������true
        boolean anyMatch = asList2.stream().anyMatch(i -> i < 5);
        //System.out.println(anyMatch);
        
        
        List<Integer> asList3 = Arrays.asList(5, 2, 3);
        // ʵ�ָü��ϵ��ۼ�
        Integer reduce = asList3.stream().reduce(0, (i, j) -> i + j);
        //System.out.println(reduce);
        // ʵ�ָü��ϵĳ˻�
        Integer reduce1 = asList3.stream().reduce(10, (i, j) -> i * j);
        //System.out.println(reduce1);

        double sum = lists.stream().mapToDouble(Person::getAge).sum();
        //System.out.println(sum);
        
        
        //BigDecimal add = lists.stream().map(Person::getAge).reduce(BigDecimal.ZERO, BigDecimal::add);
        //System.out.println("��� �ܺͣ�" + df.format(add));
        
        
        //�����������
        List<String> studentList = lists.stream()
                .filter(x->x.getAge()>1)
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .map(Person::getName)
                .collect(Collectors.toList());
        //studentList.stream().forEach(a -> System.out.print(a));
        
        //�ҳ�������������Сֵ
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int minx = IntStream.of(array).min().getAsInt();
        System.out.println(minx);
        
        //�ҳ������е������Сֵ
        List<Integer> asList4 = Arrays.asList(5, 2, 3);
        Optional<Integer> min = asList4.stream().min(Comparator.comparing(Function.identity()));
        Optional<Integer> max = asList4.stream().max((o1, o2) -> o1.compareTo(o2));
        System.out.println("min:"+min.get());
        System.out.println("max:"+max.get());
    }

}
