package months;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class MonthParserTest {

    private MonthParser parser;

    @BeforeEach
    void setup() {
        parser = new MonthParser();
    }

    @Test
    void throwsIllegalArgumentExceptionIfIllegalInput() {
        Stream<Integer> illegalNumberOfInputs = Stream.of(0, -1, 13);
        illegalNumberOfInputs.forEach(month ->
                Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parseMonth(month), "Illegal input " + month));
    }

    @Test
    void parseMonthJanuary() {
        Month january = parser.parseMonth(1);
        Assertions.assertEquals("January", january.name);
        Assertions.assertEquals(31, january.days);
    }

    @Test
    void parseMonthFebuary() {
        Month febuary = parser.parseMonth(2);
        Assertions.assertEquals("Febuary", febuary.name);
        Assertions.assertEquals(28, febuary.days);
    }

    @Test
    void parseMonthMarch() {
        Month march = parser.parseMonth(3);
        Assertions.assertEquals("March", march.name);
        Assertions.assertEquals(31, march.days);
    }

    @Test
    void parseMonthApril() {
        Month april = parser.parseMonth(4);
        Assertions.assertEquals("April", april.name);
        Assertions.assertEquals(30, april.days);
    }

    @Test
    void parseMonthMay() {
        Month may = parser.parseMonth(5);
        Assertions.assertEquals("May", may.name);
        Assertions.assertEquals(31, may.days);
    }

    @Test
    void parseMonthJune() {
        Month june = parser.parseMonth(6);
        Assertions.assertEquals("June", june.name);
        Assertions.assertEquals(30, june.days);
    }

    @Test
    void parseMonthJuly() {
        Month july = parser.parseMonth(7);
        Assertions.assertEquals("July", july.name);
        Assertions.assertEquals(31, july.days);
    }

    @Test
    void parseMonthAugust() {
        Month august = parser.parseMonth(8);
        Assertions.assertEquals("August", august.name);
        Assertions.assertEquals(30, august.days);
    }

    @Test
    void parseMonthSeptember() {
        Month september = parser.parseMonth(9);
        Assertions.assertEquals("September", september.name);
        Assertions.assertEquals(31, september.days);
    }

    @Test
    void parseMonthOctober() {
        Month october = parser.parseMonth(10);
        Assertions.assertEquals("October", october.name);
        Assertions.assertEquals(30, october.days);
    }

    @Test
    void parseMonthNovember() {
        Month november = parser.parseMonth(11);
        Assertions.assertEquals("November", november.name);
        Assertions.assertEquals(31, november.days);
    }

    @Test
    void parseMonthDecember() {
        Month december = parser.parseMonth(12);
        Assertions.assertEquals("December", december.name);
        Assertions.assertEquals(30, december.days);
    }

}
