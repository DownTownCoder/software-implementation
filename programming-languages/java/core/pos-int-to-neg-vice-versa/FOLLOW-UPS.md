<h2>Explanation below is wrong. See:

https://www.baeldung.com/cs/signed-vs-unsigned-variables

for correction.</h2>

<h2>Why is _Integer.MAX_VALUE_ equal to _abs(Integer.MIN_VALUE) - 1_ ?</h2>

<h3>One's Complement</h3>

Why is the absolute negative number 1 more than the positive number? e.g. why is the maximum of an 8-bit number, 127, less than the absolute value of the minimum 128?

Answer: in signed numbers, the most significant bit is used for the sign. The sign bit is set to 1 for negative numbers and 0 for positive numbers.

This is positive 127:

01111111

Unlike the human addition algorithms which enable us to carry over values to the next columns, computer memory spaces can't allow us to do that. So, if we add 1 to the binary value above, then we invert the bits to get 128, which is negative because the sign
bit is set.

10000000

In binary, this is 128, but since the sign bit is set to 1, it is -128. Setting other bits with the sign bit set gives us all the other negative numbers.

10001010, for example, is -9.
