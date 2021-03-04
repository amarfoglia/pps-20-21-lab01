package lab01.tdd;

public class SimpleStrategyFactory implements StrategyFactory {
    @Override
    public SelectStrategy createEvenStrategy() {
        return element -> element % 2 == 0;
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(final int dividerElement) {
        return element -> element % dividerElement == 0;
    }

    @Override
    public SelectStrategy createEqualsStrategy(final int elementToFind) {
        return element -> element == elementToFind;
    }
}
