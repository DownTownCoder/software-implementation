package com.downtowncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import com.downtowncoder.MemoryAddress;

/**
 *
 */
public class StringUnitTest {

    /**
     * We can test for the immutability of a String object by noting its memory address before and after the reassignment of the variable that holds the reference to the String object.
     */
    @Test
    void whenStringVariableIsReassigned_thenVariableGetsNewMemoryAddress() {

        MemoryAddress memoryAddress = new MemoryAddress();

        String s1 = "DownTown";
        long address1 = memoryAddress.getMemoryAddress(s1);
        s1 = "Coder";
        long address2 = memoryAddress.getMemoryAddress(s1);
        assertNotEquals( address1, address2 );

        System.out.println( address1 + "\n" + address2 );

        //String s2 = s1.toUpperCase();
        //System.out.println( s1 + "\n" + s2 );
        //System.out.println( "s1 address: " + memoryAddress.addressOf(s1) + "\n" + "s2 address: " + memoryAddress.addressOf(s2));
        //s1 = "TopCat";
        //System.out.println( "s1 address: " + memoryAddress.addressOf(s1) + "\n" + "s2 address: " + memoryAddress.addressOf(s2));

        //assertEquals( s1, s2 );
    }

    /**
     * And there's no need to worry about Java chopping up your carefully crafted String objects because they'll retain their immutability when included in a mutable StringBuffer.
     */
    @Test
    void whenStringsAreIncludedInAStringBuffer_thenThoseStringsRemainImmutable() {

        String s1 = "TopCat";
        StringBuffer stringBuffer = new StringBuffer( "DownTown" );
        stringBuffer.append(s1);
        System.out.println( stringBuffer );
        stringBuffer.reverse();
        System.out.println( stringBuffer + "\n" + s1 );
        assertNotEquals( s1, "taCpoT" );
        stringBuffer.delete( 0, 3 );
        System.out.println( stringBuffer );
        assertEquals( s1, "TopCat" );
    }

    /**
     *
     */
    @Test
    public void stringBenchmark() {

        MemoryAddress memoryAddress = new MemoryAddress();

        String[] userNameParts = { "Coder", "Cat", "Down", "Top", "Town" };
        String userName = userNameParts[2] + userNameParts[4] + userNameParts[0];
        System.out.println( userName + " @ " + memoryAddress.getMemoryAddress( userName ) );

        userName = userNameParts[0] + userNameParts[2] + userNameParts[4];

        System.out.println( userName + " @ " + memoryAddress.getMemoryAddress( userName ) );
    }

    /**
     *
     */
    @Test
    void whenAStringIsCreated_thenItCannotBeChanged() {

    }

    /**
     * ...(?? but the String will persist. ??)
     */
    @Test
    void whenAStringIsCreatedAndAssignedAReference_thenTheReferenceCanBeReassigned() {

    }

}

/*


    @Test
    void when_then() throws Exception {

        String s1 = "DownTown";
        //System.out.println( s1 + System.identityHashCode(s1) );
        s1.toUpperCase();

        String s2 = s1.toUpperCase();
        //System.out.println( s1 + "\n" + s2 );
        //System.out.println(addressOf(s1) + "\n" + addressOf(s2));

        //assertEquals( s1, s2 );


    }
 */