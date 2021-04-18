package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {

	static int count =0;
	static Group groupCFE = new Group();

	static Label cboxSource = new Label();
	static Label cboxTarget = new Label();

	Button run = new Button("Run");
	Label path = new Label ();
	Label dist= new Label ();

	static ArrayList <Vertex> list = new ArrayList <Vertex>();
	static HashMap <Vertex,LinkedList<Edg>> edges = new HashMap<>();
	static BorderPane root = new BorderPane();
	static Pane  pane = new Pane();
	static Line line = new Line();
	static Group group = new Group();
	static Circle c ;

	@Override
	public void start(Stage primaryStage) {
		try {
			root.setRight(box());
			root.setPadding(new Insets(70,70,70,70));
			Image img = new Image("ph.png");
			ImageView imgView = new ImageView(img);
			pane.getChildren().add(imgView);
			root.setCenter(pane);


		//	readCoordinate();
			//readEdg();

			
			

			pane.getChildren().add(groupCFE);

			run.setOnAction(e->{


			


			});


			Scene scene = new Scene(root,750,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	VBox box ()
	{  run.setMinSize(60, 30);
	run.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));
	cboxSource.setMinSize(150,30);
	cboxTarget.setMinSize(150,30);


	Label l =new Label ("Source :");
	Label l2=new Label ("Target :");
	Label l3=new Label ("Path");
	Label l4=new Label ("Distence");

	l.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18)); 
	l2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18)); 
	l3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18)); 
	l4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18)); 
	path.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));
	dist.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));

	path.setStyle("-fx-border-color: Black ");
	VBox vbox = new VBox ();
	vbox.setSpacing(20);
	HBox hb1 = new HBox();
	HBox hb2 = new HBox();
	HBox hb3 = new HBox();
	HBox hb4 = new HBox();

	hb1.getChildren().addAll(l,cboxSource);
	hb2.getChildren().addAll(l2,cboxTarget);
	hb3.getChildren().addAll(l3,path);
	hb4.getChildren().addAll(l4,dist);
	vbox.getChildren().addAll(hb1,hb2,run,hb3,hb4);

	hb1.setSpacing(20);
	hb2.setSpacing(20);
	hb3.setSpacing(20);
	hb4.setSpacing(20);

	return vbox;

	}

	/*static void readCoordinate()
	{	//LinkedListBooks books= new LinkedListBooks();
		int i=0;

		String content=new String();
		try {
			File file=new File("xy.txt");
			Scanner scan=new Scanner(file);
			while(scan.hasNextLine()) {
				 Text text = new Text();

				content=scan.nextLine();
				String [] array=content.split(" ");
				list.add(new Vertex (i++,array[0],Double.parseDouble(array[1]),Double.parseDouble(array[2])));
				//c=list.get(list.size()-1).getCircle();
				pane.getChildren().add(list.get(list.size()-1).getCircle());

				edges.put(list.get(list.size()-1), new LinkedList <Edg>());
				 text.setText(array[0]);
		          text.setX(Double.parseDouble(array[1]));
		            text.setY(Double.parseDouble(array[2])-8);
				    pane.getChildren().add(text);

			}
			scan.close(); 
		}
		catch (Exception e) {
			System.out.println(e);
		}


	}
	static void readEdg()
	{	//LinkedListBooks books= new LinkedListBooks();


		String content=new String();
		try {
			File file=new File("cost.txt");
			Scanner scan=new Scanner(file);
			while(scan.hasNextLine()) {
				content=scan.nextLine();

				String [] array=content.split(" ");
				// get liked list for the key
				Vertex v = getVertex(array[0]);
				LinkedList<Edg> l= edges.get(v);
				l.add(new Edg (getVertex(array[1]),Double.parseDouble(array[2])));
				edges.replace(v, l);


				//groupCFE.getChildren().add( new Line(v.getX(), v.getY(),   getVertex(array[1]).getX(),   getVertex(array[1]).getY()));


			}
			scan.close(); 

		}
		catch (Exception e) {
			System.out.println(e);
		}


	}

	static Vertex getVertex (String name )
	{
		for (int i=0;i<list.size();i++)
		{if (list.get(i).getName().equalsIgnoreCase(name))
			return list.get(i);
		}
		return null;
	}*/

	public static void main(String[] args) {

		//Random rand = new Random();

		//System.out.print(rand.nextInt(50));
		
		launch(args);
		/*readCoordinate();
		readEdg();
		edges.forEach((key, value) ->{

			System.out.println(key+"--"+value.toString());
				});

		Dijkstra d = new Dijkstra(edges);
		d.execute(list.get(0), list.get(5));
		if (d.getPath(list.get(5), list.get(0))==null)
			System.out.println("nu");
		else
	System.out.println(	d.getPath(list.get(5), list.get(0)).toString());

d.getPredecessors().forEach((key, value) ->{

System.out.println(key.getName()+"--"+value.getName());
	});*/


	}



}
