<h1>Negating Positive and Negative Integers in Java</h1>

<h2>1. Overview</h2>

two methods. unary negation operator. corresponds to a solution that a mathematician might provide. negation multiplies a value by -1. no checks for exceptions. even infinity is within range.

a programmer is likely to be more aware of the limitations of data types. Math library's negateExact() method. throws exception if value is out of range.

<h2>2. The Unary Negation Operator</h2>

negating a positive number makes the number negative. negating a negative number makes it positive.

the following test shows that you will get no warning that <em>num</em> is out of range. <em>num</em> will stick on 128 despite your intention to assign it to a higher number:

<pre>
<code language="Java">
for( int i = 1; i <= 140; i++ ) {

}
</code>
</pre>

<h2>3. Java's Math.negateExact() Function</h2>

For any integer x, -x is of course the correct theoretical solution, but computers have limitations such as minimum and maximum boundaries for numeric types.

Math.negateExact() can be used on any of the integer types: byte, short, int and long. Here we test the MIN and MAX values for each. It will throw an exception if its result overflows in int. so, for example, if we're going through a set of numbers

with -x, setting the value of the integer outside the boundaries will not give you your value, but nor will it give you the exception so you can deal with it.

<h2>4. Conclusion</h2>

Apart from the exception, there doesn't appear to be much difference between the unary negation operator and Math.negateExact(). Let's see which is faster. <a href="https://www.baeldung.com/java-microbenchmark-harness">Benchmarking</a>

### Run complete. Total time: 00:16:48

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

NOTE: Current JVM experimentally supports Compiler Blackholes, and they are in use. Please exercise
extra caution when trusting the results, look into the generated code to check the benchmark still
works, and factor in a small probability of new VM bugs. Additionally, while comparisons between
different JVMs are already problematic, the performance difference caused by different Blackhole
modes can be very significant. Please make sure you use the consistent Blackhole mode for comparisons.

Benchmark Mode Cnt Score Error Units
Main.negateExactNegate thrpt 25 2456524511.733 ± 134146059.353 ops/s
Main.unaryNegate thrpt 25 2297133004.478 ± 162809671.980 ops/s

<h1>Notes</h1>

Negating Positive and Negative Integers in Java (original title: Convert Positive Int to Negative and Vice Versa in Java)

In programming, negating a signed integer changes its sign.

Negating a positive integer an odd number of times gives a negative integer, while an even number of negations gives a positive integer.

-x is of course the correct theoretical solution. but when scientists come down to the building site where implementation takes place, they find that

show why this is not the right way. suggest the Math.negateExact() method. catch the exception.

show the difference between the engineering and building departments.

but just as a construction engineer doesn't have intimate knowledge and skills related to a joiner's toolbox, not do software engineers know as much about the finer details related to the programmer's tools.

create a method, or class, which converts any of the integer types, byte, short, int and long (which is what the OP asked for).

all integer types in Java are signed by default. this is all we'll consider.

byte: -127 - 127

there is an implicit 1 in front of a variable. there is also an implicit 1 after the negation operator. therefore, -1(1x)