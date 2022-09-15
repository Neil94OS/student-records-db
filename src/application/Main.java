//Neil O'Sullivan R00206266 SDH2B
package application;

import model.*;
import model.Module;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;
import control.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

//Final assignment
/**
*Main class for application
*/
public class Main extends Application { //Main Class
	private Stage window;
	private static Label nameLabel, lnameLabel, initLabel, idLabel, dobLabel, moduleLabel, gradeLabel, idLabel4, idLabel5, idLabel6,  nameLabel2, lnameLabel2, initLabel2, idLabel2, dobLabel2;
	private   TextField name, lname, init, id, dob, module, grade, id2, id3, name2, lname2, init2,  dob2, id4, id5,id6;
    private static  Button      addStudentButton, removeStudentButton, listStudentButton, updateStudentButton, addModuleButton,exitButton,  gradeButton, 
    showModulesButton, showFirstClassModulesButton, showStudentInfoButton, loop;
    private static  TextArea    studentInfo,studentInfo2, showInfo, moduleInfo, showInfo2, showInfo3;
    String students, modules;
	
	 private static StudentController studentControl= new StudentController();
	 private static ModuleController moduleControl= new ModuleController();
	 
	 
	@Override
	public void start(Stage primaryStage) {
		try {
						 
			window = primaryStage;
			
			  //Declaration of labels and text fields  
			    window.setTitle("MTU Student Record System");
			    nameLabel = new Label("Enter First Name: ");
			    name = new TextField ();
			    initLabel = new Label("Enter Middle Initial: ");
			    init = new TextField ();
			    lnameLabel = new Label("Enter Last Name: ");
			    lname = new TextField ();
			    idLabel = new Label("Enter Student ID: ");
			    id = new TextField ();
			    dobLabel = new Label("Enter Date of Birth: ");
			    dob = new TextField ();
			    
			    nameLabel2 = new Label("Enter First Name: ");
			    name2 = new TextField ();
			    initLabel2 = new Label("Enter Middle Initial: ");
			    init2 = new TextField ();
			    lnameLabel2 = new Label("Enter Last Name: ");
			    lname2 = new TextField ();
			    idLabel2 = new Label("Enter Student ID: ");
			    id2 = new TextField ();
			    dobLabel2 = new Label("Enter Date of Birth: ");
			    dob2 = new TextField ();
			    
			    idLabel4 = new Label("Enter Student ID: ");
			    id4 = new TextField ();
			    idLabel5 = new Label("Enter Student ID: ");
			    id5 = new TextField ();
			    idLabel6 = new Label("Enter Student ID: ");
			    id6 = new TextField ();
			    
			    moduleLabel = new Label("Enter Module: ");
			    module = new TextField ();
			    gradeLabel = new Label("Enter Grade: ");
			    grade = new TextField ();
			    
			    //idLabel2 = new Label("Enter Student ID: ");
			   // id2 = new TextField ();
			    
			    //Tab pane for the tabs to be at the top 
			    TabPane tabPane = new TabPane();
			    tabPane.setSide(Side.TOP);
			    
			    BorderPane mainPane = new BorderPane();
			    Group root = new Group();  
			    
			   //Buttons  
			    addStudentButton = new Button ("Add");
			    removeStudentButton = new Button("Remove");
			    listStudentButton = new Button("List");
			    updateStudentButton = new Button ("Update");
			    showModulesButton = new Button("Show Results");
			    showFirstClassModulesButton = new Button ("Show First Class Results");
			    showStudentInfoButton = new Button ("Show Student Info");
			    exitButton = new Button("Exit");
			    addModuleButton= new Button ("Enter");
			    gradeButton = new Button ("Order by grade");
			    loop = new Button ("Loop");
			    
			    
			    //Text areas for each tab set at 600 pixels
			    studentInfo = new TextArea("Students in the application : \n");
			    studentInfo.setPrefWidth(600);
			    studentInfo2 = new TextArea("Students in the application : \n");
			    studentInfo2.setPrefWidth(600);
			    moduleInfo = new TextArea("Add modules for a student.\n");  
			    moduleInfo.setPrefWidth(600);
			    showInfo = new TextArea("Display modules and results \n");
			    showInfo.setPrefWidth(600);
			    //Set at 300 pixels for 2 text areas in the same box
			    showInfo2 = new TextArea("Display student details \n");
			    showInfo2.setPrefWidth(300);
			    showInfo3 = new TextArea("Display modules and results\n");
			    showInfo3.setPrefWidth(300);
			 
			    
	//Event handling
			 //Add a student 
			 addStudentButton.setOnAction(new EventHandler<ActionEvent>() {
			     @Override
			    	public void handle(ActionEvent event) {
			    		Name newName = new Name(name.getText(), init.getText(), lname.getText());// create name object from the input in text fields
			    		DateOfBirth d = new DateOfBirth (dob.getText());//create dob object
			    		try {
							studentControl.addStudentToList(newName, id.getText(), d);// add student to the db
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		}
			    	});
			 
			 
			 //List Students in db
			    listStudentButton.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent event) {
				 	String allStudent=studentControl.getListStudent();//get list of students from db as a string to output to text field
			        studentInfo.setText(allStudent);
			 	}
			 });
			   
			   //Remove student from db
			    removeStudentButton.setOnAction(e -> 
			    {
					try {
						studentControl.removeStudent(id2.getText());// remove by student ID
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
			 
			    //Update a students details in the db
			 updateStudentButton.setOnAction(new EventHandler<ActionEvent>() {
			     @Override
			    	public void handle(ActionEvent event) {
			    		Name newName = new Name(name2.getText(), init2.getText(), lname2.getText());// create name
			    		DateOfBirth d = new DateOfBirth (dob2.getText());//create dob object
			    		try {
							studentControl.updateStudent(newName, id2.getText(), d);// update 
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    		}
			    	});
			   
			 //Add a module for a student
				 addModuleButton.setOnAction(new EventHandler<ActionEvent>() {
				     @Override
				    	public void handle(ActionEvent event) {
				    	
				    		try {
								moduleControl.addModuleToList(id4.getText(), module.getText(), grade.getText());// add module info by student ID
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    		}
				    	});
				
	//Show all of a students modules and results
				 showModulesButton.setOnAction(new EventHandler<ActionEvent>() {
				     @Override
				    	public void handle(ActionEvent event) {
				    	
				    	 //Convert from list of modules to string 
				    		List<Module> m = moduleControl.getAllModules(id5.getText());
				    		String result = m.stream()
				    			      .map(n -> String.valueOf(n))
				    			      .collect(Collectors.joining(" ", "", ""));
				    		showInfo.setText(result);//output string to text area
				    		}
				    	});
				 
	//Show all of a students modules and results where they achieved a first class honors (70 and over)
				 showFirstClassModulesButton.setOnAction(new EventHandler<ActionEvent>() {
				     @Override
				    	public void handle(ActionEvent event) {
				    	
				    	//Convert from list of modules to string 
				    		List<Module> m = moduleControl.getAllModulesFirstClass(id5.getText());
				    		String result = m.stream()
				    			      .map(n -> String.valueOf(n))
				    			      .collect(Collectors.joining(" ", "", ""));
				    		showInfo.setText(result);//output string to text area
				    		}
				    	});
				 

				 //Show all details for a student
				 showStudentInfoButton.setOnAction(new EventHandler<ActionEvent>() {
				     @Override
				    	public void handle(ActionEvent event) {
				    	
				    	 //Show all of the student information
				    	//Convert from list of students to string 
				    	 List<Student> s = studentControl.showStudentInfo(id6.getText());
				    		String result = s.stream()
				    			      .map(n -> String.valueOf(n))
				    			      .collect(Collectors.joining(" ", "", ""));
				    	
				    		//Show all modules and results
				    		//Convert from list of modules to string 
				    		List<Module> m = moduleControl.getAllModules(id6.getText());
				    		String result1 = m.stream()
				    			      .map(n -> String.valueOf(n))
				    			      .collect(Collectors.joining(" ", "", ""));
				    		showInfo2.setText(result);//Text field for student info
				    		showInfo3.setText(result1);//Text field for module info
				    		}
				    	});
				 
			//Loop memory testing	 
				 loop.setOnAction(new EventHandler<ActionEvent>() {
				     @Override
				    	public void handle(ActionEvent event) {
				    		// create name object from the input in text fields
				    	  List<Name> loopList= new ArrayList<Name>();
				    		int j =1;
				    		while(j>0) {
				    			Name newName = new Name("A", "B", "C");
				    			loopList.add(newName);
				    			System.out.println("Looping\n");
				    		}
				    		}
				    	});
				    	
			//Exit application			 
			 exitButton.setOnAction(e->{ 
				 
				 System.exit(0);
			 }
			   );
			 
			    HBox r1 = new HBox(10);
			    r1.getChildren().addAll(nameLabel, name, initLabel, init, lnameLabel, lname);
			    
			    
			    HBox r2 = new HBox(20);
			    r2.getChildren().addAll(idLabel, id);
			    
			    
			    HBox r3 = new HBox(20);
			    r3.getChildren().addAll(dobLabel, dob);

			    
			    HBox r4 = new HBox(20);
			    r4.getChildren().addAll(addStudentButton,listStudentButton);
			    
			    HBox r5 = new HBox(20);
			    r5.getChildren().addAll(studentInfo);
			    
			 
			    HBox r7 = new HBox(20);
			    r7.getChildren().addAll(idLabel4, id4);
			    
			    HBox r8 = new HBox(10);
			    r8.getChildren().addAll(moduleLabel, module);
			    
			    
			    HBox r9= new HBox(20);
			    r9.getChildren().addAll(gradeLabel, grade);
			    
			    HBox r10= new HBox(20);
			    r10.getChildren().addAll(addModuleButton);
			    
			    
			    
			    HBox r11 = new HBox(20);
			    r11.getChildren().addAll(idLabel5, id5 );
			    
			    HBox r12 = new HBox(20);
			    r12.getChildren().addAll(showModulesButton, showFirstClassModulesButton);
			    
			    HBox r13 = new HBox(20);
			    r13.getChildren().addAll(showInfo);
			    
			    HBox r14= new HBox(20);
			    r14.getChildren().addAll(moduleInfo);
			    
			    HBox x11 = new HBox(20);
			    x11.getChildren().addAll(idLabel6, id6 );
			    
			    HBox x12 = new HBox(20);
			    x12.getChildren().addAll(showStudentInfoButton);
			    
			    HBox x13 = new HBox(20);
			    x13.getChildren().addAll(showInfo2, showInfo3);
			    
			    
			    
			    HBox x1 = new HBox(10);
			    x1.getChildren().addAll(nameLabel2, name2, initLabel2, init2, lnameLabel2, lname2);
			    
			    
			    HBox x2 = new HBox(20);
			    x2.getChildren().addAll(idLabel2, id2);
			    
			    
			    HBox x3 = new HBox(20);
			    x3.getChildren().addAll(dobLabel2, dob2);

			    
			    HBox x4 = new HBox(20);
			    x4.getChildren().addAll(removeStudentButton, updateStudentButton);
			    
			    HBox x5 = new HBox(20);
			    x5.getChildren().addAll(studentInfo2);
			    
			    
			    HBox x14 = new HBox(20);
			    x14.getChildren().addAll(loop);
			    

			    
			    Scene scene = new Scene(root, 820, 500);
			    scene.setFill(new LinearGradient(
			            0, 0, 1, 1, true,                      
			            CycleMethod.NO_CYCLE,                  
			            new Stop(0, Color.web("#6BD1C4")),     
			            new Stop(35, Color.web("#D61313")))
			    );
			    
			 
			 // Adding student tab   
			    Tab tabA = new Tab("Add Student"); 
				tabA.setClosable(false);
				tabPane.getTabs().add(tabA); 
				
				VBox tabA_vBox = new VBox(10); 
				tabA_vBox.setPadding(new Insets(20, 20, 20, 20));            
		     	tabA_vBox.getChildren().addAll(r1,r2,r3,r4,r5);
		     	tabA.setContent(tabA_vBox); 
		     	
		     	//Edit student tab
		     	Tab tabB = new Tab("Edit Student"); 
				tabB.setClosable(false);
				tabPane.getTabs().add(tabB); 
					
				VBox tabB_vBox = new VBox(10); 
				tabB_vBox.setPadding(new Insets(20, 20, 20, 20));            
			    tabB_vBox.getChildren().addAll(x1,x2,x3,x4,x5);
			    tabB.setContent(tabB_vBox); 
		   
		     	//Adding module tab
		     	Tab tabC = new Tab("Add Module"); 
		  		tabC.setClosable(false);
		  		tabPane.getTabs().add(tabC); 
		  		
		  		VBox tabC_vBox = new VBox(10); 
		  		tabC_vBox.setPadding(new Insets(10, 10, 10, 10));            
		       	tabC_vBox.getChildren().addAll(r7,r8,r9, r10, r14);
		       	tabC.setContent(tabC_vBox); 
		     
		       	//View results tab
		       	Tab tabD = new Tab("View Results"); 
		  		tabD.setClosable(false);
		  		tabPane.getTabs().add(tabD); 
		  		
		  		VBox tabD_vBox = new VBox(10); 
		  		tabD_vBox.setPadding(new Insets(10, 10, 10, 10));            
		       	tabD_vBox.getChildren().addAll(r11,r12,r13);
		       	tabD.setContent(tabD_vBox); 
		       	
		       	//View a students record
		    	Tab tabE = new Tab("Student Records"); 
		  		tabE.setClosable(false);
		  		tabPane.getTabs().add(tabE); 
		  		
		  		VBox tabE_vBox = new VBox(10); 
		  		tabE_vBox.setPadding(new Insets(10, 10, 10, 10));            
		       	tabE_vBox.getChildren().addAll(x11,x12,x13);
		       	tabE.setContent(tabE_vBox); 
		       	
		     	//View a students record
		    	Tab tabF = new Tab("Loop"); 
		  		tabF.setClosable(false);
		  		tabPane.getTabs().add(tabF); 
		  		
		  		VBox tabF_vBox = new VBox(10); 
		  		tabF_vBox.setPadding(new Insets(10, 10, 10, 10));            
		       	tabF_vBox.getChildren().addAll(x14);
		       	tabF.setContent(tabF_vBox); 


		    	mainPane.setCenter(tabPane);      
		     	mainPane.prefHeightProperty().bind(scene.heightProperty());      
		     	mainPane.prefWidthProperty().bind(scene.widthProperty());      
		     	root.getChildren().add(mainPane);      
		     	primaryStage.setScene(scene);      
		     	primaryStage.show(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	*Main driver
	*/
	public static void main(String[] args) {
		launch(args);
	}
}


