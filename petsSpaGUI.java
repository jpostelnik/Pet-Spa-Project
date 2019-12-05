import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class petsSpaGUI extends Application
{

    private static ArrayList<Owners> owners = new ArrayList<>();

    public void checkInPage(Stage secondaryStage)
    {
        try {
            ArrayList<Button> b = new ArrayList<>();
            for(int i =0; i<owners.size(); i++)
            {
                b.add(new Button(owners.get(i).getName()));
            }
            VBox list = new VBox();
            list.getChildren().addAll(b);
            list.setSpacing(10);
            Group things = new Group(list);
            Scene scene = new Scene(things,600f,300f);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("check in page");
            secondaryStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage primaryStage)
    {
        try {
            Button checkIn = new Button("check in");
            checkIn.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    checkInPage(new Stage());
                }

            });
            VBox list = new VBox();
            list.setSpacing(10);
            Button checkOut = new Button("check out");

            Button wash = new Button("wash");

            Button trim = new Button("trim");

            Button petsThere = new Button("status");

            Button bills = new Button("bills");

            Button addCustomer = new Button("Add Customers");

            Button quit = new Button("quit");

            list.getChildren().addAll(checkIn,checkOut, wash, trim, petsThere, bills, addCustomer, quit);

            list.setPadding(new Insets(10, 10, 10, 10));

            quit.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent e)
                {
                    primaryStage.close();
                }
            });

            Group root = new Group();
            root.getChildren().add(list);

//			root.getChildren().addAll(checkOut,wash,trim, petsThere,bills,addCustomer, quit);
            Scene scene = new Scene(root,600,300);
            primaryStage.setScene(scene);
            primaryStage.setTitle("pet spa v1");
            primaryStage.show();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public static void main(String[] args)
    {
        owners.add(0, new Owners("tim", "555-555-555", "yeet way"));
        owners.add(new Owners("peter griffin", "777-777-7777", "some where on quohag"));
        owners.get(0).setPets("hue", 99);
        owners.get(0).setPets("mellow", 14);
        owners.get(1).setPets("Brian", 8);
        launch(args);
    }
}
