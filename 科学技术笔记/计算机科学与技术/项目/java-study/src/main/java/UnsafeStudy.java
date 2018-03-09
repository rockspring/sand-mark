import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteOrder;

/**
 * Created by zlq on 4/5/17.
 */

/**
 * Utility class for memory operations.
 */

class MemoryUtils {

    /**
     * The "unsafe", which can be used to perform native memory accesses.
     */
    @SuppressWarnings("restriction")
    public static final sun.misc.Unsafe UNSAFE = getUnsafe();

    /**
     * The native byte order of the platform on which the system currently runs.
     */
    public static final ByteOrder NATIVE_BYTE_ORDER = ByteOrder.nativeOrder();

    /**
     * Should not be instantiated
     */
    private MemoryUtils() {
    }

    @SuppressWarnings("restriction")
    private static sun.misc.Unsafe getUnsafe() {
        try {
            Field unsafeField = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            return (sun.misc.Unsafe) unsafeField.get(null);
        } catch (SecurityException e) {
            throw new RuntimeException("Could not access the sun.misc.Unsafe handle, permission denied by security manager.", e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("The static handle field in sun.misc.Unsafe was not found.");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Bug: Illegal argument reflection access for static field.", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Access to sun.misc.Unsafe is forbidden by the runtime.", e);
        } catch (Throwable t) {
            throw new RuntimeException("Unclassified error while trying to access the sun.misc.Unsafe handle.", t);
        }
    }
}


public class UnsafeStudy {
    private static Unsafe getUnsafe() throws Exception {
// Get the Unsafe object instance
        Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (sun.misc.Unsafe) field.get(null);
    }

    public static void showBytes() {
        try {
            Unsafe unsafe = getUnsafe();

// Writing to a memory - MAX VALUE Byte
            byte value = Byte.MAX_VALUE;
            long bytes = 1;
// Allocate given memory size
            long memoryAddress = unsafe.allocateMemory(bytes);
// Write value to the allocated memory
            unsafe.putAddress(memoryAddress, value); // or putByte

// Output the value written and the memory address
            System.out.println("[Byte] Writing " + value + " under the " + memoryAddress + " address.");

            long readValue = unsafe.getAddress(memoryAddress); // or getByte

// Output the value from
            System.out.println("[Byte] Reading " + readValue + " from the " + memoryAddress + " address.");

// C style! Release the Kraken... Memory!! :)
            unsafe.freeMemory(memoryAddress);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void showLong() {
        try {
            Unsafe unsafe = getUnsafe();

// Writing to a memory - MAX VALUE of Long
            long value = Long.MAX_VALUE;
            long bytes = Long.SIZE;
// Allocate given memory size
            long memoryAddress = unsafe.allocateMemory(bytes);
// Write value to the allocated memory
            unsafe.putLong(memoryAddress, value);

// Output the value written and the memory address
            System.out.println("[Long] Writing " + value + " under the " + memoryAddress + " address.");

// Read the value from the memory
            long readValue = unsafe.getLong(memoryAddress);

// Output the value from
            System.out.println("[Long] Reading " + readValue + " from the " + memoryAddress + " address.");

// C style! Release the Kraken... Memory!! :)
            unsafe.freeMemory(memoryAddress);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        //Unsafe unsafe = Unsafe.getUnsafe();
        //unsafe.addressSize();

        Unsafe unsafe = MemoryUtils.UNSAFE;

        System.out.println(unsafe.addressSize());
        System.out.println(unsafe.allocateMemory(1));
        int i = unsafe.getInt(unsafe.allocateMemory(10));
        unsafe.putLong(unsafe.allocateMemory(1), 1000000000);
        System.out.println(i);
       final long BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
       System.out.println(BYTE_ARRAY_BASE_OFFSET);

    }
}
