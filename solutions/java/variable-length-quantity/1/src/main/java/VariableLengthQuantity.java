import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class VariableLengthQuantity {

    private static final int CONTINUATION_BIT = 0x80; // 1000 0000 (bit #7 set)
    private static final int SEVEN_BIT_MASK = 0x7F;   // 0111 1111 (first 7 bits)

    /**
     * Encodes a list of unsigned 32-bit integers into a list of hexadecimal byte strings
     * using Variable Length Quantity (VLQ) encoding.
     *
     * @param numbers A list of Long values representing unsigned 32-bit integers to encode.
     * @return A list of Strings, where each string is a two-character hexadecimal representation of an encoded byte with "0x" prefix (e.g., "0x00", "0x40", "0x81").
     * @throws IllegalArgumentException if any number is negative.
     */
    List<String> encode(List<Long> numbers) {
        if (numbers == null) {
            return Collections.emptyList();
        }

        List<Integer> encodedBytesInts = new ArrayList<>(); // Internal list to build byte values as ints
        for (Long number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("Numbers to encode must be non-negative.");
            }

            if (number == 0) {
                encodedBytesInts.add(0);
                continue;
            }

            List<Integer> currentNumberBytes = new ArrayList<>(); // Stores 7-bit chunks for the current number
            long tempNumber = number;

            while (tempNumber > 0) {
                int byteValue = (int) (tempNumber & SEVEN_BIT_MASK); // Get the last 7 bits
                currentNumberBytes.add(byteValue);
                tempNumber >>= 7; // Shift right by 7 bits
            }

            // Apply continuation bits and add to the main list in correct order
            // Iterate in reverse from currentNumberBytes to get the correct VLQ byte order (MSB first)
            for (int i = currentNumberBytes.size() - 1; i >= 0; i--) {
                int byteToAdd = currentNumberBytes.get(i);
                if (i > 0) { // If it's not the last byte (LSB of the original number, but last in VLQ sequence)
                    byteToAdd |= CONTINUATION_BIT; // Set the continuation bit
                }
                encodedBytesInts.add(byteToAdd);
            }
        }

        // Convert the list of Integer byte values to hexadecimal String representations with "0x" prefix
        // Use "%x" for lowercase hexadecimal output
        return encodedBytesInts.stream()
                .map(b -> String.format("0x%x", b)) // Format as hex with 0x prefix (e.g., 0x40, 0x81)
                .collect(Collectors.toList());
    }

    /**
     * Decodes a list of bytes (represented as Longs) encoded using Variable Length Quantity (VLQ)
     * back into a list of unsigned 32-bit integer strings in hexadecimal format.
     *
     * @param bytes A list of Long values representing the encoded bytes (0-255).
     * @return A list of Strings, where each string is the hexadecimal representation of a decoded unsigned integer with "0x" prefix.
     * @throws IllegalArgumentException if the byte stream is malformed (e.g., ends with a continuation byte,
     * or a decoded number exceeds 32-bit unsigned integer range).
     */
    List<String> decode(List<Long> bytes) {
        if (bytes == null || bytes.isEmpty()) {
            return Collections.emptyList();
        }

        List<Long> decodedNumbersLong = new ArrayList<>(); // Internal list to build numbers as Long
        long currentNumber = 0;
        boolean inSequence = false; // Flag to track if we are currently decoding a number sequence
        int bytesReadForCurrentNumber = 0; // Track how many bytes contributed to current number

        for (int i = 0; i < bytes.size(); i++) {
            Long byteLong = bytes.get(i);
            if (byteLong == null || byteLong < 0 || byteLong > 255) {
                throw new IllegalArgumentException("Invalid byte value in stream: " + byteLong);
            }
            int byteValue = byteLong.intValue(); // Convert Long to int for bitwise operations

            // Check for potential overflow for 32-bit unsigned integer limit (0xFFFFFFFFL)
            // A 32-bit unsigned integer can be up to 0xFFFFFFFF (2^32 - 1).
            // This requires at most 5 VLQ bytes (5 * 7 = 35 bits).
            // If currentNumber shifted left by 7 would overflow, or if it already has more than 35 bits.
            if (bytesReadForCurrentNumber >= 5 || (currentNumber > (0xFFFFFFFFL >>> 7) && (byteValue & CONTINUATION_BIT) != 0)) {
                // If we've already read 5 bytes, and there's still a continuation bit, it's an overflow
                // Or if currentNumber is already so large that left-shifting it by 7 would overflow a 32-bit uint
                // (0xFFFFFFFFL >>> 7) is the max value currentNumber can have before a left shift by 7 causes overflow.
                throw new IllegalArgumentException("Invalid variable-length quantity encoding");
            }


            // Shift the accumulated number left by 7 bits to make space for the new 7 bits
            currentNumber <<= 7;

            // Add the 7 significant bits from the current byte
            currentNumber |= (byteValue & SEVEN_BIT_MASK);
            inSequence = true; // Mark that we are in a number sequence
            bytesReadForCurrentNumber++;

            // Check the continuation bit
            if ((byteValue & CONTINUATION_BIT) == 0) { // No continuation bit, this is the last byte of the number
                decodedNumbersLong.add(currentNumber);
                currentNumber = 0;   // Reset for the next number
                inSequence = false;  // End of sequence
                bytesReadForCurrentNumber = 0; // Reset byte count for next number
            } else {
                // If it's a continuation byte and it's the last byte in the input list, it's malformed.
                if (i == bytes.size() - 1) {
                    throw new IllegalArgumentException("Invalid variable-length quantity encoding");
                }
            }
        }

        // If after iterating all bytes, we were in a sequence but it didn't terminate, it's malformed.
        if (inSequence) {
            throw new IllegalArgumentException("Invalid variable-length quantity encoding");
        }

        // Convert the list of Long numbers to their hexadecimal String representations with "0x" prefix
        // Use "%x" for lowercase hexadecimal output
        return decodedNumbersLong.stream()
                .map(n -> String.format("0x%x", n))
                .collect(Collectors.toList());
    }
}