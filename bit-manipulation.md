 # AND

    AND is true when both are true.
    
    AND of zero and a bit results in 0

    0 & x = 0

    AND of one and a bit keeps the bit as it is

    1 & x = x
    
# OR

    OR is false when both are false.

    OR of zero and a bit results into same bit.

    0 | x = x

    OR of one and a bit results in 0

    1 | x = 1


# XOR

    XOR is true when both are different

    XOR of zero and a bit results in that bit

    0 ⊕ x = x

    XOR of one and a bit flips that bit

    1 ⊕ x = 1−x


# Right and left Shift (>>/<<):
Left shift multiplies a number by 2

Right shift divides a number  by 2. 

These are called left/right shift operations as they shift the numbers when represented in their binary format to left/right. 

Eg.
19 : 10011
(19>>2) : 100
This divides 19 by 4.

Below notes taken from [YT](https://www.youtube.com/watch?v=MiJdgxTWaFs)

# Get bit
``` 
n = 0101 = 5

suppose we need to get bit at position, i=2

1<<i = 0100
0101 & 0100 = 0100

if n & (1<<i) !=0 , then bit is 1
```

``` c++
int getBit(int n, int pos)
{
    return ((n & (1<<pos))!=0);
}
```

# Set bit
set bit means 1 and unset bit means 0
```
n =0101 =5
suppose we need to set bit at position, i=1

1<<i = 0010
0101 | 0010 = 0111

```
``` c++
int setBit(int n, int pos)
{
    return ((n | (1<<pos));
}
```

# Clear bit
make given position bit 0 i.e. unset bit
```
n =0101
suppose we need to clear bit at position, i =2
1<<i = 0100
~0100 = 1011

0101 & 1011 = 0001

```
``` c++

int clearBit(int n, int pos){
int mask = ~(1<<pos);
return (n & mask);
}
```
# Update Bit
update given position bit with given value

```
n = 0101
Suppose we need to update bit at position, i=1 to 1
// clear bit
1<<i = 0010
~0010 = 1101
0101 & 1101 = 0101
// set bit
1<<i = 0010
0101 | 0010 = 0111
```
``` c++
int updateBit(int n , int pos, int value)
{
    int mask - ~(1<<pos);
    n = n & mask;
    return (n | (value<<pos));
}

```



