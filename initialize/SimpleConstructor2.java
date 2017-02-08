package initialize;

// Constructor can have arguments
// 构造器是一种特殊类型的方法,因为它
// 没有返回值
class Rock2 {
	Rock2(int i) {
		System.out.print("Rock " + i + " ");
	}
}

public class SimpleConstructor2 {
	public static void main(String[] args) {
		for (int i = 0; i < 8; i++)
			new Rock2(i);
	}
}
/**Output
Rock 0 Rock 1 Rock 2 Rock 3 Rock 4 Rock 5 Rock 6 Rock 7 
 * */