#include<iostream>
#include <cmath>
using namespace std;

const int NUM=20; //'trying' up to 20 numbers

int starter(int n){

	int total=0;  //initialize total to increment the next triangular number
	for(int i=1; i<=n; i++){ //(n(n+1))/2
		total+=i;
	}
	return total;
}

bool isSquare(int x){ //representing x^2

	double sqr = sqrt(x);
	return ((sqr - floor(sqr)) == 0); //floor function will calculate highest possible integer value
}
//main function 

int main(){
	int inc = 1; //increment 
	int y=1;
	while(inc<=NUM){        
		int total = starter(y);
		if(isSquare(total)){
			cout << "Square Triangular Number " << inc << " is: "<< total <<endl;
			inc+=1;
		}
		y++;
	}

}

//returns: 
/* Square Triangular Number 1 is: 1
Square Triangular Number 2 is: 36
Square Triangular Number 3 is: 1225
Square Triangular Number 4 is: 41616
Square Triangular Number 5 is: 1413721
Square Triangular Number 6 is: 48024900
*/
