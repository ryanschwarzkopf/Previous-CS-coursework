.equ DIDR0, 0x007E
.equ ADMUX, 0x007C
.equ ADCSRA, 0x007A
.equ ADCH, 0x0079
.equ RAMEND, 0x10FF
.equ SPH, 0x3E
.equ SPL, 0x3D
.equ OCR1AL, 0x88
.equ OCR1AH, 0x89
.equ TCNT1L, 0x84
.equ TCNT1H, 0x85
.equ TCCR1A, 0x80
.equ TCCR1B, 0x81
.equ OCF1A, 1
.equ TIFR1, 0x16

.data

.text
.global initSensor
.global readSensor
.global waitOneSecond

initSensor:
  LDI R20, 0b00111111
  STS DIDR0, R20            ;ADC0-5 to 1(disable digital input buffer for adc pins)
  LDI R20, 0b10000111       ;ADEN to 1(enable adc), ADPS to 111(system clock to input clock prescalar 1/128)
  STS ADCSRA, R20
  RET

readSensor:
  LDI R20, 0b01100000       ;REFS1-REFS0 to 01(voltage reference: external capacitor(5V)), ADLAR to 1(left adjusted)
  OR R20, R24               ;set MUX0-3 via parameter in r24(pin input)
  STS ADMUX, R20
  LDS R20, ADCSRA
  ORI R20, 0b01000000       ;ADSC to 1(start conversion)
  STS ADCSRA, R20
LOOP1:
  LDS R20, ADCSRA
  SBRC R20, 6               ;Check ADSC turns 0 ////////////////////////////
  JMP LOOP1
  LDS R24, ADCH             ;return high 8 bits of adc because we adjusted left(ignore lower 2 bits)
  CLR R25
  RET

waitOneSecond:
  ;LDI R20, 0x10               ;HIGH(RAMEND)
  ;OUT SPH, R20
  ;LDI R20, 0x3D               ;LOW(RAMEND)
  ;OUT SPL, R20
  LDI R20, hi8(-15625)                ;16MHz/1024 = 15625 = 0x3D09
  STS TCNT1H, R20
  LDI R20, lo8(-15625)
  STS TCNT1L, R20
  LDI R20, 0
  ;STS TCNT1H, R20
  ;STS TCNT1L, R20             ;TCNT1 = 0
  STS TCCR1A, R20
  LDI R20, 0x5
  STS TCCR1B, R20             ;Normal mode, prescalar: 1/1024
AGAIN:
  SBIS TIFR1, 0               ;OCF1A
  RJMP AGAIN
  LDI R20, 0
  STS TCCR1B, R20             ;Stop timer
  STS TCCR1A, R20
  LDI R20, 1
  OUT TIFR1, R20
  RET
