#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <inttypes.h>
#include <limits.h>

extern byte val;
extern byte width;
extern byte ascii;

int my_global_counter = 0;

extern "C" { 
  void decode_morse();
  //void Eureka();
}

//
// function to read a 2-digit decimal value from user
//
byte read2DigitValue()
{
  byte inch; int val;
  Serial.println("Enter a 2-digit decimal value:");
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  val = (inch - '0') * 10;
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  val += (inch - '0');
  Serial.print("The value entered is ");
  Serial.println(val,DEC);
  return (byte) val;
}
/********************************************************************************************
void flashEureka() 
{
  // Add you code here
  val = read2DigitValue();
  for(int i=0;i<val;i++) {
    Eureka();
  }
  // You will call the Eureka() function in assembly
}
******************************************************************************************/

void decodeMorse(const String & string, char message[])
{
  // Write your code below.
  // string contains the input binary string separated by single spaces
  // message contains the decoded English characters and numbers    
  // You will call the assembly function decode_morse()
  
  // iterate over string if 0 or 1, we add it to a temporary string
  // after a space: translate temp string to binary and set to val. Call MorseCode()

  val = 0;
  for(int i=0; i<string.length(); i++) {
    if(string[i]=='1') {
      width++;
      val = val*2 + 1;
    } else if(string[i]=='0') {
      width++;
      val = val*2;
    } else if(string[i] == ' ' || string[i] == '\0') {
      my_global_counter++;
      decode_morse();
      message[my_global_counter] = ascii;
      val = 0;
      width = 0;
    }
  } // end for
}

void decodeMorse() 
{
  Serial.println("Input a Morse code string (separate the code for characters by a space):");

  while (!Serial.available()) delay(100);
  String string = Serial.readString();

  Serial.print("The Morse code string is: ");
  Serial.println(string);

  char message[100];

  decodeMorse(string, message);

  if(strlen(message) > 0) {
    Serial.print("The decoded message is: ");
    for(int i = 1; i < my_global_counter+1; i++) {
      Serial.print(message[i]);
    }
    
  } else {
    Serial.print("Failure in decoding the input Morse code\n");
  }  
}

void setup() {
  //
  // Initialize serial communications
  //
  Serial.begin(9600);

  //flashEureka();

  decodeMorse();
  
}

void loop() {
  // put your main code here, to run repeatedly:
  delay(20000); // 20,000 millisecs == 20 seconds
  Serial.println("*");
}
