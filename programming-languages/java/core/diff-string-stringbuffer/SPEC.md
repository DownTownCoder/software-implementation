<h2>1. Overview</h2>
We discuss the difference between <em>String</em> and <em>StringBuffer objects</em> with multithreaded applications in mind because synchronization and thread safety are properties of <em>StringBuffer.</em>

We'll compare the immutability of <em>String</em> objects and the mutability of <em>StringBuffer</em> objects because their respective impacts on performance can differ depending on the situation.

We'll also see that <em>String</em> and <em>StringBuffer</em> have advantages depending on our requirements.

<h2>n. Setting up</h2>
<h2>n. The <em>String</em> Type</h2>
We can test for the immutability of a <em>String</em> object by noting its memory address before and after a reassignment:

<pre><code class="language-java">String s1 = "DownTown";
long address1 = memoryAddress.addressOf(s1);
s1 = "Coder";
long address2 = memoryAddress.addressOf(s1);
assertNotEquals( address1, address2 );</code></pre>
If <em>String</em> objects were mutable, Java would have overwritten the memory at the first address but instead created a new <em>String</em> object at a new address.

<h2>n. The <em>StringBuffer</em> Type</h2>

Let's create a <em>StringBuffer</em> object and capture its address. We'll change the object's contents and then capture the object's address in a second variable to see whether the two addresses match.

<pre>
<code class="language-java">StringBuffer stringBuffer = new StringBuffer( "DownTown" );
long address1 = memoryAddress.addressOf( stringBuffer );
stringBuffer.insert( 0, "Coder" );
assertEquals( stringBuffer.toString(), "CoderDownTown" );
long address2 = memoryAddress.addressOf( stringBuffer );
assertEquals( address1, address2 );
</code>
</pre>

The code changes the contents of the StringBuffer object but not its memory address. This shows that the code modified the same StringBuffer object, which suggests that StringBuffer objects are mutable.
<h2>(? n. The <em>StringBuilder</em> Type ?)</h2>

<h2>n. Comparing <em>String</em> and <em>StringBuffer</em></h2>
Let's benchmark and compare two equivalent methods that use objects of <em>String</em> and <em>StringBuffer</em>, respectively, to construct a username using <em>String</em> objects as building blocks. The competing code blocks for this comparison are:

<pre><code class="language-java">String[] userNameParts = { "Coder", "Cat", "Down", "Top", "Town" };
String userName = userNameParts[2] + userNameParts[4] + userNameParts[0];</code></pre>
and
<pre><code class="language-java">String[] userNameParts = { "Coder", "Cat", "Down", "Top", "Town" };
StringBuilder userName = new StringBuilder();
userName.append( userNameParts[2] ).append( userNameParts[4] ).append( userNameParts[0] );</code></pre>
In light of our discussion so far, the result may be surprising:
<pre><code class="language-plaintext">Benchmark                                             Mode  Cnt           Score           Error  Units
StringVsStringBufferBenchmark.stringBenchmark        thrpt   25  2407336620.672 ± 137682400.113  ops/s
StringVsStringBufferBenchmark.stringBufferBenchmark  thrpt   25  2440950478.560 ± 113740021.665  ops/s
</code></pre>
The <em>stringBenchmark()</em> method comes out slightly ahead. However, as noted in the overview, <em>StringBuffer</em> is thread-safe and synchronized, which has a cost. Let's benchmark the <em>stringBenchmark()</em> method against <em>stringBuilderBenchmark()</em>:
<pre><code class="language-java">String[] userNameParts = { "Coder", "Cat", "Down", "Top", "Town" };
StringBuilder userName = new StringBuilder();
userName.append( userNameParts[2] ).append( userNameParts[4] ).append( userNameParts[0] );
</code></pre>
<h2>n. Conclusion</h2>
We've found that <em>String</em> objects are immutable, but <em>StringBuffer</em> objects are not, and that <em>String</em> and <em>StringBuffer</em> are about the same in terms of throughput, at least for simple methods.

We also saw that <em>StringBuilder</em> is more efficient than <em>StringBuffer</em> in a single-thread application. However, <em>StringBuffer</em> would be preferable because it is thread-safe.

Thank you very kindly, gentlemen. You've both made this a great experience for me! :)