package pa5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	BinaryTree t=new BinaryTree();
	Scanner kb= new Scanner(System.in);
	String com;
	public static void main(String[] args) {
		Main app=new Main();
		app.process_command();

	}

	private void process_command() {

		insertdata();


		while(true) {
			System.out.print("$ ");
			com=kb.next();
			if(com.equalsIgnoreCase("find")) {

				find();

			}

			else if(com.equalsIgnoreCase("add")) {

				add();

			}
			else if(com.equals("delete")) {

				delete();
			}
			else if(com.equals("deleteall")) {

				deleteall();
			}

			else if(com.equals("size")) {

				size();
			}
			else if(com.equals("exit"))
			{
				break;
			}


		}

		kb.close();



	}

	private void find() {
		String wntfind=kb.next();

		Node wntNode=new Node();

		wntNode=t.TreeSearch(t.root,wntfind );

		if(wntNode==null)
			System.out.println("Not Found");

		else
			System.out.println(wntNode.word+": "+wntNode.meaning);


	}

	private void insertdata() { //처음 받은 모든 단어들을 이진탐색트리에 저장하기위한 함수
		try {
			Scanner Fin=new Scanner(new File("shuffled_dict.txt"));
			while(Fin.hasNext()) {

				String allstr=Fin.nextLine();
				String w,c,mean;
				int i=allstr.indexOf("(");
				int j=allstr.indexOf(")");
				w=allstr.substring(0, i);
				w=w.replaceAll(" ", "");
				if((j-i)==1) 
					c=" ";


				else 
					c=allstr.substring(i+1, j-1);

				if(j+2<=allstr.length())
					mean=allstr.substring(j+2, allstr.length());

				else mean=" ";
				//				System.out.println(w);
				//				System.out.println(c);
				//				System.out.println(mean);

				Node node=new Node(w,c,mean);
				t.TreeInsert(t, node);


				
			}
			//			t.inorder_tree(t.root);
			Fin.close();

		} 
		catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	private void deleteall() {
		String Fname=kb.next();
		int cnt=0;
		try {
			Scanner Fin =new Scanner (new File(Fname));
			
			while(Fin.hasNext()) {
				String w=Fin.nextLine();
				w=w.replaceAll(" ", "");
				Node node=new Node(w," "," ");
				node=t.TreeSearch(t.root, w);
				if(node!=null)
				t.TreeDelete(t, node);
				cnt++;
				
				
			}
			System.out.println(cnt+" words were deleted successfully.");
			
			Fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private void size() {

		int allnode=t.size(t.root);
		System.out.println(allnode);

	}

	private void delete() {
		String toDelete=kb.next();
		Node node=new Node();
		node=t.TreeSearch(t.root, toDelete);
		if(node==null)
			System.out.println("Not Found");
		else {
			t.TreeDelete(t, node);
		} 
			
		
		

	}

	private void add() {
//		String c=" ";
		System.out.print("word: ");
		String w=kb.next();
		String c=kb.nextLine();
		System.out.print("Class: ");
		 c=kb.nextLine();
	
		System.out.print("meaning: ");
		String m=kb.next();
		
		Node node=new Node(w,c,m);
		t.TreeInsert(t, node);


	}

}
