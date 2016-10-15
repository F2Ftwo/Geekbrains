class Cat {
	private String name;
	private String color;
	private int age;
	
	Cat(String name, String color, int age) { //Конструктор
	this.name = name;
	this.color = color;
	this.age = age;
	}
	public void Draw() { System.out.println(name + ":" + color + ":" + age); }
	public void Say() { System.out.println("Meow Meow"); }
}