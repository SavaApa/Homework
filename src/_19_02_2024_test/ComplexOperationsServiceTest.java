package _19_02_2024_test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ComplexOperationsServiceTest {

    private final ComplexOperationsService service = new ComplexOperationsService();

    @ParameterizedTest
    @CsvSource({
            "weak, false",
            "strongPassword1@, true",
            "noDigit!, false",
            "NoSpecialChar1, false"
    })
    void validatePasswordStrength(String password, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.validatePasswordStrength(password));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"This is correct", "This text contains error", "fail is not good", "wrong way"})
    void processText(String text) {
        if (text.contains("error") || text.contains("fail") || text.contains("wrong")) {
            assertThrows(IllegalArgumentException.class, () -> service.processText(text));
        }
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "one,two,three", "10,,20", "5.5,6.5"})
    void sumOfNumbersInString(String numbers) {
        if (numbers.matches(".*[a-zA-Z]+.*") || numbers.contains(",,")) {
            assertThrows(IllegalArgumentException.class, () -> service.sumOfNumbersInString(numbers));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://valid.com", "https://valid.com", "ftp://invalid.com", "just text"})
    void validateUrlFormat(String url) {
        if (!url.startsWith("http")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateUrlFormat(url));
        } else {
            assertDoesNotThrow(() -> service.validateUrlFormat(url));
        }
    }

    // For checkEmailListConsistency and other methods requiring complex inputs or multiple parameters,
    // you might use @MethodSource to supply a Stream of arguments.
    // Example setup for @MethodSource (not fully implemented due to complexity):
    public static Stream<Arguments> emailListProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("valid@email.com", "invalid-email"), false),
                Arguments.of(Arrays.asList("valid@email.com", "also.valid@email.com"), true)
        );
    }

    // Example test method using @MethodSource for email lists
    @ParameterizedTest
    @MethodSource("emailListProvider")
    void checkEmailListConsistency(List<String> emails, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.checkEmailListConsistency(emails));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "Anna, true",
            "LEvEL, true",
            "POInt, false"

    })
    void checkStringPalindrome(String words, boolean isPalindrome) {
        if (!isPalindrome) {
            assertThrows(IllegalArgumentException.class, () -> service.checkStringPalindrome(words));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "AB123456",
            "123456AB",
            ",s123456"})
    void validateIdentificationNumber(String idNumber) {
        if (!idNumber.matches("^[A-Za-z]{2}\\d{6}$")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateIdentificationNumber(idNumber));
        } else {
            assertDoesNotThrow(() -> service.validateIdentificationNumber(idNumber));
        }
    }

    private static Stream<Arguments> checkSumOfList() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), 6, true),
                Arguments.of(Arrays.asList(1, 2, 0, -1), 4, false)
        );
    }

    @ParameterizedTest
    @MethodSource("checkSumOfList")
    void checkSumOfListAgainstThreshold(List<Integer> number, int threshold, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.checkSumOfListAgainstThreshold(number, threshold));
        } else {
            assertDoesNotThrow(() -> service.checkSumOfListAgainstThreshold(number, threshold));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"192.168.0.1",
            "255.255.2545.255",
            "10.0.0.123",
            "255.255.255"})
    void validateIPAddress(String ipAddress) {
        if (!ipAddress.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$")) {
            assertThrows(IllegalArgumentException.class, () -> service.validateIPAddress((ipAddress)));
        } else {
            assertDoesNotThrow(() -> service.validateIPAddress(ipAddress));
        }
    }

    private static Stream<Arguments> noDuplication() {
        return Stream.of(
                Arguments.of(List.of("apple", "orange", "banana"), true),
                Arguments.of(List.of("apple", "orange", "banana", "banana"), false)
        );
    }

    @ParameterizedTest
    @MethodSource("noDuplication")
    void ensureNoDuplicateEntries(List<String> strings, boolean isValid) {
        if (!isValid) {
            assertThrows(IllegalArgumentException.class, () -> service.ensureNoDuplicateEntries(strings));
        } else {
            assertDoesNotThrow(() -> service.ensureNoDuplicateEntries(strings));
        }
    }
}
