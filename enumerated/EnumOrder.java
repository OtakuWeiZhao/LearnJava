package enumerated;

/**
 * 创建Enum时,编译器会自动添加一些有用的特性,例如,它会创建toString()方法, 
 * 见打印语句输出的结果
 * 还会创建ordinal()方法,用来表示某个特定enum常量的声明顺序, 以及static
 * values()方法,用来按照enum常量的声明顺序,产生这些常量构成的数组
 * 
 */
public class EnumOrder {
	public static void main(String[] args) {
		for (Spiciness s : Spiciness.values())
			System.out.println(s + ", ordinal " + s.ordinal());
	}
}
/**Output:
NOT, ordinal 0
MILD, ordinal 1
MEDIUM, ordinal 2
HOT, ordinal 3
FLAMING, ordinal 4
 */