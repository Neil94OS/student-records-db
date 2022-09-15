module OOPFinalProjectY2{
	requires javafx.controls;
	requires javafx.graphics;
	requires java.sql;

	//requires nonExecJar;  Could not get to work

	
	opens application to javafx.graphics, javafx.fxml;
}
