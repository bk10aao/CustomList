import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("DataFlowIssue")
class ListTest {

    @Test
    public void givenDefaultConstructor_returnsListSizeOf_32() {
        CustomList customList = new CustomList();

        assertEquals(32, customList.listSize);
        assertEquals(0, customList.size());
    }

    @Test
    public void givenConstructorWithParameterSUZEof_64_returnsDefaultListSizeOf_64_andZeroElements() {
        CustomList customList = new CustomList(64);

        assertEquals(64, customList.listSize);
        assertEquals(0, customList.size());
    }

    @Test
    public void givenDefaultList_whenAddingValue_1_returnsSizeOf_1() {
        CustomList customList = new CustomList();

        assertEquals(32, customList.listSize);
        assertEquals(0, customList.size());
        assertTrue(customList.add(1));
        assertEquals(1, customList.size());
    }
    @Test
    public void givenListOfSize_32_whenAddingValue_null_throws_NullPointerException() {
        CustomList customList = new CustomList(32);

        assertThrows(NullPointerException.class,
                ()-> customList.add(null));
    }

    @Test
    public void givenListOfSize_32_whenAddingValue_1_returnsSizeOf_1() {
        CustomList customList = new CustomList(32);

        assertEquals(32, customList.listSize);
        assertEquals(0, customList.size());
        assertTrue(customList.add(1));
        assertEquals(1, customList.size());
    }

    @Test
    public void givenListOfSize_0_whenAddingValue_1_returnsSizeOf_1() {
        CustomList customList = new CustomList(0);

        assertTrue(customList.add(1));
        assertEquals(1, customList.size());
    }

    @Test
    public void givenListOfSize_10_whenAddingValue_1_returnsSizeOf_1() {
        CustomList customList = new CustomList(0);

        assertTrue(customList.add(10));
        assertEquals(1, customList.size());
    }

    @Test
    public void givenListOfSize_128_whenAddingValue_1_returnsSizeOf_1() {
        CustomList customList = new CustomList(0);
        for(int i = 0; i <= 33; i++) customList.add(i);

        assertEquals(34, customList.size());
        assertEquals(64, customList.listSize);
    }

    @Test
    public void givenACollectionOf_5_ints_on_addAll_returnsTrue() {
        CustomList customList = new CustomList(0);
        ArrayList<Integer> collection = new ArrayList<>();
        for(int i = 0; i < 5; i++) collection.add(i);

        assertTrue(customList.addAll(collection));
        assertEquals(5, customList.size());
        assertEquals(32, customList.listSize);
    }

    @Test
    public void givenACollectionOf_33_ints_on_addAll_returnsTrue_andListSizeOf_64() {
        CustomList customList = new CustomList(0);
        ArrayList<Integer> collection = new ArrayList<>();
        for(int i = 0; i < 33; i++) collection.add(i);

        assertTrue(customList.addAll(collection));
        assertEquals(33, customList.size());
        assertEquals(64, customList.listSize);
    }

    @Test
    public void givenACollectionOf_5_ints_on_clear_returnsEmptyList() {
        CustomList customList = new CustomList(0);
        for(int i = 0; i < 5; i++) customList.add(i);

        assertEquals(5, customList.size());
        assertEquals(32, customList.listSize);

        customList.clear();

        assertEquals(0, customList.size());
        assertEquals(32, customList.listSize);
    }

    @Test
    public void givenACollectionOf_33_ints_on_clear_returnsEmptyList() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 33; i++) customList.add(i);
        assertEquals(33, customList.size());
        assertEquals(64, customList.listSize);

        customList.clear();

        assertEquals(0, customList.size());
        assertEquals(32, customList.listSize);
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContains_2_3_4_and_10() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 33; i++) customList.add(i);

        assertTrue(customList.contains(2));
        assertTrue(customList.contains(3));
        assertTrue(customList.contains(4));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContains_50_and_100_returns_false() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 33; i++) customList.add(i);

        assertFalse(customList.contains(50));
        assertFalse(customList.contains(100));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContainsAllOf_5_10_and_20_returns_true() {
        CustomList customList = new CustomList();
        List<Integer> collection = IntStream.of(5, 10, 20).boxed().collect(Collectors.toList());

        IntStream.range(0, 33).forEach(customList::add);

        assertTrue(customList.containsAll(collection));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContainsAllOf_5_10_and_200_returns_false() {
        CustomList customList = new CustomList();
        List<Integer> collection = IntStream.of(5, 10, 200).boxed().collect(Collectors.toList());
        IntStream.range(0, 33).forEach(customList::add);

        assertFalse(customList.containsAll(collection));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContainsAllOf_nullCollection_throws_NullPointerException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 33).forEach(customList::add);

        assertThrows(NullPointerException.class,
                ()-> customList.containsAll(null));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onIterator_has_32_items() {
        CustomList customList = new CustomList();
        IntStream.range(0, 32).forEach(customList::add);

        Iterator it = customList.iterator();
        int iteratorCount = 0;

        while(it.hasNext()) {
            it.next();
            iteratorCount++;
        }

        assertEquals(32, iteratorCount);
    }

    @Test
    public void givenListOf_0_to_5_its_return_arrayOfList() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).forEach(customList::add);

        Object[] expected = new Object[] { 0, 1, 2, 3, 4, 5 };

        assertArrayEquals(expected, customList.toArray());
    }

    @Test
    public void givenTwoDifferentLists_on_equals_returnsFalse() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).forEach(customList::add);

        CustomList customListTwo = new CustomList();
        IntStream.range(0, 8).mapToObj(i -> i * 10).forEach(customListTwo::add);

        assertNotEquals(customList, customListTwo);
    }

    @Test
    public void givenTwoMatchingLists_on_equals_returnsTrue() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).forEach(customList::add);

        CustomList customListTwo = new CustomList();
        IntStream.range(0, 6).forEach(customListTwo::add);

        assertEquals(customList, customListTwo);
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_negative_1_throws_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).forEach(customList::add);

        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.get(-1));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_10_throws_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).forEach(customList::add);

        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.get(10));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_0_returns_0() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).forEach(customList::add);

        assertEquals(0, customList.get(0));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_3_returns_3() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).forEach(customList::add);

        assertEquals(3, customList.get(3));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_5_returns_5() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).forEach(customList::add);

        assertEquals(5, customList.get(5));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndex_3_returns_30() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).mapToObj(i -> i * 10).forEach(customList::add);

        assertEquals(30, customList.get(3));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndex_null_throws_NullPointerException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).mapToObj(i -> i * 10).forEach(customList::add);

        assertThrows(NullPointerException.class,
                ()-> customList.indexOf(null));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_100_returns_negative_1() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) customList.add(i * 10);

        assertEquals(-1, customList.indexOf(100));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_10_returns_1() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).mapToObj(i -> i * 10).forEach(customList::add);

        assertEquals(1, customList.indexOf(10));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_20_returns_1() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).mapToObj(i -> i * 10).forEach(customList::add);

        assertEquals(2, customList.indexOf(20));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_40_returns_4() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).mapToObj(i -> i * 10).forEach(customList::add);

        assertEquals(4, customList.indexOf(40));
    }

    @Test
    public void givenListOf_5_values_on_isEmpty_returns_false() {
        CustomList customList = new CustomList();
        IntStream.range(0, 6).forEach(customList::add);

        assertFalse(customList.isEmpty());
    }

    @Test
    public void givenEmptyList_on_isEmpty_returns_true() {
        CustomList customList = new CustomList();
        assertTrue(customList.isEmpty());
    }

    @Test
    public void givenIndexToRemove_whichIsLargerThanSize_throws_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.remove(5));
    }

    @Test
    public void givenNegativeIndexOf_minus_1_onRemove_throws_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.remove(-1));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_50_onRemovingIndexOf_2_leavesArrayOf_0_10_30_40_50_withSizeOf_4() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        CustomList expected = new CustomList();
        IntStream.of(0, 10, 30, 40).forEach(expected::add);

        assertTrue(customList.remove(2));
        assertEquals(customList, expected);
        assertEquals(4, customList.size());
    }

    @Test
    public void givenListOf_50Values_onRemoving_42Values_reducesArrayToSizeOf_32() {
        CustomList customList = new CustomList();
        IntStream.range(0, 50).mapToObj(i -> i * 10).forEach(customList::add);

        boolean removed = false;

        for(int i = 42; i > 0; i--) removed = customList.remove(i);

        assertTrue(removed);
        assertEquals(8, customList.size());
        assertEquals(32, customList.listSize);
    }

    @Test
    public void givenListOf_5_objects_of_0_10_20_30_40_50_onRemovingAnObjectThatDoesNotExist_returnsFalse() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertFalse(customList.remove(new Object()));
    }

    @Test
    public void givenListOf_5_objects_of_0_10_20_30_40_50_onRemovingANullValue_returnsFalse() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> 10 * i).forEach(customList::add);

        assertThrows(NullPointerException.class,
                ()-> customList.remove(null));
    }

    @Test
    public void givenListOf_5_objects_of_0_10_20_30_40_50_onRemovingAValueThatDoesNotExist_returnsFalse() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> String.valueOf(10 * i)).forEach(customList::add);

        assertFalse(customList.remove(String.valueOf(100)));
    }

    @Test
    public void givenListOf_5_objects_of_0_10_20_30_40_50_onRemovingAValueThatDoesExist_returnsFalse() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> String.valueOf(i * 10)).forEach(customList::add);

        assertFalse(customList.remove(String.valueOf(100)));
    }

    @Test
    public void whenRemovingListWithOnlyNullItems_throws_NullPointerException() {
        CustomList customList = new CustomList();
        Collection<Integer> items = IntStream.range(0, 3).<Integer>mapToObj(i -> null).collect(Collectors.toList());

        assertThrows(NullPointerException.class,
                ()-> customList.removeAll(items));
    }

    @Test
    public void whenRemovingListWithANullItem_throws_NullPointerException() {
        CustomList customList = new CustomList();
        Collection<Integer> items = IntStream.range(10, 12).boxed().collect(Collectors.toList());
        items.add(null);

        IntStream.range(10, 12).forEach(customList::add);

        assertThrows(NullPointerException.class,
                ()-> customList.removeAll(items));
    }

    @Test
    public void whenRemovingNullList_throws_NullPointerException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertThrows(NullPointerException.class,
                ()-> customList.removeAll(null));
    }

    @Test
    public void whenRemovingEmptyList_returns_false() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertFalse(customList.removeAll(new ArrayList<>()));
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_returns_true() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        Collection<Integer> items = IntStream.range(0, 3).mapToObj(i -> i * 10).collect(Collectors.toList());

        assertTrue(customList.removeAll(items));
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_and_oneNot_returns_false() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        Collection<Integer> items = IntStream.range(2, 6).mapToObj(i -> i * 10).collect(Collectors.toList());

        assertFalse(customList.removeAll(items));
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_withGaps_returns_true() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        Collection<Integer> items = IntStream.of(0, 30, 10).boxed().collect(Collectors.toList());

        assertTrue(customList.removeAll(items));
    }

    @Test
    public void whenSettingItemInList_withIndexOf_negative_1_throws_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.set(-1, 1000));
    }

    @Test
    public void whenSettingItemInList_withIndexLargerThanSize_throws_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.set(100, 1000));
    }

    @Test
    public void whenSettingItemInList_withIndexOf_3_andValueOf_100_returns_30() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertEquals(5, customList.size());
        assertEquals(30, (Integer) customList.set(3, 100));
        assertEquals(100, customList.get(3));
        assertEquals(5, customList.size());
    }

    @Test
    public void whenGettingLastIndexOfObjectThatDoesNotExist_throws_NullPointerException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertThrows(NullPointerException.class,
                ()-> customList.lastIndexOf(null));
    }

    @Test
    public void whenGettingLastIndexOfObject_20_returns_2() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertEquals(2, customList.lastIndexOf(20));
    }

    @Test
    public void whenGettingLastIndexOfObject_20_returns_7() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        IntStream.range(0, 5).mapToObj(i -> i * 10).forEachOrdered(customList::add);

        assertEquals(7, customList.lastIndexOf(20));
    }

    @Test
    public void whenGettingLastIndexOfObjectThatDoesNotExistInList_1000_returns_negative_1() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertEquals(-1, customList.lastIndexOf(1000));
    }

    @Test
    public void whenGettingSubList_withFirstIndexSmallerThan_0_throws_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);

        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.subList(-1, 10));
    }
    @Test
    public void whenGettingSubList_withIndexOf_2_8_returnsCorrectSublistOf_size_8() {
        CustomList customList = new CustomList();
        IntStream.range(0, 10).mapToObj(i -> i * 10).forEach(customList::add);

        CustomList expected = new CustomList();
        IntStream.range(2, 8).mapToObj(i -> i * 10).forEach(expected::add);

        CustomList subList = customList.subList(2, 8);

        assertEquals(subList, expected);
    }

    @Test
    public void whenRetainingElements_whereNullListIsProvided_throws_NullPointerException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 10).mapToObj(i -> i * 10).forEach(customList::add);

        assertThrows(NullPointerException.class, ()-> customList.retainAll(null));
    }

    @Test
    public void whenRetainingElements_whereListToRetainIsEmpty_throws_NullPointerException() {
        CustomList customList = new CustomList();
        IntStream.range(0, 10).mapToObj(i -> i * 10).forEach(customList::add);
        List<Integer> emptyList = new ArrayList<>();

        assertThrows(NullPointerException.class, ()-> customList.retainAll(emptyList));
    }

    @Test
    public void whenRetainingElements_whereNoMatch_returns_false() {
        CustomList customList = new CustomList();
        IntStream.range(0, 10).mapToObj(i -> i * 10).forEach(customList::add);

        List<Integer> retainList = IntStream.range(2, 8).mapToObj(i -> i * 100).collect(Collectors.toList());

        assertFalse(customList.retainAll(retainList));
    }

    @Test
    public void whenRetainingElements_whereFiveMatch_returns_true() {
        CustomList customList = new CustomList();
        IntStream.range(0, 10).mapToObj(i -> i * 10).forEach(customList::add);

        List<Integer> retainList = IntStream.range(2, 4).mapToObj(i -> i * 10).collect(Collectors.toList());

        assertTrue(customList.retainAll(retainList));
    }

    @Test
    public void givenListOfNoValues_returns_toString_withEmptyArray() {
        CustomList customList = new CustomList();
        assertEquals("CustomList{size=0, list=[]}", customList.toString());
    }

    @Test
    public void givenListOf_0_1_2_3_4_returns_toString() {
        CustomList customList = new CustomList();
        IntStream.range(0, 5).forEach(customList::add);

        assertEquals("CustomList{size=5, list=[0, 1, 2, 3, 4]}", customList.toString());
    }
}
