package application;

import javafx.scene.control.ComboBox;
import javafx.scene.shape.Circle;
public class Vertex {
	Main m = new Main();

	
int id;
	private String name;
	private double x;
	private double y;
	private Circle circle;
	

	
	public Vertex()
	{
		
	}
public Vertex(int id,String name, double x, double y) {
	super();
	this.id=id;
	this.name = name;
	this.x = x;
	this.y = y;
	this.circle=  new Circle (x,y,5);
	this.circle.setUserData(name);
	circle.setOnMouseClicked(e->{
		if (m.count==0)
		{
			m.cboxSource.setText(this.circle.getUserData()+"");
			m.count++;
		}
		else 
			{
			m.cboxTarget.setText(this.circle.getUserData()+"");
		m.count = 0;
			}
	
	});
}




public Vertex(String name) {
	super();
	this.name = name;
}






public Circle getCircle() {
	return circle;
}


public void setCircle(Circle circle) {
	this.circle = circle;
}


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getX() {
	return x;
}
public void setX(double x) {
	this.x = x;
}
public double getY() {
	return y;
}
public void setY(double y) {
	this.y = y;
}

public String tString() {
	return  name ;
}
@Override
public String toString() {
	return "Vertex [name=" + name + ", x=" + x + ", y=" + y +  "]";
}

	
}
