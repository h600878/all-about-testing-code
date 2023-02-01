package smoothiemaker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class SmoothieBarTest {

    private SmoothieBar smoothieBar;

    final static int applesAndOrangesNeededForSmoothie = 2;


    @BeforeEach
    public void setup() {
        smoothieBar = new SmoothieBar();
    }

    private static void restockApplesAndOranges(SmoothieBar smoothieBar, int size) {
        smoothieBar.restockOranges(size);
        smoothieBar.restockApples(size);
    }

    private static void restockBananasAndApples(SmoothieBar smoothieBar, int size) {
        smoothieBar.restockBananas(size);
        smoothieBar.restockApples(size);
    }

    @Test
    public void canBlendOrangeAndAppleSmoothie() {
        restockApplesAndOranges(smoothieBar, applesAndOrangesNeededForSmoothie);
        Smoothie smoothie = smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);

        Assertions.assertSame(smoothie.getKind(), SmoothieKind.OrangeAndAppleSmoothie, "Wrong kind of smoothie");
    }

    @Test
    public void blendingOrangeAndAppleSmoothieConsumesOrangeAndApples() {
        restockApplesAndOranges(smoothieBar, applesAndOrangesNeededForSmoothie);
        smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie);

        Assertions.assertEquals(0, smoothieBar.getApplesInStock(), "Not enough apples in stock");
        Assertions.assertEquals(0, smoothieBar.getOrangesInStock(), "Not enough oranges in stock");
    }

    @Test
    public void blendingBananaandAppleSmoothieConsumesOrangesAndApples() {
        restockBananasAndApples(smoothieBar, 2);
        smoothieBar.blend(SmoothieKind.BananaAndAppleSmoothe);

        Assertions.assertEquals(1, smoothieBar.getBananasInStock());
        Assertions.assertEquals(0, smoothieBar.getApplesInStock());
    }

    @Test
    public void throwIllegalStateExceptionIfNotEnoughIngredients() {
        Class<IllegalStateException> notEnoughtIngredientsException = IllegalStateException.class;

        Assertions.assertThrows(notEnoughtIngredientsException, () -> smoothieBar.blend(SmoothieKind.OrangeAndBananaSmoothie));
        restockApplesAndOranges(smoothieBar, 1);
        Assertions.assertThrows(notEnoughtIngredientsException, () -> smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie));

        restockApplesAndOranges(smoothieBar, 1);
        Assertions.assertDoesNotThrow(() -> smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie));
    }

    @Test
    public void throwIllegalArgumentExceptionIfSizeIsIllegal() {
        Stream<Integer> illegalInput = Stream.of(0, -1);
        illegalInput.forEach(size ->
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> smoothieBar.blend(SmoothieKind.OrangeAndAppleSmoothie, size), "Illegal size: " + size));
    }

}