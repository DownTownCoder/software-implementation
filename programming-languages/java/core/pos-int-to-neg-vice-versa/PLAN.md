<h2>Meta</h2>

BAEL-6964: Convert Positive Int to Negative and Vice Versa in Java

<h3>Categories</h3>

<pre>
tutorials/core-java-modules/core-java-lang-6/src/main/java/com/baeldung
class UnaryVsNegateExactBenchmark
</pre>

<pre>
tutorials/core-java-modules/core-java-lang-6/src/test/java/com/baeldung
class UnaryNegationUnitTest
class MathNegateExactUnitTest
</pre>

------------------------------------------
<h2>Convert Positive Int to Negative and Vice Versa in Java</h2>

<h2>Synopsis</h2>

Negation of numbers can useful in many areas of mathematics. For example, the manipulation of (x,y) coordinates in coordinate geometry.

------------------------------------------
<h2>Research</h2>

There are two ways to change an integer from positive to negative and vice versa:

<ol>
    <li>The unary operator</li>
    <li>Math.negateExact()</li>
</ol>

https://stackoverflow.com/questions/7869911/java-math-function-to-convert-positive-int-to-negative-and-negative-to-positive

------------------------------------------
<h2>Sections</h2>

<h3>1. Overview</h3>

Look at both ways to negate an integer. The unary operator does not throw ArithmeticException for integer overflow whereas Math.negateExact() does.

Compare both ways with a benchmark.

<h3>2. The Unary Negation Operator</h3>

<pre>
class UnaryNegationUnitTest
    void whenUnaryOperatorUsed_thenChangeSign()
    void whenTryCatchUsed_thenExceptionStringRemainsEmpty()
    void whenIntegerOverflow_thenNoExceptionThrown()
    void whenThereIsATemporaryVariable_thenChangeSign()
</pre>

<h3>3. Java's Math.negateExact() Function</h3>

<pre>
class MathNegateExactUnitTest
    void whenMathNegateExactUsed_thenChangeSign()
    whenArithmeticExceptionThrown_thenSetExceptionStringToNotEmpty()
</pre>

<h3>4. Which Method is Better?</h3>

Dependencies:

Add the following to the editor as HTML/XML code:

<pre>
<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-core</artifactId>
    <version>1.36</version>
</dependency>

<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-generator-annprocess</artifactId>
    <version>1.36</version>
</dependency>
</pre>

<pre>
class UnaryVsNegateExactBenchmark
    public static void main( String[] args ) throws Exception
    public void unaryNegate()
    public void negateExactNegate()
</pre>

<h3>5. Conclusion</h3>