### 1. Overview

In this tutorial, we discuss some differences between String and StringBuffer objects. We need to be mindful of multithreaded applications because synchronization and thread safety are properties of StringBuffer.

The mutability or not of String and StringBuffer objects affects memory usage and performance.

We compare String against StringBuffer, and we also consider the StringBuilder class. StringBuilder can be a better choice than StringBuffer in certain situations.

### 2. The String Type

We can test for the immutability of a String object by noting its memory address (via reflection and the sun.misc.Unsafe class) before and after a reassignment:

```
String s1 = "DownTown";
long address1 = memoryAddress.addressOf(s1);
s1 = "Coder";
long address2 = memoryAddress.addressOf(s1);
assertNotEquals( address1, address2 );
```

If String objects were mutable, Java would have overwritten the memory at the first address, but instead, she created a new String object at a new address. The code has fly-tipped the old memory address, leaving it for the garbage collector to clean up.

Read more about String operations.

### 3. The StringBuffer Type

Let’s create a StringBuffer object and capture its memory address. We’ll change the object’s contents and then capture the object’s address in a second variable:

```
StringBuffer stringBuffer = new StringBuffer( "DownTown" );
long address1 = memoryAddress.addressOf( stringBuffer );
stringBuffer.insert( 0, "Coder" );
assertEquals( stringBuffer.toString(), "CoderDownTown" );
long address2 = memoryAddress.addressOf( stringBuffer );
assertEquals( address1, address2 );
```

We see that the code changes the contents of the StringBuffer object but not its address. This shows that the code modified the same StringBuffer object, which suggests that StringBuffer objects are mutable.

The following code shows that StringBuffer methods copy arguments to their parameters. It is these copies that the methods manipulate so that the original String objects will always remain intact when included in a mutable StringBuffer:

```
String s1 = "TopCat";
StringBuffer stringBuffer = new StringBuffer( "DownTown" );
stringBuffer.append(s1);

stringBuffer.reverse();
assertNotEquals( s1, "taCpoT" );

stringBuffer.delete( 0, 3 );
assertEquals( s1, "TopCat" );
```

### 4. Comparing String and StringBuffer

So far, we have concentrated on the mutability aspect of String and StringBuffer. String objects are constant and more suitable for storing read-only values, while StringBuffer objects are mutable and more suitable for storing changeable values.

The StringBuffer class is more versatile for insert-update-delete operations involving parts of strings because of the methods provided, while the String class provides no update methods.

Another aspect of String and StringBuffer is execution speed. Let’s benchmark and compare two equivalent methods that use objects of String and StringBuffer, respectively, to construct a username using String objects as building blocks. The methods will then rotate the parts to form a new username.

The following code uses String concatenation to build our username and rotate the parts:

```
String[] userNameParts = { "Coder", "Cat", "Down", "Top", "Town" };
String userName = userNameParts[2] + userNameParts[4] + userNameParts[0];
userName = userNameParts[0] + userNameParts[2] + userNameParts[4];
```

And here’s an alternative that uses StringBuffer:

```
String[] userNameParts = { "Coder", "Cat", "Down", "Top", "Town" };
StringBuffer userName = new StringBuffer();
userName.append( userNameParts[2] ).append( userNameParts[4] ).append( userNameParts[0] );
userName.delete( 8, userName.length() ).insert( 0, "Coder" );
```

Before we run our benchmark, we should introduce another string manipulation type – the StringBuilder class. StringBuilder is neither thread-safe nor synchronized, so we would not expect StringBuilder to have the same overhead as StringBuffer. The code for our StringBuilder method is almost identical to that of the StringBuffer method, but with "StringBuffer" replaced by "StringBuilder." (Read more about StringBuffer Vs. StringBuilder.)

Here are the results:

```
Benchmark                                               Mode  Cnt          Score         Error  Units
StringVsStringBuilderBenchmark.stringBenchmark         thrpt   25  188564738.802 ± 1542780.050  ops/s
StringVsStringBuilderBenchmark.stringBufferBenchmark   thrpt   25  160116892.243 ± 1541623.616  ops/s
StringVsStringBuilderBenchmark.stringBuilderBenchmark  thrpt   25  161196644.753 ±  424474.061  ops/s
```

Our stringBenchmark() method comes out ahead of StringBuffer and StringBuilder by some margin, and this may be surprising considering the extra work involved in copying, memory manipulation, etc., - unavoidable because of the immutability of String objects.

### 5. Conclusion

In this article, we saw that String objects are immutable, but StringBuffer objects are not, and that String is faster than StringBuffer in terms of throughput, at least for simple methods.

We also saw that StringBuilder is roughly equivalent to StringBuffer in a single-thread application, but in multithreaded applications, StringBuffer would be preferable because it is thread-safe.

All the relevant code can be found over on GitHub.