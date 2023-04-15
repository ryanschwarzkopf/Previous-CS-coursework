
//this code handles the firs set of requirments
#include "std_lib_facilities.h"

void print_array10(ostream& os, int* a);
void print_array(ostream& os, int* a, int n);
void print_vector(ostream& os, int* a, int n);

int main(){
	int* array1 = new int[10];
	for(int i = 0; i<10; i++) {
		cout << array1[i];
	}
	delete[] array1;
	
	int* array2 = new int[10];
	for(int i = 0; i<10; i++) {
                array2[i] = (100 + i);
        }
	std::ostream os;
	print_array10(os, array2);

	int* array3 = new int[11];
        for(int i = 0; i<11; i++) {
                array2[i] = (100 + i);
        }
        print_array(os, array2, 11);
	
	int* array4 = new int[20];
        for(int i = 0; i<20; i++) {
                array2[i] = (100 + i);
        }
        print_array(os, array2, 20);

	delete[] array2;
	delete[] array3;
	delete[] array4;

	vector<int> v1;
	vecot<int> v2;
	vector<int> v3;
	for(int i = 0; i < 10; i++) {
		v1.push_back(100 + i);
	}
        for(int i = 0; i<11; i++) {
                v2.push_back(100 + i);
        }
        for(int i = 0; i<20; i++) {
                v3.push_back(100 + i);
        }
	print_vector(os, v1, 10);
	print_vector(os, v2, 11);
	print_vector(os, v3, 20);
}

void print_array10(ostream& os, int* a) {
	for(int i = 0; i < 10; i++) {
		os.print(a[i]);
	}
}

void print_array(ostream& os, int* a, int n) {
        for(int i = 0; i < n; i++) {
                os.print(a[i]);
        }
}

void print_vector(ostream& os, vector<int> v, int n) {
	for(int element : v) os.print(element);
}

