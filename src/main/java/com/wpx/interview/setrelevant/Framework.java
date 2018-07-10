package com.wpx.interview.setrelevant;
/**
 * 
 * JAVA集合
 * 
 * 	java专门提供了一堆能存很多数据的类,叫集合类
 *  集合类称为超级数组:
 *  	长度可以动态增长
 *   	一个集合中可以存任意类型的数据
 * 
 * 集合分单值集合/双值集合
 * 
 * 		public interface Collection<E> extends Iterable<E>{...} (单值集合)
 * 
 * 			public interface List<E> extends Collection<E> { //加入了特有的方法}(有序+可重复)
 *				实现List接口的有Vector,LinkedList,ArrayList 
 * 				(1)public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable{...}
 * 				(2)public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable{...}
 * 				(3)public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable{...}
 * 				
 * 				说明:
 * 				(1)  public Vector() { this(10); } 
 * 					  底层为动态的数组结构,使用大量的synchronized关键字修饰,故线程安全	
 * 					  增删查均较慢(多线程),初始化默认容量为10 增量为10 
 * 				(2)  底层为链表数据结构,线程不安全,对元素的增删的操作效率很高,随机查询的效率低
 * 					 (使用移动指针寻址).默认初始容量为0,增量不明确
 *   			(3)   private static final int DEFAULT_CAPACITY = 10;
 *   				 底层为动态的数组结构(顺序存储),增删慢,查询快,线程不安全
 *   				 默认初始容量为10,增量未指定,约为原容量的50%
 *   			 注意:
 *   			 因为集合中可以存任意类型的数据,因此存在类型安全问题,解决办法--泛型
 *   			 泛型的技术实现细节:
 *     			 	JDK1.5加入泛型技术
 *     				SUN工程师在编译器中加入一条针对泛型的语法检验,编译通过够,编译器把
 *     	  			字节码文件中凡是泛型的代码删掉
 *     			    
 * 			public interface Set<E> extends Collection<E> {...}(无序+不可重复)
 * 
 * 			Set集合中没有带下标的方法,实现Set接口的有HashSet,LinkedHashSet,
 * 				(1) public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable{...}
 * 				(2) public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, java.io.Serializable {...}
 * 				(3) public class TreeSet<E> extends AbstractSet<E>  implements NavigableSet<E>, Cloneable, java.io.Serializable{...}
 * 						public interface NavigableSet<E> extends SortedSet<E> {...}
 * 							public interface SortedSet<E> extends Set<E> {...}
 * 				
 * 				说明:
 * 				(1) 底层数据结构:散列表(目录+内容),增删和查找都快,不能保证线程安全,无序
 * 					HashSet()	无参构造 //default initial capacity (16) and load factor (0.75)
 * 					HashSet(int initialCapacity)	指定初始容量，默认加载因子为0.75（也就是百分之75）
 * 					HashSet(int initialCapacity,float loadFactor)	指定初始容量，指定加载因子。
 * 				(2) 底层数据结构: 散列表(目录+内容)+链表(记录了插入的顺序),不能保证线程安全,增删和查询都快
 * 					默认初始容量16,默认加载因子是0.75,继承自HashSet
 * 				(3) TreeSet底层为TreeMap
 * 		
 * 			public interface Map<K,V>{...}(双值集合)
 * 				实现Map接口的类有HashMap,LinkedHashMap
 * 				(1)public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable {...}
 * 				(2)public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {...}
 * 				(3)public class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>, Cloneable, java.io.Serializable {...}
 * 				说明: 
 * 				(1)	底层数据结构为散列表(目录+内容),增删和查询都快,不能保证线程安全,
 * 				 无序,键不允许重复,
 * 				 HashMap()  默认初始化容量为16,加载因子为0.75
 * 				 HashMap(int initialCapacity) 自定义初始化容量,默认加载因子为0.75
 * 				 HashMao(int initialCapacity, float loadFactor)  自定义初始化容量,加载因子
 * 				(2) 底层数据结构为散列表(目录+内容)+链表(记录插入的顺序),增删和查询都快,不能保证线程安全,
 * 				 无序,键不允许重复,
 * 				(3) private transient Entry<?,?>[] table;	
 * 				哈希表底层为 散列表+数组,增删和查询较慢,底层使用了大量的synchronized关键字修饰,
 * 				故线程安全,初始容器大小11,加载因子0.75
 * @author wangpx
 */
public class Framework {

}
