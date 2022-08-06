package medical.TEAm;

import org.testng.annotations.Test;
import org.w3c.dom.ls.LSException;

public class array {
	
	@Test
	public void array() {
		int largest_no_in_array = 0;
		int la[]= {2,5,2,3,4};
		for(int i=0;i<la.length;i++) {
			for(int j=0;j<la.length;j++) {
				if(la[i]>=la[j]) {
					largest_no_in_array=la[i];
				}
			}
			for(int l=0;l<la.length;l++) {
				if(largest_no_in_array<la[l]) {
					largest_no_in_array=la[l];
				}
			}
			
			
		}
		System.out.println(largest_no_in_array);
	}
	

}
