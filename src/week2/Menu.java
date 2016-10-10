package week2;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
	static Scanner kb = new Scanner(System.in);
	static int level = 0;
	static int choice;
		
	public static void banner(){
		System.out.println("+--------------------------------------------------------+");
		System.out.println("|                                                        |");
		System.out.println("|       _____ _   _____      _   _     _ _               |");
		System.out.println("|   __ / / _ | | / / _ |    /_\\ (_)_ _| (_)_ _  ___ ___  |");
		System.out.println("|  / // / __ | |/ / __ |   / _ \\| | '_| | | ' \\/ -_|_-<  |");
		System.out.println("|  \\___/_/ |_|___/_/ |_|  /_/ \\_\\_|_| |_|_|_||_\\___/__/  |");
		System.out.println("|                                                        |");
		System.out.println("+--------------------------------------------------------+");
	}	
	public static void setChoice(){
		do{
//			clearConsole();
			banner();
			String menuList[][]	= {	{	"---- MAIN MENU ----\n",
										"Fleet Management Menu",
										"Human Resource Mangement Menu",
										"Quit"	},
										
									{	"---- FLEET MANAGEMENT ----\n",
										"List fleet", 
										"List fleet by speed", 
										"List fleet by range",
										"Add a jet to fleet", 
										"Retire a jet from fleet", 
										"Main menu" },
										
									{	"---- HUMAN RESOURCES ----\n",
										"List pilots",
										"Add a pilot", 
										"Remove a pilot",
										"Assign pilot to jet", 
										"Main menu" }};
	
			for (int i = 0; i < menuList[level].length; i++){
				if(i > 0){
					System.out.printf(" %1$2s. ", i);
				}
				System.out.println(menuList[level][i]);			
			}
			System.out.print("\n>>");
			choice = kb.nextInt();
			if (level != 0 && choice == menuList[level].length - 1){
				level = 0;
			}else if(level == 0 && (choice > 3 || choice < 1)){
				System.out.println("That choice is invalid.");
			}
			else if(level == 0 && choice != 3){
				level = choice;
			} else if(level == 1){
				Fleet.menu(choice);
			}
			else if(level == 2){
				PersonnelList.menu(choice);
			}
		} while (!(level == 0 && choice == 3));
	}
	public static int getChoice() {
		return choice;
	}
    
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
}

