import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("unchecked")
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
        for (int i = 0; i < 33; i++) {
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
        for (int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertTrue(customList.contains(2));
        assertTrue(customList.contains(3));
        assertTrue(customList.contains(4));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContains_50_and_100_returns_false() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertFalse(customList.contains(50));
        assertFalse(customList.contains(100));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContainsAllOf_5_10_and_20_returns_true() {
        CustomList customList = new CustomList();
        ArrayList<Integer> collection = new ArrayList<>();
        collection.add(5);
        collection.add(10);
        collection.add(20);
        for (int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertTrue(customList.containsAll(collection));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContainsAllOf_5_10_and_200_returns_false() {
        CustomList customList = new CustomList();
        ArrayList<Integer> collection = new ArrayList<>();
        collection.add(5);
        collection.add(10);
        collection.add(200);
        for (int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertFalse(customList.containsAll(collection));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onContainsAllOf_nullCollection_returns_NullPointerException() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 33; i++) {
            customList.add(i);
        }
        assertThrows(NullPointerException.class,
                ()-> customList.containsAll(null));
    }

    @Test
    public void givenAListOf_0_to_32_ints_onIterator_has_32_items() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 32; i++) {
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
        for (int i = 0; i < 6; i++) {
            customList.add(i);
        }
        Object[] expected = new Object[] { 0, 1, 2, 3, 4, 5 };
        assertArrayEquals(expected, customList.toArray());
    }

    @Test
    public void givenTwoDifferentLists_on_equals_returnsFalse() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i);
        }
        CustomList customListTwo = new CustomList();
        for (int i = 0; i < 6; i++) {
            customListTwo.add(i * 10);
        }
        assertNotEquals(customList, customListTwo);
    }

    @Test
    public void givenTwoMatchingLists_on_equals_returnsTrue() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i);
        }
        CustomList customListTwo = new CustomList();
        for (int i = 0; i < 6; i++) {
            customListTwo.add(i);
        }
        assertEquals(customList, customListTwo);
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_10_throws_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.get(10));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_0_returns_0() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i);
        }
        assertEquals(0, customList.get(0));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_3_returns_3() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i);
        }
        assertEquals(5, customList.get(5));
    }

    @Test
    public void givenListOf_5_values_onGettingIndex_5_returns_5() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i);
        }
        assertEquals(5, customList.get(5));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndex_3_returns_30() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertEquals(30, customList.get(3));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndex_null_returns_nullPointerException() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertThrows(NullPointerException.class,
                ()-> customList.indexOf(null));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_100_returns_negative_1() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertEquals(-1, customList.indexOf(100));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_10_returns_1() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertEquals(1, customList.indexOf(10));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_20_returns_1() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertEquals(2, customList.indexOf(20));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_onGettingIndexOfValue_40_returns_4() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
            customList.add(i * 10);
        }
        assertEquals(4, customList.indexOf(40));
    }

    @Test
    public void givenListOf_5_values_on_isEmpty_returns_false() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 6; i++) {
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
        for (int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.remove(5));
    }

    @Test
    public void givenNegativeIndexOf_minus_1_onRemove_returns_IndexOutOfBoundsException() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customList.remove(-1));
    }

    @Test
    public void givenListOf_5_values_of_0_10_20_30_40_50_onRemovingIndexOf_2_leavesArrayOf_0_10_30_40_50_withSizeOf_4() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 5; i++) {
            customList.add(i * 10);
        }

        CustomList expected = new CustomList();
        expected.add(0);
        expected.add(10);
        expected.add(30);
        expected.add(40);
        customList.remove(2);
        assertTrue(customList.equals(expected));
        assertEquals(4, customList.size);
    }

    @Test
    public void givenListOf_50Values_onRemoving_42Values_reducesArrayToSizeOf_32() {
        CustomList customList = new CustomList();
        for (int i = 0; i < 50; i++) {
            customList.add(i * 10);
        }
        for(int i = 0; i < 42; i++) {
            customList.remove(i);
        }
        assertEquals(8, customList.size);
        assertEquals(32, customList.listSize);
    }
}