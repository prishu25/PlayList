package playListPackage;
/* package whatever; // don't place package name! */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Collections;
import java.util.Scanner;
public class Playlist {
	//variable to store previous played song
	 static String fileSavedSong="";
	 //First change the file address before running the code
	 static File file = new File("C:\\Users\\Karna\\Desktop\\workpace\\PlayListApplication\\src\\playListPackage\\playlist.txt");
	public static void main(String[] args) {
		//Try block search for any previous saved song ,when u have last closed the application	 
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			fileSavedSong = (String)br.readLine();
            br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//Making playlist of songs.
		//You can add more song to test
		List<String> songs=new ArrayList<String>();
		songs.add("A");
		songs.add("B");
		songs.add("C");
		songs.add("D");
		songs.add("E");
		songs.add("F");
		songs.add("G");
		songs.add("H");
		songs.add("I");
		songs.add("J");
		songs.add("K");
		songs.add("L");
		songs.add("M");
		System.out.println("Shuffling your track and Seeing for ur last track played......");
		try {
		Thread.sleep(1000);
		}
		catch(Exception e)
		{
		  e.printStackTrace();	
		}
		//Shuffling Songs in PlayList
		Collections.shuffle(songs);
		//Checking Some Song saved in file or Not
		if(fileSavedSong!=null)
		{
		System.out.println(fileSavedSong+" was Last Song Played");
		}
		else
		{
			System.out.println("No Last song played found");
		}
		//Checking Saved Song Present in the playlist
		if(songs.contains(fileSavedSong))
		{
			int indexOfFileSavedValue=songs.indexOf("A");
		    songs.remove(indexOfFileSavedValue);
		    songs.add(0, fileSavedSong);
		}
		else
		{
			System.out.println("May be Last Song Saved in Database is Deleted by You.");
			System.out.println("So We start from First Song From the playlist");
		}
		//I have taken index variable to iterate through playlist
		int index=0;
		Scanner input=new Scanner(System.in);
		//Loop to iterate through playlist
		while( index<songs.size()+1)
		{
			try {
				//check condition when index==0
				if(index==0)
				{
					String song=songs.get(index);
					System.out.println(song+" Songs start playing.....");
					System.out.println("Previous Button Is disable since No Previous Song available");
				    System.out.println("Press \n2: Next Song\n3: Exit");
				     FileWriter fw = new FileWriter(file);
					 BufferedWriter bw  = new BufferedWriter(fw);
					 bw.write(song);
					 bw.close();
				    int x=input.nextInt();
				    if(x==2)
					{
						  index=playnext(song,songs,index);
					}
				    else if(x==3)
					   {
						  System.exit(0);
					   }
				}
				//check condition when index>0 && index<songs.size()-1
				else if(index>0 && index<songs.size()-1) 
				  {
					  String song=songs.get(index);
					  System.out.println(song+" Songs start playing.....");
                      System.out.println("Press \n1: Previous Song \n2: Next Song\n3: Exit");
                      FileWriter fw = new FileWriter(file);
             		 BufferedWriter bw  = new BufferedWriter(fw);
             		 bw.write(song);
             		 bw.close();
					   int x=input.nextInt();
					   if(x==1)
					   {
						   index=playprevious(song,songs,index);
					   }
					   else if(x==2)
					   {
						  index=playnext(song,songs,index);
					   }
					   else if(x==3)
					   {
						  System.exit(0);
					   }
					}
				//check condition when index>0 && index<songs.size()-1
				else if(index==songs.size()-1)
				{
					String song=songs.get(index);
					System.out.println(song+" Songs start playing.....");
					System.out.println("Next Button Is disable since No Next Song available");
					System.out.println("You have reached the end of song so either exit the application or ");
				    System.out.println("Press \n1: Previous Song\n3: Exit ");
				     FileWriter fw = new FileWriter(file);
					 BufferedWriter bw  = new BufferedWriter(fw);
					 bw.write(song);
					 bw.close();
				    int x=input.nextInt();
					if(x==1)
					{
						  index=playprevious(song,songs,index);
					}
					 else if(x==3)
					   {
						  System.exit(0);
					   }
				}
					
		}
		catch(IOException e)
			{
			  e.printStackTrace();
			}
		}
		
	}
	//Function to play previous Song
	static int playprevious(String song, List<String> songs,int index) throws IOException{
    	
    	 index=index-1;
    	 System.out.println(song +" Songs ended");
    	 
    	 return index;
		
	}
    //Function To play Next Song
	static int playnext(String song, List<String> songs,int index ) throws IOException {
		 index=index+1;
		 System.out.println(song +" Songs ended");
		
		 return index;
		
	}
}

