package exam;

public class ShapeExam {
	public static void main(String[] args) {
		Circle c;
		Rectangle r;
		c = new Circle(2.0f);
		r = new Rectangle(3.0f, 5.0f);
		System.out.println("圆面积" + returnArea(c));
		System.out.println("矩形面积" + returnArea(r));
	}

	static float returnArea(Shape s) {
		return s.area();
	}
}

abstract class Shape {
	public float area() {
		return 0.0f;
	}
}

class Circle extends Shape {
	private float R;

	public Circle(float r) {
		R = r;
	}

	@Override
	public float area() {
		return (float) (Math.PI * R * R);
	}
}

class Rectangle extends Shape {
	private float w, h;

	public Rectangle(float w, float h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public float area() {
		return w * h;
	}
}