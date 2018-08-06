
public class Mahesh {
	public static void main(String[] args) {
		 String str = "Maheesh";
		 System.out.println("sssssssssssss");
		 int n = str.length();
		 String rev = "";

		 for (int i = 0; i < n ; i++) {
			int k = 0;
		 	for(int j=i+1 ; j < n ; j++){
		 	if (str.charAt(i)  == str.charAt(j)) {
		 		k=1;
		 		break;
		 	}
		 }
		 	if(k == 0)
		 	rev = rev + str.charAt(i);
		 }
		 System.out.println(rev);
	}
}
