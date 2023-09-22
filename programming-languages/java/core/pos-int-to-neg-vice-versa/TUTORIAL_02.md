<h2>1. Overview</h2>

There are two methods of negation:

<ol>
 	<li>Negation using the unary negation operator. This corresponds to a solution that a mathematician might provide. There are no checks for range exceptions, and infinity is often within range.</li>
 	<li>Negation using a function. A programmer is likely to be more aware of the limitations of data types. Java's Math class provides the negateExact() method that throws an exception if a value is out of range. However, after the exception value is reached, even the negateExact() method sticks on the </li>
</ol>

It is interesting to note that:

<ul>
 	<li>Negation multiplies a value by -1.</li>
 	<li>Negating a positive integer an odd number of times gives a negative integer, while an even number of negations retains the integer's positivity.</li>
</ul>

<h2>2. Mathematical Negation</h2>

If there's an even number of minus signs to the left of the value, then move right that number of times, otherwise move left.

Take out an even number of minus signs and replace them with a plus sign.

5--8 -> 5 + 8 = 13

5-2 = 3

-5---8 -> -5 + -8 -> -5 - 8 = -13

--5---8 -> 5 + -8 -> 5 - 8 = -3

Here's another test involving a temporary variable:

<pre><code class="language-java">int x = 10;
int y = -x;
assertEquals( -y, x );</code></pre>

Unary negation fails without warning when it operates on <em>Integer.MIN_VALUE</em>:

<h2>3. Programmatic negation</h2>

<h2>4. Conclusion</h2>