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
        lists.add(new Person("张三1", 1));
        lists.add(new Person("张三2", 4));
        lists.add(new Person("张三3", 1));
        lists.add(new Person("张三4", 3));
        lists.add(new Person("张三5", 67));
        lists.add(new Person("张三6", 8));
        lists.add(new Person("张三6", 1));
        // lists.add(new Person("张三7", null));
        // lists.add(new Person(null, 18));
        // lists.add(new Person(null, null));
        /*lists.add(null);
        lists.stream().forEach(p -> {
            if(p !=null) {
                System.out.println(p.getName());
            }
        });*/
        // list转成string 取出所有的姓名
        List<String> names = lists.stream().map(p -> p.getName()).collect(Collectors.toList());
        // names.stream().forEach(a -> System.out.print(a));

        // 取出所有年龄大于13的
        List<String> names2 = lists.stream().filter(f -> (f.getAge() != null && f.getAge() > 13)).map(p -> p.getName()).collect(Collectors.toList());
        // names2.stream().forEach(a -> System.out.print(a));

        // list转成string 去掉名字相同的
        List<String> names3 = lists.stream().map(p -> p.getName()).distinct().collect(Collectors.toList());
        // names3.stream().forEach(a -> System.out.print(a));

        // 根据年龄降序
        lists.stream().filter(f -> f.getAge() != null).collect(Collectors.toList()).sort((Person p1, Person p2) -> p2.getAge().compareTo(p1.getAge()));
        // lists.stream().forEach(a -> System.out.print(a.getAge()));

        // list转成map(正确方式)
        Map<String, Integer> streamMap = lists.stream().collect(HashMap::new, (m, v) -> m.put(v.getName(), v.getAge()), HashMap::putAll);
        // System.out.println(streamMap);

        // 重复时将重复key的数据组成集合(空指针)
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

        // 分组(存在 key 为空的风险)
        Map<String, List<Person>> groups = lists.stream().collect(Collectors.groupingBy(Person::getName));
        // System.out.println(groups);

        // 年龄求平均值 存在 空指针风险
        // double avgAge = lists.stream().collect(Collectors.averagingInt(Person::getAge));
        // System.out.println(avgAge);

        // 允许null
        String nameStr = lists.stream().map(Person::getName).collect(Collectors.joining(", "));
        // System.out.println(nameStr);

        List<Integer> asList = Arrays.asList(1, 2, 3);
        // 必须满足任何一个元素 都 小于5 才返回true 有一个元素大于5 都会返回false
        boolean allMatch = asList.stream().allMatch(i -> i < 5);
        //System.out.println(allMatch);
        
        List<Integer> asList1 = Arrays.asList(8, 9, 10);
        // 必须满足任何一个元素 都不能 小于5 才返回true 有一个元素小于5 都会返回false
        boolean noneMatch = asList1.stream().noneMatch(i -> i < 5);
        //System.out.println(noneMatch);
        
        List<Integer> asList2 = Arrays.asList(8, 9, 3);
        // 只要有任何一个元素 小于 5 都返回true
        boolean anyMatch = asList2.stream().anyMatch(i -> i < 5);
        //System.out.println(anyMatch);
        
        
        List<Integer> asList3 = Arrays.asList(5, 2, 3);
        // 实现该集合的累加
        Integer reduce = asList3.stream().reduce(0, (i, j) -> i + j);
        //System.out.println(reduce);
        // 实现该集合的乘积
        Integer reduce1 = asList3.stream().reduce(10, (i, j) -> i * j);
        //System.out.println(reduce1);

        double sum = lists.stream().mapToDouble(Person::getAge).sum();
        //System.out.println(sum);
        
        
        //BigDecimal add = lists.stream().map(Person::getAge).reduce(BigDecimal.ZERO, BigDecimal::add);
        //System.out.println("身高 总和：" + df.format(add));
        
        
        //年龄排序输出
        List<String> studentList = lists.stream()
                .filter(x->x.getAge()>1)
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .map(Person::getName)
                .collect(Collectors.toList());
        //studentList.stream().forEach(a -> System.out.print(a));
        
        //找出数据组的最大最小值
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int minx = IntStream.of(array).min().getAsInt();
        System.out.println(minx);
        
        //找出集合中的最大最小值
        List<Integer> asList4 = Arrays.asList(5, 2, 3);
        Optional<Integer> min = asList4.stream().min(Comparator.comparing(Function.identity()));
        Optional<Integer> max = asList4.stream().max((o1, o2) -> o1.compareTo(o2));
        System.out.println("min:"+min.get());
        System.out.println("max:"+max.get());
    }

}
