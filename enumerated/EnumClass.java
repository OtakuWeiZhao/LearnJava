package enumerated;

// Capabilities of the Enum class
enum Shrubbery {
	GROUND, CRAWLING, HANGING
}

public class EnumClass {
	public static void main(String[] args) {
		for (Shrubbery s : Shrubbery.values()) {
			// ordinal返回一个int值,是每个enum实例声明时的次序
			System.out.println(s + " ordinal: " + s.ordinal());
			System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
			System.out.print(s.equals(Shrubbery.CRAWLING) + " ");
			// 可以用==来比较enum实例
			System.out.println(s == Shrubbery.CRAWLING);
			// 调用getDeclaringClass可以知道其所属的enum类
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
			System.out.println("-----------------------------------------");
		}
		// Produce an enum value from a string name:
		for (String s : "HANGING CRAWLING GROUND".split(" ")) {
			// valueOf是Enum中定义的static方法,根据给定名字返回相应的enum实例,
			// 如果不存在给定名字的实例,将会抛出异常
			Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shrub);
		}
	}
}
/**Output:
 GROUND ordinal: 0
-1 false false
class enumerated.Shrubbery
GROUND
-----------------------------------------
CRAWLING ordinal: 1
0 true true
class enumerated.Shrubbery
CRAWLING
-----------------------------------------
HANGING ordinal: 2
1 false false
class enumerated.Shrubbery
HANGING
-----------------------------------------
HANGING
CRAWLING
GROUND
 */