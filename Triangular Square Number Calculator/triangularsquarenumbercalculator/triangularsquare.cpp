#include<iostream>
#include <cmath>
using namespace std;

const int COUNT=20;

int addUpto(int n){

	int total=0;  //initialize total to increment the next triangular number
	for(int i=1; i<=n; i++){
		total+=i;
		}
	return total;
}

bool isSquare(int x){

	double sqr = sqrt(x);
	return ((sqr - floor(sqr)) == 0);
}
//main function 

int main(){
	int inc = 1;
	int y=1;
	while(inc<=COUNT){
		int total = addUpto(y);
		if(isSquare(total)){
			cout << "Square Triangular Number " << inc << " is: "<< total <<endl;
			inc+=1;
		}
		y++;
	}

}

