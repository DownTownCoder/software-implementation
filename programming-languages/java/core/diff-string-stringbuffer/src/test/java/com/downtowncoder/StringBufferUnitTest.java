package com.downtowncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import com.downtowncoder.MemoryAddress;

/**
 *
 */
public class StringBufferUnitTest {

    /**
     * Let's test for the mutability of a StringBuffer. First, we should note that we can't reassign a variable holding a StringBuffer reference.
     * The only way to acquire a new address is to create a new instance of StringBuffer.
     */
    @Test
    void whenStringBufferVariableIsReassigned_thenVariableRetainsOriginalMemoryAddress() {

        MemoryAddress memoryAddress = new MemoryAddress();

        StringBuffer stringBuffer = new StringBuffer( "DownTown" );
        long address1 = memoryAddress.getMemoryAddress( stringBuffer );
        stringBuffer.insert(0, "Coder" );
        assertEquals( stringBuffer.toString(), "CoderDownTown" );
        long address2 = memoryAddress.getMemoryAddress( stringBuffer );
        assertEquals( address1, address2 );

        System.out.println( stringBuffer + "\n" + address1 + "\n" + address2 );
    }

    /**
     *
     */
    @Test
    void whenAStringBufferIsCreated_thenItCanBeChanged() {

        StringBuffer stringBuffer = new StringBuffer( "DownTown" );
    }

    /**
     *
     */
    @Test
    public void stringBufferBenchmark() {

        MemoryAddress memoryAddress = new MemoryAddress();

        String[] userNameParts = { "Coder", "Cat", "Down", "Top", "Town" };
        StringBuffer userName = new StringBuffer();
        userName.append( userNameParts[2] ).append( userNameParts[4] ).append( userNameParts[0] );
        System.out.println( userName + " @ " + memoryAddress.getMemoryAddress( userName ) );

        userName.delete( 8, userName.length() ).insert( 0, "Coder" );

        System.out.println( userName + " @ " + memoryAddress.getMemoryAddress( userName ) );
    }
}
