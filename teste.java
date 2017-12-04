
public class Solutions{
	//Euclidean.md
	//For this solution I used concepts of module, floor and ceiling of mathematics, but I admit I have found the formula through trial and error
	public int NumberOfCocolates(int n, int m){
		m= m%n;
		return ((n%m)*(n/m +1))+((m-n%m)*(n/m));
	}

	//array.md


	//For this solution I used concept of commutativity and associativity of XOR operator.
	//I have considered that a number can only pair only once, that is, if it repeats a number an odd number, one of them will be unparalleled

	public int NotPairedNumber(int[] A){
		int teste;
		teste= A[0];
		for (int i=1; i<n.length; i++){
			teste= (int)teste^A[i];		
		}
		return teste;
	}

	//dustinct.mc
	//For this function I adopted de quickSort algorithm(because it's faster) and count +1 when find 2 consecutive different numbers

	public int DistincNumbers(int[] A){
		quickSort(A);
		int count=1;
		teste= A[0];
		for (int i=1; i<n.length; i++){
			if(A[i-1]!=A[i]){
				count++;
			}	
		}
		return count;
	}
}
