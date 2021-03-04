package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {
    private static final int FIRST_POSITION = 0;
    private final List<Integer> list;
    private int currentIndex;

    public SimpleCircularList() {
        list = new ArrayList<>();
        currentIndex = FIRST_POSITION;
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        final Optional<Integer> currentElement = getCurrentElement();
        updateIndexOnNext();
        return currentElement;
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }

    private Optional<Integer> getCurrentElement() {
        return isEmpty() ? Optional.empty() : Optional.of(list.get(currentIndex));
    }

    private void updateIndexOnNext() {
        currentIndex = (currentIndex == list.size()-1) ? FIRST_POSITION : currentIndex+1;
    }

    private void updateIndexOnPrevious() {
        currentIndex = (currentIndex == FIRST_POSITION) ? list.size()-1 : currentIndex-1;
    }
}
