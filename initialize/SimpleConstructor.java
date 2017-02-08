package initialize;

// Demonstration of a simple constructor
class Rock {
	// 构造器与类的名称相同
	Rock() {// This is the constructor
		System.out.print("Rock ");
	}
}

public class SimpleConstructor {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			// 创建对象时,已经初始化了
			new Rock();
	}
}
/** Output
Rock Rock Rock Rock Rock Rock Rock Rock Rock Rock 
 * */