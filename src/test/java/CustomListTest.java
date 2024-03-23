import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("ALL")
class CustomListTest {

    @Test
    public void givenDefaultConstructor_returnsListSizeOf_32() {
        CustomList customList = new CustomList();
        assertEquals(32, customList.listSize);
        assertEquals(0, customList.size());
    }

    @Test
    public void givenConstructorWithParamaterSUZEof_64_returnsDefaultListSizeOf_64_andZeroElements() {
        CustomList customList = new CustomList(64);
        assertEquals(64, customList.listSize);
        assertEquals(0, customList.size());
    }

    @Test
    public void givenDefaultList_whenAddingValue_1_returnsSizeOf_1() {
        CustomList customList = new CustomList();
        assertEquals(32, customList.listSize);
        assertEquals(0, customList.size());
        customList.add(1);
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
        boolean result = customList.add(1);
        assertEquals(1, customList.size());
        assertTrue(result);
    }

    @Test
    public void givenListOfSize_0_whenAddingValue_1_returnsSizeOf_1() {
        CustomList customList = new CustomList(0);
        boolean result = customList.add(1);
        assertEquals(1, customList.size());
        assertTrue(result);
    }

    @Test
    public void givenListOfSize_10_whenAddingValue_1_returnsSizeOf_1() {
        CustomList customList = new CustomList(0);
        boolean result = customList.add(10);
        assertEquals(1, customList.size());
        assertTrue(result);
    }

    @Test
    public void givenListOfSize_128_whenAddingValue_1_returnsSizeOf_1() {
        CustomList customList = new CustomList(0);
        for(int i = 0; i <= 33; i++) {
            customList.add(i);
        }
        assertEquals(34, customList.size());
        assertEquals(64, customList.listSize);
    }

    @Test
    public void givenACollectionOf_5_ints_on_addAll_returnsTrue() {
        CustomList customList = new CustomList(0);
        ArrayList<Integer> collection = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            collection.add(i);
        }
        boolean result = customList.addAll(collection);
        assertEquals(5, customList.size());
        assertEquals(32, customList.listSize);
        assertTrue(result);
    }

    @Test
    public void givenACollectionOf_33_ints_on_addAll_returnsTrue_andListSizeOf_64() {
        CustomList customList = new CustomList(0);
        ArrayList<Integer> collection = new ArrayList<>();
        for(int i = 0; i < 33; i++) {
            collection.add(i);
        }
        boolean result = customList.addAll(collection);
        assertEquals(33, customList.size());
        assertEquals(64, customList.listSize);
        assertTrue(result);
    }

    @Test
    public void givenACollectionOf_5_ints_on_clear_returnsEmptyList() {
        CustomList customList = new CustomList(0);
        for(int i = 0; i < 5; i++) {
            customList.add(i);
        }
        assertEquals(5, customList.size());
        assertEquals(32, customList.listSize);
        customList.clear();
        assertEquals(0, customList.size());
        assertEquals(32, customList.listSize);
    }

    @Test
    public void givenACollectionOf_33_ints_on_clear_returnsEmptyList() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertEquals(33, customList.size());
        assertEquals(64, customList.listSize);
        customList.clear();
        assertEquals(0, customList.size());
        assertEquals(32, customList.listSize);
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContains_2_3_4_and_10() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertTrue(customList.contains(2));
        assertTrue(customList.contains(3));
        assertTrue(customList.contains(4));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContains_50_and_100_returns_false() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertFalse(customList.contains(50));
        assertFalse(customList.contains(100));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContainsAllOf_5_10_and_20_returns_true() {
        CustomList customList = new CustomList();
        CustomList<Integer> collection = new CustomList<>();
        collection.add(5);
        collection.add(10);
        collection.add(20);
        for(int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertTrue(customList.containsAll(collection));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContainsAllOf_5_10_and_200_returns_false() {
        CustomList customList = new CustomList();
        CustomList<Integer> collection = new CustomList<>();
        collection.add(5);
        collection.add(10);
        collection.add(200);
        for(int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertFalse(customList.containsAll(collection));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContainsAllOf_nullCollection_returns_NullPointerException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertThrows(NullPointerException.class,
                ()-> customList.containsAll(null));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onIterator_has_32_items() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 32; i++) {
            customList.add(i);
        }
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
        for(int i = 0; i < 6; i++) {
            customList.add(i);
        }
        Object[] expected = new Object[] { 0, 1, 2, 3, 4, 5 };
        Object[] actual = customList.toArray();
        assertArrayEquals(expected, customList.toArray());
    }

    @Test
    public void givenTwoDifferentLists_on_equals_returnsFalse() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i);
        }
        CustomList customListTwo = new CustomList();
        for(int i = 0; i < 8; i++) {
            customListTwo.add(i * 10);
        }
        assertNotEquals(customList, customListTwo);
    }

    @Test
    public void givenTwoMatchingLists_on_equals_returnsTrue() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i);
        }
        CustomList customListTwo = new CustomList();
        for(int i = 0; i < 6; i++) {
            customListTwo.add(i);
        }
        assertEquals(customList, customListTwo);
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_negative_1_throws_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.get(-1));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_10_throws_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.get(10));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_0_returns_0() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i);
        }
        assertEquals(0, customList.get(0));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_3_returns_3() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i);
        }
        assertEquals(5, customList.get(5));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_5_returns_5() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i);
        }
        assertEquals(5, customList.get(5));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndex_3_returns_30() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertEquals(30, customList.get(3));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndex_null_returns_nullPointerException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertThrows(NullPointerException.class,
                ()-> customList.indexOf(null));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_100_returns_negative_1() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertEquals(-1, customList.indexOf(100));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_10_returns_1() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertEquals(1, customList.indexOf(10));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_20_returns_1() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertEquals(2, customList.indexOf(20));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_40_returns_4() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertEquals(4, customList.indexOf(40));
    }

    @Test
    public void givenListOf_5_values_on_isEmpty_returns_false() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 6; i++) {
            customList.add(i);
        }
        assertFalse(customList.isEmpty());
    }

    @Test
    public void givenEmptyList_on_isEmpty_returns_true() {
        CustomList customList = new CustomList();
        assertTrue(customList.isEmpty());
    }

    @Test
    public void givenIndexToRemove_whichIsLargerThanSize_returns_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.remove(5));
    }

    @Test
    public void givenNegativeIndexOf_minus_1_onRemove_returns_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.remove(-1));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_50_onRemovingIndexOf_2_leavesArrayOf_0_10_30_40_50_withSizeOf_4() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }

        CustomList expected = new CustomList();
        expected.add(0);
        expected.add(10);
        expected.add(30);
        expected.add(40);
        boolean removed = customList.remove(2);
        assertTrue(removed);
        assertTrue(customList.equals(expected));
        assertEquals(4, customList.size());
    }

    @Test
    public void givenListOf_50Values_onRemoving_42Values_reducesArrayToSizeOf_32() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 50; i++) {
            customList.add(i * 10);
        }
        boolean removed = false;
        for(int i = 42; i > 0; i--) {
            removed = customList.remove(i);
        }
        assertTrue(removed);
        assertEquals(8, customList.size());
        assertEquals(32, customList.listSize);
    }

    @Test
    public void givenListOf_5_objects_of_0_10_20_30_40_50_onRemovingAnObjectThatDoesNotExist_returnsFalse() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }
        Object o = new Object();
        assertFalse(customList.remove(o));
    }

    @Test
    public void givenListOf_5_objects_of_0_10_20_30_40_50_onRemovingANullValue_returnsFalse() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(new Integer(10 * i));
        }
        assertThrows(NullPointerException.class,
                ()-> customList.remove(null));
    }

    @Test
    public void givenListOf_5_objects_of_0_10_20_30_40_50_onRemovingAValueThatDoesNotExist_returnsFalse() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(new Integer(10 * i));
        }
        int asObject = 100;
        assertFalse(customList.remove(new Integer(100)));
    }

    @Test
    public void givenListOf_5_objects_of_0_10_20_30_40_50_onRemovingAValueThatDoesExist_returnsFalse() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(new String(String.valueOf(i * 10)));
        }
        int asObject = 100;
        assertFalse(customList.remove(String.valueOf(100)));
    }

    @Test
    public void whenRemovingListWithOnlyNullItems_returns_NullPointerException() {
        CustomList customList = new CustomList();
        Collection<Integer> items = new ArrayList<>();
        items.add(null);
        items.add(null);
        items.add(null);

        assertThrows(NullPointerException.class,
                ()-> customList.removeAll(null));
    }

    @Test
    public void whenRemovingListWithANullItem_returns_NullPointerException() {
        CustomList customList = new CustomList();
        Collection<Integer> items = new ArrayList<>();
        items.add(10);
        items.add(11);
        items.add(null);

        assertThrows(NullPointerException.class,
                ()-> customList.removeAll(null));
    }

    @Test
    public void whenRemovingNullList_returns_NullPointerException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(new Integer(i * 10));
        }
        assertThrows(NullPointerException.class,
                ()-> customList.removeAll(null));
    }

    @Test
    public void whenRemovingEmptyList_returns_false() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(new Integer(i * 10));
        }
        assertFalse(customList.removeAll(new ArrayList<>()));
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_returns_true() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(new Integer(i * 10));
        }

        Collection<Integer> items = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            items.add(new Integer(i * 10));
        }

        assertTrue(customList.removeAll(items));
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_and_oneNot_returns_false() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(new Integer(i * 10));
        }

        Collection<Integer> items = new ArrayList<>();
        for(int i = 2; i < 6; i++) {
            items.add(new Integer(i * 10));
        }

        assertFalse(customList.removeAll(items));
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_withGaps_returns_true() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(new Integer(i * 10));
        }

        Collection<Integer> items = new ArrayList<>();
        items.add(0);
        items.add(30);
        items.add(10);
        assertTrue(customList.removeAll(items));
    }

    @Test
    public void whenSettingItemInList_withIndexof_negative_1_returns_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(new Integer(i * 10));
        }

        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.set(-1, 1000));
    }

    @Test
    public void whenSettingItemInList_withIndexLargerThanSize_returns_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(new Integer(i * 10));
        }

        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.set(100, 1000));
    }

    @Test
    public void whenSettingItemInList_withIndexof_3_andValueOf_100_returns_30() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }

        assertEquals(5, customList.size());
        Integer result = (Integer) customList.set(3, 100);
        assertEquals(30, result);
        assertEquals(100, customList.get(3));
        assertEquals(5, customList.size());
    }

    @Test
    public void whenGettingLastIndexOfObjectThatDoesNotExist_throws_NullPointerException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }

        assertThrows(NullPointerException.class,
                ()-> customList.lastIndexOf(null));
    }

    @Test
    public void whenGettingLastIndexOfObject_20_returns_2() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }

        assertEquals(2, customList.lastIndexOf(20));
    }

    @Test
    public void whenGettingLastIndexOfObject_20_returns_7() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }

        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }

        assertEquals(7, customList.lastIndexOf(20));
    }

    @Test
    public void whenGettingLastIndexOfObjectThatDoesNotExistInList_1000_returns_negative_1() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }

        assertEquals(-1, customList.lastIndexOf(1000));
    }

    @Test
    public void whenGettingSubList_withFirstIndexSmallerThan_0_returns_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }

        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.subList(-1, 10));
    }
    @Test
    public void whenGettingSubList_withIndexsOf_2_8_returnsCorrectSublistOf_size_8() {
        CustomList customList = new CustomList();
        for(int i = 0; i < 10; i++) {
            customList.add(i * 10);
        }

        CustomList expected = new CustomList();
        for(int i = 2; i < 8; i++) {
            expected.add(i * 10);
        }

        CustomList subList = customList.subList(2, 8);

        assertTrue(subList.equals(expected));
    }

}