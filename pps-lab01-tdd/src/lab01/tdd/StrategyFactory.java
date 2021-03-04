package lab01.tdd;

public interface StrategyFactory {
    /**
     * @return evenStrategy to get the next even element.
     */
    SelectStrategy createEvenStrategy();

    /**
     * @param dividerElement
     * @return multipleOfStrategy to get the next multiple of a given number.
     */
    SelectStrategy createMultipleOfStrategy(final int dividerElement);

    /**
     *
     * @param elementToFind
     * @return equalsStrategy, to get the next equal element of a given one.
     */
    SelectStrategy createEqualsStrategy(final int elementToFind);
}
