package com.downtowncoder;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 *
 */
public class MemoryAddress {

    public long getMemoryAddress( Object object ) {

        Object[] array = new Object[]{object};
        Unsafe unsafe = null;

        try {
            Field field = Unsafe.class.getDeclaredField( "theUnsafe" );
            field.setAccessible( true );
            unsafe = (Unsafe) field.get( null );
        } catch ( NoSuchFieldException | IllegalAccessException e ) {
            e.printStackTrace();
        }

        assert unsafe != null;
        long baseOffset = unsafe.arrayBaseOffset( Object[].class );
        int addressSize = unsafe.addressSize();
        long objectAddress = 0;

        if( addressSize == 4 ) {
            objectAddress = unsafe.getInt( array, baseOffset );
        } else {
            if( addressSize == 8 ) {
                objectAddress = unsafe.getLong( array, baseOffset );
            } else {
                throw new Error( "Error: Size not supported: " + addressSize );
            }
        }

        return objectAddress;
    }

}




        /*
        switch ( addressSize ) {
            case 4:
                objectAddress = unsafe.getInt( array, baseOffset );
                break;
            case 8:
                objectAddress = unsafe.getLong( array, baseOffset );
                break;
            default:
                throw new Error( "unsupported address size: " + addressSize );
        }
        */

/*
import java.lang.reflect.Field;
import sun.misc.Unsafe;

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

    public static long addressOf(Object o) throws NoSuchFieldException {
        Unsafe unsafe = null;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Object[] array = new Object[]{o};

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;

        switch (addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }
        return objectAddress;
    }
 */