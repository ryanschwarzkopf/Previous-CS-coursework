.data
  .comm gender, 1
  .global gender
  .comm age, 1
  .global age
  .comm fat, 1
  .global fat
.text
  .global FatMonitor

FatMonitor:                 ;load age, gender, and fat. Branch by gender
  lds r18, gender
  lds r19, age
  lds r20, fat
  cpi r18, 0x0A
  breq maleBranch
  cpi r18, 0x0F
  breq femaleBranch
  ret

maleBranch:                 ;for male gender branch by age
  cpi r19, 20
  brlo exit1
  cpi r19, 39
  brlo maleAge1
  cpi r19, 59
  brlo maleAge2
  cpi r19, 79
  brlo maleAge3
  ret
femaleBranch:               ;for female gender branch by age
  cpi r19, 20
  brlo exit1
  cpi r19, 39
  brlo femaleAge1
  cpi r19, 59
  brlo femaleAge2
  cpi r19, 79
  brlo femaleAge3
  ret
exit1:
  ret

maleAge1:                 ;for males of low age, branch by bmi to the color bridge
  cpi r20, 8
  brlo bridge1Blue
  cpi r20, 20
  brlo bridge1Green
  cpi r20, 25
  brlo bridge1Red
  cpi r20, 25
  brsh bridge1All
  ret
maleAge2:                 ;for males of medium age, branch by bmi to the color bridge
  cpi r20, 11
  brlo bridge1Blue
  cpi r20, 22
  brlo bridge1Green
  cpi r20, 28
  brlo bridge1Red
  cpi r20, 28
  brsh bridge1All
  ret
maleAge3:                 ;for males of old age, branch by bmi to the color bridge
  cpi r20, 13
  brlo bridge1Blue
  cpi r20, 25
  brlo bridge1Green
  cpi r20, 30
  brlo bridge1Red
  cpi r20, 30
  brsh bridge1All
  ret

bridge1Blue:              ;for each color bridge jump to appropriate color
  jmp testfBlue           ;for lightAll jump to testf loop
  ret
bridge1Green:
  jmp testfGreen
  ret
bridge1Red:
  jmp testfRed
  ret
bridge1All:
  jmp lightAll 
  ret

femaleAge1:               ;repeat same process if female
  cpi r20, 21
  brlo bridge2Blue
  cpi r20, 33
  brlo bridge2Green
  cpi r20, 39
  brlo bridge2Red
  cpi r20, 39
  brsh lightAll
  ret
femaleAge2:
  cpi r20, 23
  brlo bridge2Blue
  cpi r20, 34
  brlo bridge2Green
  cpi r20, 40
  brlo bridge2Red
  cpi r20, 40
  brsh lightAll
  ret
femaleAge3:
  cpi r20, 24
  brlo bridge2Blue
  cpi r20, 36
  brlo bridge2Green
  cpi r20, 42
  brlo bridge2Red
  cpi r20, 42
  brsh lightAll
  ret
bridge2Blue:              ;for each color bridge jump to appropriate color
  jmp testfBlue           
  ret
bridge2Green:
  jmp testfGreen
  ret
bridge2Red:
  jmp testfRed
  ret
bridge2All:
  jmp lightAll 
  ret

lightAll:
  ldi r18, 0b00110001
  out 0x04, r18 ;0x04 is I/O for DDRB
  out 0x05, r18 ;0x05 is I/O for PORTB
  ret

testfBlue:                                  ;delay loop from test.S, used to toggle blue light
  ldi r17, 0b00100000
  out 0x04, r17 ;0x04 is I/O for DDRB
  ldi    r16, 50
allBlue:
  ldi r17, 0b00100000
  out 0x05, r17 ;0x05 is I/O for PORTB
  ldi    r18, 0xff
dl1Blue:  
  ldi    r19, 0xff
dl2Blue:  
  nop
  nop
  nop
  nop
  dec    r19
  brne   dl2Blue
  dec    r18
  brne   dl1Blue
  ldi    r17, 0x00
  out    0x05, r17
  ldi    r18, 0xff
dl3Blue:  
  ldi    r19, 0xff
dl4Blue:  
  nop
  nop
  nop
  nop
  dec    r19
  brne   dl4Blue
  dec    r18
  brne   dl3Blue
  dec    r16
  brne   allBlue
  ret

testfGreen:                                  ;delay loop from test.S, used to toggle green light
  ldi r17, 0b00010000
  out 0x04, r17 ;0x04 is I/O for DDRB
  ldi    r16, 50
allGreen:
  ldi r17, 0b00010000
  out 0x05, r17 ;0x05 is I/O for PORTB
  ldi    r18, 0xff
dl1Green:  
  ldi    r19, 0xff
dl2Green:  
  nop
  nop
  nop
  nop
  dec    r19
  brne   dl2Green
  dec    r18
  brne   dl1Green
  ldi    r17, 0x00
  out    0x05, r17
  ldi    r18, 0xff
dl3Green:  
  ldi    r19, 0xff
dl4Green:  
  nop
  nop
  nop
  nop
  dec    r19
  brne   dl4Green
  dec    r18
  brne   dl3Green
  dec    r16
  brne   allGreen
  ret
  
testfRed:                                  ;delay loop from test.S, used to toggle red light
  ldi r17, 0b00000001
  out 0x04, r17 ;0x04 is I/O for DDRB
  ldi    r16, 50
allRed:
  ldi r17, 0b00000001
  out 0x05, r17 ;0x05 is I/O for PORTB
  ldi    r18, 0xff
dl1Red:  
  ldi    r19, 0xff
dl2Red:  
  nop
  nop
  nop
  nop
  dec    r19
  brne   dl2Red
  dec    r18
  brne   dl1Red
  ldi    r17, 0x00
  out    0x05, r17
  ldi    r18, 0xff
dl3Red:  
  ldi    r19, 0xff
dl4Red:  
  nop
  nop
  nop
  nop
  dec    r19
  brne   dl4Red
  dec    r18
  brne   dl3Red
  dec    r16
  brne   allRed
  ret
