package enumerated;

// Capabilities of the Enum class
enum Shrubbery {
	GROUND, CRAWLING, HANGING
}

public class EnumClass {
	public static void main(String[] args) {
		for (Shrubbery s : Shrubbery.values()) {
			// ordinal����һ��intֵ,��ÿ��enumʵ������ʱ�Ĵ���
			System.out.println(s + " ordinal: " + s.ordinal());
			System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
			System.out.print(s.equals(Shrubbery.CRAWLING) + " ");
			// ������==���Ƚ�enumʵ��
			System.out.println(s == Shrubbery.CRAWLING);
			// ����getDeclaringClass����֪����������enum��
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
			System.out.println("-----------------------------------------");
		}
		// Produce an enum value from a string name:
		for (String s : "HANGING CRAWLING GROUND".split(" ")) {
			// valueOf��Enum�ж����static����,���ݸ������ַ�����Ӧ��enumʵ��,
			// ��������ڸ������ֵ�ʵ��,�����׳��쳣
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