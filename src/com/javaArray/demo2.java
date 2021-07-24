package com.javaArray;

import java.util.*;

/**
 * @description: 集合2
 * @author: dt
 * @date: 2021/7/23 9:31
 */
public class demo2 {
    public static void main(String[] args) {
        ArrayList<Student> arrayList=new ArrayList<>();
        arrayList.add(new Student("a",23));
        arrayList.add(new Student("b",21));
        arrayList.add(new Student("c",27));
        arrayList.add(new Student("d",28));

//        Collections.sort(arrayList, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge()-o1.getAge();
//            }
//        });
        Collections.sort(arrayList,(Student o1, Student o2)->{
            return o1.getAge() - o2.getAge();
        });
        Iterator<Student> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Student next = iterator.next();
            System.out.println(next);
        }
//        我们学习的集合都可以使用“foreach”语句，同时也包括数组。
//        增强for遍历数组，class文件反编译后就是传统形式for循环。
//-       增强for遍历集合，class文件反编译后就是迭代器。
        for (Student student : arrayList) {
            System.out.println(student);
        }




    }
}
class Student{
    private String name;
    private int  age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class   MyGen{
    public <MVP> void show(MVP mvp){
        System.out.println(mvp.getClass());
    }
    public <MVP> MVP show2(MVP mvp){
       return mvp;
    }

}
//泛型不存在继承关系
interface MyGenericInterface<E>{
    public abstract void add(E e);

    public abstract E getE();
}
class MyGenTest implements MyGenericInterface{
    public static void main(String[] args) {
        MyGen myGen=new MyGen();
        myGen.show(11);
        myGen.show("1231");
        myGen.show('b');

        Collection<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        getElement(list1);

    }

    public static void getElement(Collection<?> coll){
        Iterator<?> it = coll.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public Object getE() {
        return null;
    }



}
//需求：创建老师类和班主任类，提供姓名和年龄属性，并都具有work方法。将多个老师对象和多个班主任对象存储到两个集合中。
// 提供一个方法可以同时遍历这两个集合，并能调用work方法。

 abstract class Employee{
    private String name;
    private int age;

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void work();
}
class Teacher extends Employee{
    private String name;
    private int age;

    public Teacher(){

    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println("老师正在上课");
    }
}
class Manager extends Employee{
    public Manager() {
    }

    public Manager(String name, int age) {
        super(name, age);
    }


    @Override
    public void work() {
        System.out.println("班主任管理班级");
    }
}
class TeacherTest {
    public static void main(String[] args) {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(new Teacher("张三",30));
        teacherList.add(new Teacher("李四",32));

        List<Manager> managerList = new ArrayList<Manager>();
        managerList.add(new Manager("王五",25));
        managerList.add(new Manager("赵六",23));
        getElement(teacherList);
        getElement(managerList);
    }
    //定义方法，参数为List集合，泛型被限定为Employee，可以接收的泛型为Employee或者子类！
    public static void getElement(List<? extends  Employee> list){
        Iterator<? extends Employee> it = list.iterator();
        while (it.hasNext()){
            Employee employee = it.next();
            System.out.println(employee.getName()+"::"+employee.getAge());
            employee.work();
        }
    }
}
////            - List集合是有序的集合，存储和取出的顺序一致。
////            - List集合允许存储重复的元素。
////            - List集合中的每个元素具有索引。
//`Set`接口下的集合不存储重复的元素。
class SetTest{
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("java");
        set.add("java1");
        set.add("java2");
        set.add("java3");
//        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            System.out.println(next);
//        }
        for (String s : set) {
            System.out.println(s);
        }

//         HashSet底层数据结构是单向哈希表。
    //- 不保证元素的迭代顺序，存储元素的顺序和取出元素的顺序不一致。
    //- 此集合不允许存储重复元素。
    //  - 存储在此集合中的元素应该重写hashCode()和equals()方法保证唯一性。
    //- 此集合具有数组，链表，红黑树三种结构特点。
    //- 线程不安全，运行速度快。

        HashSet<StudentSet> hashSet=new HashSet<>();
        hashSet.add(new StudentSet("于谦",43));
        hashSet.add(new StudentSet("于谦1",44));
        hashSet.add(new StudentSet("于谦2",47));
        hashSet.add(new StudentSet("于谦3",41));

        for (StudentSet studentSet : hashSet) {
            System.out.println(studentSet);
        }
    }
}

class SetLink{
    public static void main(String[] args) {
//        LinkedHashSet是Set集合的一个实现，具有set集合不重复的特点，同时具有可预测的迭代顺序，也就是我们插入的顺序。
        /**
        * 一.HashSet
特点：

1.HashSet中不能有相同的元素，可以有一个Null元素，存入的元素是无序的。

2.HashSet如何保证唯一性？

1).HashSet底层数据结构是哈希表，哈希表就是存储唯一系列的表，而哈希值是由对象的hashCode()方法生成。

2).确保唯一性的两个方法：hashCode()和equals()方法。

3.添加、删除操作时间复杂度都是O(1)。

4.非线程安全

二.LinkedHashSet
特点：

1.LinkedHashSet中不能有相同元素，可以有一个Null元素，元素严格按照放入的顺序排列。

2.LinkedHashSet如何保证有序和唯一性？

1).底层数据结构由哈希表和链表组成。

2).链表保证了元素的有序即存储和取出一致，哈希表保证了元素的唯一性。

3.添加、删除操作时间复杂度都是O(1)。

4.非线程安全

三.TreeSet
特点：

1.TreeSet是中不能有相同元素，不可以有Null元素，根据元素的自然顺序进行排序。

2.TreeSet如何保证元素的排序和唯一性？

底层的数据结构是红黑树(一种自平衡二叉查找树)

3.添加、删除操作时间复杂度都是O(log(n))

4.非线程安全

四.总结：
通过以上特点可以分析出，三者都保证了元素的唯一性，如果无排序要求可以选用HashSet；
* 如果想取出元素的顺序和放入元素的顺序相同，那么可以选用LinkedHashSet。
* 如果想插入、删除立即排序或者按照一定规则排序可以选用TreeSet。
        * */
        Set<String> set = new LinkedHashSet<String>();
        set.add("bbb");
        set.add("aaa");
        set.add("abc");
        set.add("bbc");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for(String s : set){
            System.out.println(s);
        }
    }
}

class Map{
    public static void main(String[] args) {
//        `Collection`中的集合称为单列集合，`Map`中的集合称为双列集合。
//- 需要注意的是，`Map`中的集合不能包含重复的键，值可以重复；每个键只能对应一个值。

//        底层哈希表结构。
        //不允许重复键。
        //用作键的对象，应该重写hashCode()方法和equals()方法。
        //此集合可以使用null值和null键。
        //线程不安全，运行速度快。
//        HashMap<String,String> map=new HashMap<>();
//        map.put("1","2");
//        map.put("2","3");
//        map.put("3","4");
//        map.put("5","6");
////        System.out.println(map);
//        Set<String> set = map.keySet();
//        for (String s : set) {
//            String s1 = map.get(s);
//            System.out.println(s.toString()+"。。。"+s1);
//        }
//        Collection<String> values = map.values();
//        for (String value : values) {
//            System.out.println(value);
//        }

//        LinkedHashMap
//        底层是哈希表双向链表，保证迭代的顺序。

//        Map接口实现类Hashtable的子类Properties类。
//        Properties也是Map接口实现类，是存储键值对的双列集合，由于此类能和IO流结合使用，数据可以持久化，使用量很大
//        继承Hashtable，底层数据结构是哈希表。
        //线程安全，运行速度慢。
        //不允许null值，null键。
        //此集合存储键值对数据类型固定为String。
        //可以和IO流结合使用，从流中加载数据。


//        需求：
    //计算一个字符串中每个字符出现次数。
    //分析：
    //获取一个字符串对象
    //创建一个Map集合，键代表字符，值代表次数。
    //遍历字符串得到每个字符。
    //判断Map中是否有该键。
    //如果没有，第一次出现，存储次数为1；如果有，则说明已经出现过，获取到对应的值进行++，再次存储。
    //打印最终结果
        Scanner scanner=new Scanner(System.in);
        String next = scanner.nextLine();
// 定义 每个字符出现次数的方法
        findChar(next);
    }

    private static void findChar(String next) {
        //1:创建一个集合 存储  字符 以及其出现的次数
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i <next.length() ; i++) {
            char c=next.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else {
                Integer count =map.get(c);
                map.put(c,++count);
            }
        }
        System.out.println(map);
    }
}
class StudentSet{
    private String name;
    private int age;

    public StudentSet() {
    }

    public StudentSet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentSet that = (StudentSet) o;
        return age == that.age && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "StudentSet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class changeMethod{
    public static void main(String[] args) {
//        可变参数的本质是数组。
//  - 不传递参数，数组的长度是0.
//  - 传递几个参数，数组的长度就是几。
//- 一个方法中只能有一个可变参数。
//- 如果方法中有多个参数，可变参数只能写在最后一位。
//         Collections.addAll(list, 5, 222, 1，2);

        // 定义一个Map集合用来存储牌号  和 牌
        HashMap<Integer, String> pookerMap = new HashMap<Integer, String>();
        //定义一个List集合用来存储牌号
        ArrayList<Integer> pookerList = new ArrayList<Integer>();

        String[] colors = "♥-♠-♦-♣".split("-");
        String[] nums = "2-A-K-Q-J-10-9-8-7-6-5-4-3".split("-");
        int index = 2;
        for(String num : nums){
            for(String color : colors){
                String thisPooker = color+num;

                //将扑克牌放入Map集合
                pookerMap.put(index, thisPooker);
                //将牌号放入到pookerList集合中
                pookerList.add(index);
                index++;
            }
        }
        //将大王小王添加到集合
        pookerMap.put(0, "大王");
        pookerMap.put(1, "小王");
        pookerList.add(0);
        pookerList.add(1);
        //发牌
        ArrayList<Integer> player1 = new ArrayList<Integer>();
        ArrayList<Integer> player2 = new ArrayList<Integer>();
        ArrayList<Integer> player3 = new ArrayList<Integer>();
        ArrayList<Integer> diPai = new ArrayList<Integer>();

        //遍历牌号的集合 判断索引发牌号
        for(int i = 0 ;i < pookerList.size() ;i++){
            Integer pookerNum = pookerList.get(i);
            if(i>=51){
                diPai.add(pookerNum);
        }else if(i % 3 == 0){
            player1.add(pookerNum);
        }else if(i % 3 == 1){
            player2.add(pookerNum);
        }else if(i % 3 == 2){
            player3.add(pookerNum);
        }
    }
    //		排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(diPai);
        show("柳岩",player1,pookerMap);
        show("唐嫣",player2,pookerMap);
        show("金莲",player3,pookerMap);
        show("底牌",diPai,pookerMap);
    }

    private static void show(String name, ArrayList<Integer> player, HashMap<Integer, String> pookerMap) {
        System.out.print(name+":");
        for(Integer pookerNum : player){
            String thisPooker = pookerMap.get(pookerNum);
            System.out.print(thisPooker+" ");
        }
        System.out.println();
    }
}