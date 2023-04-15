.file "Eureka.S"
.data
  .comm loopNum, 1
  .global loopNum
.text
  .global Eureka
.extern delay


.macro pushall
push r16
push r17
push r18
push r19
push r20
push r21
push r22
push r23
push r24
push r25
push r26
push r27
push r28
push r29
push r30
push r31
.endm ; of pushall

.macro popall
pop r31
pop r30
pop r29
pop r28
pop r27
pop r26
pop r25
pop r24
pop r23
pop r22
pop r21
pop r20
pop r19
pop r18
pop r17
pop r16
.endm ; of popall

start:
  ldi r17, 0x20       ;set register to arduino led
  out 0x04, r17       ;ddrb for led is output
  ret
dot:
  out 0x05, r17       ;turn light on
  pushall
  ldi  r22, 0xF4     ;set parameter to 1 time unit (60 ms): 3C, B4, 1A4 (500 ms): 1F4, 5DC, 1086
  ldi  r23, 0x01
  ldi  r24, 0x00
  ldi  r25, 0x00
  call delay          ;delay 1 time unit
  popall
  out 0x05, 0         ;turn light off
  pushall
  ldi  r22, 0xF4     ;set parameter to 1 time unit (60 ms)
  ldi  r23, 0x01
  ldi  r24, 0x00
  ldi  r25, 0x00
  call delay          ;delay 1 time unit
  popall
  ret
dash:
  out 0x05, r17       ;turn light on
  pushall
  ldi  r22, 0xDC     ;set parameter to 3 time units (180 ms)
  ldi  r23, 0x05
  ldi  r24, 0x00
  ldi  r25, 0x00
  call delay          ;delay 3 time units
  popall
  out 0x05, 0         ;turn light off
  pushall
  ldi  r22, 0xF4     ;set parameter to 1 time unit (60 ms)
  ldi  r23, 0x01
  ldi  r24, 0x00
  ldi  r25, 0x00
  call delay          ;delay 1 time unit
  popall
  ret
letter_delay:
  pushall
  ldi  r22, 0xDC     ;set parameter to 3 time units (180 ms)
  ldi  r23, 0x05
  ldi  r24, 0x00
  ldi  r25, 0x00
  call delay          ;delay 3 time units
  popall
  ret
space_delay:
  pushall
  ldi  r22, 0x86     ;set parameter to 7 time units (420 ms)
  ldi  r23, 0x10
  ldi  r24, 0x00
  ldi  r25, 0x00
  call delay          ;delay 7 time unit
  popall
  ret
stop:
  ldi r17, 0x00       ;set all registers to off
  out 0x04, r17       ;ddrb for led is output
  out 0x05, r17       ;turn light off
  ret
  
Eureka:               ;eureka = ". ..- .-. . -.- .-" 
  call start
  call dot
  call letter_delay
  call dot
  call dot
  call dash
  call letter_delay
  call dot
  call dash
  call dot
  call letter_delay
  call dot
  call letter_delay
  call dash
  call dot
  call dash
  call letter_delay
  call dot
  call dash
  call space_delay
  call stop
  ret
