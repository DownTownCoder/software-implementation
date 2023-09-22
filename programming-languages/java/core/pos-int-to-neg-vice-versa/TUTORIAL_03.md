<h2>1. Overview</h2>
In this tutorial, we'll look at two methods of converting the signs of integers:
<ol>
 	<li>Negation using the unary negation operator without any checks for range exceptions.</li>
 	<li>Negation that uses a function that throws an exception if a value is out of range.</li>
</ol>
We'll also compare the two methods with a simple benchmark.






<h2>2. The Unary Negation Operator</h2>

The easiest way to change the sign of any number is to apply the unary negation operator to it. We see that a negation of a negation works and that an <em>int</em> can alternate between positive and negative with the same assignment, which is useful when working within loops:

<pre><code class="language-java">int x = 10;
x = -x;
assertEquals( x, -10 );
x = -x;
assertEquals( x, 10 );
x = -x;
assertEquals( x, -10 );</code></pre>

Note that the minimum value of an Integer, Integer.MIN_VALUE is -2147483648, and this negates to 2147483648, greater than Integer.MAX_VALUE of 2147483647, which would constitute an Integer overflow. Furthermore, such an attempt to assign a value above the Integer.MAX_VALUE fails without warning:

<pre><code class="language-java">int x = Integer.MIN_VALUE;
x = -x;
assertEquals( x, Integer.MIN_VALUE );
assertEquals( -x, Integer.MIN_VALUE );
assertEquals( x, -x );</code></pre>

When attempting <em>x = -x</em>, the negation fails because there's no room for 2147483648, and the value of <em>x</em> remains at -2147483648. When we try to negate <em>x</em> in the tests with <em>-x</em>, the negations fail and return <em>
Integer.MIN_VALUE</em>.

Nor does the unary operator throw an <em>ArithmeticException</em> when attempting to negate <em>Integer.MIN_VALUE</em>:

<pre><code class="language-">String exception = "";

try {
    int x = Integer.MIN_VALUE;
    x = -x;
} catch( ArithmeticException e ) {
    exception = e.getMessage();
}

assertTrue( exception.isEmpty() );</code></pre>

We would need to define an <em>if-statement</em> and throw the exception ourselves.









<h2>3. Java's <em>Math.negateExact()</em> Function</h2>

As with the unary operator, we can use <em>Math.negateExact()</em> to negate a negation and see that an <em>int</em> can alternate between positive and negative with the same assignment:
<pre><code class="language-java">int x = 10;
x = Math.negateExact(x);
assertEquals( x, -10 );
x = Math.negateExact(x);
assertEquals( x, 10 );
x = Math.negateExact(x);
assertEquals( x, -10 );
</code></pre>
Our next test will define an empty string to hold an <em>ArithmeticException</em> message and then attempt to negate <em>Integer.MIN_VALUE</em>. If we pass <em>Integer.MIN_VALUE</em> to <em>Math.negateExact()</em>, Java will throw an <em>
ArithmeticException</em>. Let's attempt to return a value above <em>Integer.MAX_VALUE</em>:
<pre><code class="language-java">String exception = "";

try {
    int x = Integer.MIN_VALUE;
    x = Math.negateExact(x);
} catch( ArithmeticException e ) {
    exception = e.getMessage();
}

assertFalse( exception.isEmpty() );</code></pre>
Notice that all we needed to do here was to provide the <em>try-catch</em> statement.
<h2>4. Which Method is Better</h2>
Let's run a simple benchmark to see whether one method is better using the JMH (Java Microbenchmark Harness). We can find out how to set this up <a href="https://www.baeldung.com/java-microbenchmark-harness#start">here</a>.<code class="language-xml"></code>

We'll compare the following two code blocks:
<pre><code class="language-java">int x = 100;
int y = -x;</code></pre>
<pre><code class="language-java">int x = 100;
int y = Math.negateExact(x);</code></pre>
Comparison of throughput performance between the unary negation operator and <em>Math.negateExact()</em>
<pre> Benchmark                Mode  Cnt           Score           Error  Units
 Main.negateExactNegate  thrpt   25  2456524511.733 ± 134146059.353  ops/s
 Main.unaryNegate        thrpt   25  2297133004.478 ± 162809671.980  ops/s
</pre>
<em>Math.negateExact()</em> appears to come out ahead. However, using their error values, we calculate an overlap of -1376 ops/s between their respective throughputs.


<h2>5. Conclusion</h2>
We've shown that converting an <em>int</em> between positive and negative is not as simple as it first appears, and we've found that:
<ul>
 	<li>The unary operator is easier to use.</li>
 	<li>The <em>Math.negateExact()</em> method is harder to code but provides exception handling.</li>
 	<li>Our simple benchmark shows that <em>Math.negateExact()</em> has more efficient throughput, but there's no clear daylight between the two methods.</li>
</ul>
As usual, you'll find the relevant code <a href="https://github.com/eugenp/tutorials/tree/master/core-java-modules">on GitHub</a>.