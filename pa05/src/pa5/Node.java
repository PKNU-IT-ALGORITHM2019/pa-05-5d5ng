package pa5;

public class Node {
	
	Node left=null;
	Node right=null;
	Node parent=null;
	String word;
	
	String Class;
	
	String meaning;
	Node(String w,String c,String m){
		word=w;
		Class=c;
		meaning=m;
	}
	Node(){
		word=" ";
		Class=null;
		meaning=null;
	}

}
