import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class petsSpaGUI extends Application
{

    private static ArrayList<Owners> owners = new ArrayList<>();
    
    public void showStatus(Stage secondaryStage)
    {
    	try {
    		VBox list = new VBox();
    		ArrayList<Text> text =  new ArrayList<>();
    		for(int i = 0; i<owners.size();i++)
    		{
    			for(int j = 0; j<owners.get(i).getPets().size();j++)
    			{
    				if(owners.get(i).getPets().get(j).isIn())
    					text.add(new Text(owners.get(i).getPets().get(j).toString()));
    			}
    		}
    		Button back = new Button("close");
    		back.setOnAction(new EventHandler<ActionEvent>() {
    			
    			@Override public void handle(ActionEvent e)
    			{
    				secondaryStage.close();
    			}
    		}
    				
    			);
    		for(int i = 0; i<text.size();i++)
    		{
    			text.get(i).setFont(new Font(10));
    		}
    		list.getChildren().addAll(text);
    		list.getChildren().add(back);
    		list.setSpacing(20);
    		Group root = new Group(list);
    		Scene scene = new Scene(root, 600,300);
    		secondaryStage.setScene(scene);
    		secondaryStage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    
    
    public void checkinAnimals(Stage secondaryStage,int o)
    {
    	try {
    		VBox listb =  new VBox();
    		VBox listT = new VBox();
    		ArrayList<Button>  b = new ArrayList<>();
    		ArrayList<Text> text = new ArrayList<>();
    		
    		for(int i = 0; i<owners.get(o).getPets().size();i++)
    		{
    			b.add(new Button(owners.get(o).getPets().get(i).getName()));
    			text.add(new Text());
    			text.get(i).setFont(new Font(20));
    		}
    		for(int i = 0;i< b.size();i++)
    		{
    			int spot = i;
    			b.get(i).setOnAction(new EventHandler<ActionEvent>() {
    				@Override public void handle(ActionEvent e)
    				{
    					System.out.println("in");
    					owners.get(o).getPets().get(spot).setIn(true);
    					text.get(spot).setText("Checked in");
    				}
    			});
    		}
    		Button back = new Button("back");
    		back.setOnAction(new EventHandler<ActionEvent>() {
    			
    			@Override public void handle(ActionEvent e)
    			{
    				checkInPage(secondaryStage);
    			}
    		}
    				
    			);
    			
    		
    		listb.getChildren().addAll(b);
    		listb.getChildren().add(back);
    		listb.setSpacing(20);
    		listT.getChildren().addAll(text);
    		HBox row = new HBox();
    		row.getChildren().addAll(listb, listT);
    		row.setSpacing(25);
    		Group root = new Group(row);
    		Scene scene = new Scene(root, 600,300);
    		secondaryStage.setScene(scene);
    		
    	}
    	catch(Exception e){
    		
    	}
    }
    
    public void showBills(Stage secondaryStage)
    {
    	try {
    		VBox list =  new VBox();
    		ArrayList<Text> text =  new ArrayList<>();
    		
    		for(int i =0; i<owners.size();i++)
    		{
    			text.add(new Text(owners.get(i).toString()));
    			text.get(i).setFont(new Font(15));
    			
    		}
    		Button close =  new Button("close");
    		close.setOnAction(new EventHandler<ActionEvent>()
    				{
    			@Override public void handle(ActionEvent e)
    			{
    				secondaryStage.close();
    			}
    				});
    		list.getChildren().addAll(text);
    		list.getChildren().add(close);
    		list.setSpacing(20);
    		Group root = new Group(list);
    		Scene scene = new Scene(root, 600,300);
    		secondaryStage.setScene(scene);
    		secondaryStage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    
    public void checkInPage(Stage secondaryStage)
    {
        try {

            VBox list = new VBox();

        		list.getChildren().clear();
            ArrayList<Button> b = new ArrayList<>();
            for(int i =0; i<owners.size(); i++)
            {
                b.add(new Button(owners.get(i).getName()));
            }
            for(int i = 0; i<b.size();i++)
            {
            	int spot = i;
            	b.get(i).setOnAction(new EventHandler<ActionEvent>(){
            		@Override public void handle(ActionEvent e)
            		{
            			checkinAnimals(secondaryStage,spot);
            		}
            	});
            }
            list.getChildren().addAll(b);
            
            Button close = new Button("close");
            close.setOnAction(new EventHandler<ActionEvent>()
            		{
            	@Override public void handle(ActionEvent e)
            	{
            		
            		secondaryStage.close();
            	}
            		});
            list.getChildren().add(close);
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
            petsThere.setOnAction(new EventHandler<ActionEvent>()
            		{
            	@Override public void handle(ActionEvent e)
            	{
            		System.out.print(true);
            		showStatus(new Stage());
            	}
            		});
            
            Button bills = new Button("bills");
            bills.setOnAction(new EventHandler<ActionEvent>()
            		{
            	@Override public void handle(ActionEvent e) {
            		showBills(new Stage());
            	}
            		});

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
