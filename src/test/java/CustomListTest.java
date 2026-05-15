import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("CollectionAddedToSelf")
class CustomListTest {

    @Test
    public void givenNewEmptyList_returnsSizeOf_0() {
        CustomList<Integer> customList = new CustomList<>();
        assertEquals(0, customList.size());
    }

    @Test
    public void givenConstructorWithCollectionParameter_onNullCollection_throws_NullPointerException() {
        assertThrows(NullPointerException.class, () -> new CustomList<Integer>(null));
    }

    @Test
    public void givenConstructorWithCollectionParameter_onCollectionOf_0_1_2_3_4_containsValues_withSizeOf_5() {
        Collection<Integer> values = new ArrayList<>(List.of(0, 1, 2, 3, 4));
        CustomList<Integer> customList = new CustomList<>(values);
        assertTrue(customList.contains(0));
        assertTrue(customList.contains(1));
        assertTrue(customList.contains(2));
        assertTrue(customList.contains(3));
        assertTrue(customList.contains(4));
        assertEquals(5, customList.size());
    }

    @Test
    public void givenLinkedListOfType_Integer_onAdding_1_returnsSizeOf_1() {
        CustomList<Integer> customLinkedList = new CustomList<>();
        customLinkedList.add(1);
        assertEquals(1, customLinkedList.size());
    }

    @Test
    public void givenLinkedListOfType_Integer_onAdding_1_2_returnsSizeOf_2() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertEquals(1, customList.size());
        assertTrue(customList.add(2));
        assertEquals(2, customList.size());
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_0_adds_100_toStart() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        customList.add(0, 100);
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_0_adds_100_toIndex_0() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        customList.add(0, 100);
        assertEquals(100, customList.get(0));
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_1_adds_100_toIndex_1() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        customList.add(1, 100);
        assertEquals(100, customList.get(1));
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_2_adds_100_toIndex_2() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        customList.add(2, 100);
        assertEquals(100, customList.get(2));
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_3_adds_100_toIndex_3() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        customList.add(3, 100);
        assertEquals(100, customList.get(3));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_5_throwsIndexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customList.remove(5));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_negative_1_throwsIndexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customList.remove(-1));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_3_returns_true() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertEquals(3, customList.remove(2));
        assertEquals(2, customList.size());
        assertEquals(1, customList.get(0));
        assertEquals(2, customList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> customList.get(2));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_1_returns_true() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertEquals(2, customList.remove(1));
        assertEquals(2, customList.size());
    }

    @Test
    public void givenEmptyLinkedListOfType_onGet_negativeOne_throwsIndexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> customList.get(-1));
    }

    @Test
    public void givenLinkedListOf3Values_onGetIndex_4_throws_indexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(1);
        customList.add(2);
        customList.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> customList.get(4));
    }

    @Test
    public void givenLinkedListOfValue_10_20_30_onGetRelevantIndexes_returnsCorrectValues() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        assertEquals(10, customList.get(0));
        assertEquals(20, customList.get(1));
        assertEquals(30, customList.get(2));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toNegativeIndex_throws_indexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        assertThrows(IndexOutOfBoundsException.class, () -> customList.add(-1,40));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toIndex_100_throws_indexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        assertThrows(IndexOutOfBoundsException.class, () -> customList.add(100,40));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toIndex_1_returns_10_40_20_30() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        customList.add(1, 40);
        assertEquals(40, customList.get(1));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toIndex_2_returns_10_20_40_30() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        customList.add(2, 40);
        assertEquals(40, customList.get(2));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_40_onAdd_50_toIndex_3_returns_10_20_30_50_40() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        customList.add(40);
        customList.add(3, 50);
        assertEquals(50, customList.get(3));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onContains_null_throws_nullPointerException() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onContains_100_returns_false() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        assertFalse(customList.contains(100));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onContains_20_returns_true() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(10);
        customList.add(20);
        customList.add(30);
        assertTrue(customList.contains(20));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_negative_1_to_40throwsIndexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customList.set(-1, 40));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_4_to_40throwsIndexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customList.set(4, 40));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_0_to_10_updatesIndexValueTo_10() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertEquals(1,  customList.set(0, 10));
        assertEquals(10, customList.get(0));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_1_to_10_updatesIndexValueTo_10() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertEquals(2,  customList.set(1, 10));
        assertEquals(10, customList.get(1));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_4_onSetIndexOf_2_to_10_updatesIndexValueTo_10() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertTrue(customList.add(4));
        assertEquals(3,  customList.set(2, 10));
        assertEquals(10, customList.get(2));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_4_onSetIndexOf_3_to_10_updatesIndexValueTo_10() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertTrue(customList.add(4));
        assertEquals(4,  customList.set(3, 10));
        assertEquals(10, customList.get(3));
    }

    @Test
    public void givenLinkedListOfTypeInteger_withNoValues_onToArray_returns_emptyArray() {
        CustomList<Integer> customList = new CustomList<>();
        assertEquals(0, customList.toArray().length);
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onToArray_returnsCorrectArray() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertArrayEquals(new Integer[] { 1, 2, 3 } , customList.toArray());
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onToArray_withIntArrayParameter_returnsCorrectArray() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(1);
        customList.add(2);
        customList.add(3);
        assertArrayEquals(new Integer[] {1, 2, 3}, customList.toArray(new Integer[0]));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onToArray_withIntArrayParameterP_withSize_2_returnsCorrectArray() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(1);
        customList.add(2);
        customList.add(3);
        assertArrayEquals(new Integer[] {1, 2, 3}, customList.toArray(new Integer[2]));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onToArray_withIntArrayParameterP_withSize_5_returnsCorrectArray() {
        CustomList<Integer> customList = new CustomList<>();
        customList.add(1);
        customList.add(2);
        customList.add(3);
        assertArrayEquals(new Integer[] {1, 2, 3, null, null}, customList.toArray(new Integer[5]));
    }

    @Test
    public void givenLinkedListOfType_Integer_onAddingNullCollection_throws_NullPointerException() {
        CustomList<Integer> customList = new CustomList<>();
        assertThrows(NullPointerException.class, () -> customList.addAll(null));
    }

    @Test
    public void givenLinkedListOfType_Integer_onAddingEmptyCollection_returns_false() {
        CustomList<Integer> customList = new CustomList<>();
        assertFalse(customList.addAll(new ArrayList<>()));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_onAddingEmptyCollection_atIndex_1_returns_false() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2));
        Collection<Integer> collection = List.of();
        assertFalse(customList.addAll(1, collection));
    }

    @Test
    public void insertAnotherCustomListAtBeginning_shouldWork() {
        CustomList<Integer> customList = new CustomList<>(List.of(10, 20));
        CustomList<Integer> toInsert = new CustomList<>(List.of(1, 2));
        customList.addAll(0, toInsert);
        assertEquals(List.of(1, 2, 10, 20), List.copyOf(customList));
    }

    @Test
    public void givenEmptyLinkedListOfType_Integer_onAddAll_atIndex_1_returnsFalse() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2));
        Collection<Integer> collection = List.of(3);
        assertTrue(customList.addAll(1, collection));
        assertEquals(1, customList.get(0));
        assertEquals(3, customList.get(1));
        assertEquals(2, customList.get(2));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_onAddAll_2_atIndex_1_updatesListCorrectly() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2));
        Collection<Integer> collection = List.of(3);
        assertTrue(customList.addAll(1, collection));
        assertEquals(1, customList.get(0));
        assertEquals(3, customList.get(1));
        assertEquals(2, customList.get(2));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onAddAll_4_5_6_updatesListCorrectly() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        Collection<Integer> collection = new ArrayList<>();
        collection.add(4);
        collection.add(5);
        collection.add(6);
        assertTrue(customList.addAll(collection));
        assertEquals(1, customList.get(0));
        assertEquals(2, customList.get(1));
        assertEquals(3, customList.get(2));
        assertEquals(4, customList.get(3));
        assertEquals(5, customList.get(4));
        assertEquals(6, customList.get(5));
    }

    @Test
    public void givenTwoLinkedListsOfType_Integer_firstValues_1_2_3_secondValue_4_5_6_onEquals_returnsFalse() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));

        CustomList<Integer> customListTwo = new CustomList<>();
        customListTwo.add(4);
        customListTwo.add(5);
        customListTwo.add(6);
        assertNotEquals(customList, customListTwo);
    }

    @Test
    public void givenTwoLinkedListsOfType_Integer_firstValues_1_2_3_secondValue_1_2_3_onEquals_returnsTrue() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));

        CustomList<Integer> customListTwo = new CustomList<>();
        customListTwo.add(1);
        customListTwo.add(2);
        customListTwo.add(3);
        assertEquals(customList, customListTwo);
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onRemoveObject_d_returns_false() {
        CustomList<String> customList = new CustomList<>();
        assertTrue(customList.add("a"));
        assertTrue(customList.add("b"));
        assertTrue(customList.add("c"));
        assertFalse(customList.remove("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onRemoveObject_b_returns_true_andRemoveItFromList() {
        CustomList<String> customList = new CustomList<>();
        assertTrue(customList.add("a"));
        assertTrue(customList.add("b"));
        assertTrue(customList.add("c"));
        assertTrue(customList.remove("b"));
        assertEquals("a", customList.get(0));
        assertEquals("c", customList.get(1));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onIndexOf_d_returns_minus_1() {
        CustomList<String> customList = new CustomList<>();
        assertTrue(customList.add("a"));
        assertTrue(customList.add("b"));
        assertTrue(customList.add("c"));
        assertEquals(-1, customList.indexOf("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onIndexOf_a_returns_0_b_1_c_2() {
        CustomList<String> customList = new CustomList<>();
        assertTrue(customList.add("a"));
        assertTrue(customList.add("b"));
        assertTrue(customList.add("c"));
        assertEquals(0, customList.indexOf("a"));
        assertEquals(1, customList.indexOf("b"));
        assertEquals(2, customList.indexOf("c"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onLastIndexOf_d_returns_minus_1() {
        CustomList<String> customList = new CustomList<>();
        assertTrue(customList.add("a"));
        assertTrue(customList.add("b"));
        assertTrue(customList.add("c"));
        assertEquals(-1, customList.lastIndexOf("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onLastIndexOf_a_returns_0() {
        CustomList<String> customList = new CustomList<>();
        assertTrue(customList.add("a"));
        assertTrue(customList.add("b"));
        assertTrue(customList.add("c"));
        assertEquals(0, customList.lastIndexOf("a"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onLastIndexOf_b_returns_1() {
        CustomList<String> customList = new CustomList<>();
        assertTrue(customList.add("a"));
        assertTrue(customList.add("b"));
        assertTrue(customList.add("c"));
        assertEquals(1, customList.lastIndexOf("b"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_a_c_a_d_e_onLastIndexOf_a_returns_4() {
        CustomList<String> customList = new CustomList<>();
        assertTrue(customList.add("a"));
        assertTrue(customList.add("b"));
        assertTrue(customList.add("a"));
        assertTrue(customList.add("c"));
        assertTrue(customList.add("a"));
        assertTrue(customList.add("d"));
        assertEquals(4, customList.lastIndexOf("a"));
    }

    @Test
    public void givenEmptyLinkedListOfType_Integer_withValues_1_2_3_onAddAllAtIndex_1_collection_4_5_6_returns_1_4_5_6_2_3() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        Collection<Integer> collection = new ArrayList<>();
        collection.add(4);
        collection.add(5);
        collection.add(6);
        assertTrue(customList.addAll(1, collection));
        assertEquals(1, customList.get(0));
        assertEquals(4, customList.get(1));
        assertEquals(5, customList.get(2));
        assertEquals(6, customList.get(3));
        assertEquals(2, customList.get(4));
        assertEquals(3, customList.get(5));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_returnsCorrectString_on_toString() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertEquals("CustomList{size=3, list=[1, 2, 3]}", customList.toString());
    }

    @Test
    public void givenLinkedListOfType_Integer_withNpValues_returnsStringOf_emptyBraces_on_toString() {
        CustomList<Integer> customList = new CustomList<>();
        assertEquals("CustomList{size=0, list=[]}", customList.toString());
    }

    @Test
    public void givenEmptyLinkedList_onClear_returnsEmptySet() {
        CustomList<Integer> customList = new CustomList<>();
        customList.clear();
        assertTrue(customList.isEmpty());
    }

    @Test
    public void givenLinkedListOfType_Integer_with_1_2_onClear_clearsList() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2));
        customList.clear();
        assertTrue(customList.isEmpty());
    }

    @Test
    public void givenEmptyListOfType_Integer_withValues_1_2_3_onClone_returnsMatchingLinkedList() {
        CustomList<Integer> customList = new CustomList<>();
        assertTrue(customList.add(1));
        assertTrue(customList.add(2));
        assertTrue(customList.add(3));
        assertEquals(customList, customList.clone());
    }

    @Test
    public void givenAListOf_0_to_32_integers_onContainsAllOf_5_10_and_20_returns_true() {
        CustomList<Integer> customList = new CustomList<>();
        List<Integer> collection = IntStream.of(5, 10, 20).boxed().toList();
        IntStream.range(0, 33).forEach(customList::add);
        assertTrue(customList.containsAll(collection));
    }

    @Test
    public void givenAListOf_0_to_32_integers_onContainsAllOf_5_10_and_200_returns_false() {
        CustomList<Integer> customList = new CustomList<>();
        List<Integer> collection = IntStream.of(5, 10, 200).boxed().toList();
        IntStream.range(0, 33).forEach(customList::add);
        assertFalse(customList.containsAll(collection));
    }

    @Test
    public void givenASetOf_0_to_32_integers_matchesInstanceOfSet() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        Set<Integer> collection = new HashSet<>(List.of(1, 2, 3));
        assertTrue(customList.containsAll(collection));
    }

    @Test
    public void givenAListOf_0_to_32_integers_onContainsAllOf_nullCollection_throws_NullPointerException() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 33).forEach(customList::add);
        assertThrows(NullPointerException.class, () -> customList.containsAll(null));
    }

    @Test
    public void whenGettingSubList_withFirstIndexSmallerThan_0_throws_IndexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);
        assertThrows(IndexOutOfBoundsException.class, () -> customList.subList(-1, 10));
    }

    @Test
    public void whenGettingSubList_withToIndexGreaterThanSize_throws_IndexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);
        assertThrows(IndexOutOfBoundsException.class, () -> customList.subList(0, 6));
    }

    @Test
    public void whenGettingSubList_withFromIndex_equals_toIndex_returns_emptyList() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);
        List<Integer> empty = customList.subList(3, 3);
        assertTrue(empty.isEmpty());
    }

    @Test
    public void whenGettingSubList_withToFromIndexGreaterThanToIndex_throws_IndexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);
        assertThrows(IndexOutOfBoundsException.class, () -> customList.subList(2, 1));
    }

    @Test
    public void whenGettingSubList_withIndexOf_2_8_returnsCorrectSublistOf_size_8() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 10).mapToObj(i -> i * 10).forEach(customList::add);
        CustomList<Integer> expected = new CustomList<>();
        IntStream.range(2, 8).mapToObj(i -> i * 10).forEach(expected::add);
        List<Integer> subList = customList.subList(2, 8);
        assertEquals(subList, expected);
    }

    @Test
    public void whenRemovingNullList_throws_NullPointerException() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);
        assertThrows(NullPointerException.class, () -> customList.removeAll(null));
    }

    @Test
    public void whenRemovingEmptyList_returns_false() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);
        assertFalse(customList.removeAll(new ArrayList<>()));
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_returns_true() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);
        Collection<Integer> items = IntStream.range(0, 3).mapToObj(i -> i * 10).toList();
        assertTrue(customList.removeAll(items));
    }

    @Test
    void removeAll_withSetCollection_shouldUseSetDirectly() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);
        Set<Integer> setToRemove = Set.of(0, 10);
        assertTrue(customList.removeAll(setToRemove));
        assertEquals(List.of(20, 30, 40), customList);
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_and_oneNot_returns_true() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);
        Collection<Integer> items = IntStream.range(2, 6).mapToObj(i -> i * 10).toList();
        assertTrue(customList.removeAll(items));
    }

    @Test
    public void whenRemovingListWithThreeIntegersPresentInCollection_withGaps_returns_true() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 5).mapToObj(i -> i * 10).forEach(customList::add);
        Collection<Integer> items = IntStream.of(0, 30, 10).boxed().toList();
        assertTrue(customList.removeAll(items));
    }

    @Test
    void insertInTheMiddle_singleElement_shouldKeepBothPartsConnected() {
        CustomList<Integer> customList = new CustomList<>(List.of(10, 20, 30));
        assertTrue(customList.addAll(1, List.of(99)));
        assertEquals(4, customList.size());
        assertListEquals(customList, 10, 99, 20, 30);
        assertEquals(30, customList.get(3));
    }

    @Test
    void insertInTheMiddle_multipleElements_shouldConnectBothDirections() {
        CustomList<Integer> customList = new CustomList<>();
        customList.addAll(List.of(1, 2, 3, 4, 5));
        customList.addAll(2, List.of(100, 200, 300));
        assertEquals(8, customList.size());
        assertListEquals(customList, 1, 2, 100, 200, 300, 3, 4, 5);
        assertEquals(300, customList.get(4));
        assertEquals(3,   customList.get(5));
        assertEquals(5,   customList.get(7));
    }

    @Test
    void insertAtIndexOne_shouldNotBreakTheRestOfTheList() {
        CustomList<String> customList = new CustomList<>(List.of("A", "B", "C", "D", "E"));
        customList.addAll(1, List.of("X", "Y"));
        assertEquals(7, customList.size());
        assertEquals("A", customList.get(0));
        assertEquals("X", customList.get(1));
        assertEquals("Y", customList.get(2));
        assertEquals("B", customList.get(3));
        assertEquals("E", customList.get(6));
    }

    @Test
    void insertInMiddle_afterwards_iterationShouldNotStopEarly() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        customList.addAll(3, List.of(100, 200));
        assertEquals(9, customList.size());
    }

    @Test
    void insertAtIndexSizeMinusOne_shouldStillReachOriginalTail() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3, 4));
        customList.addAll(3, List.of(-1, -2));
        assertEquals(6, customList.size());
        assertEquals(-2, customList.get(4));
        assertEquals( 4, customList.get(5));
    }

    @Test
    void addAllWithSameInstanceAtBeginning() {
        CustomList<Integer> customList = new CustomList<>(List.of(1,2,3));
        customList.addAll(0, customList);
    }

    @Test
    void bulkInsertMiddleAndEnds() {
        CustomList<Integer> customList = new CustomList<>();
        customList.addAll(List.of(1, 2, 3));
        customList.addAll(1, List.of(10, 11));
        customList.addAll(0, List.of(99));
        customList.addAll(customList.size(), List.of(88));
        assertEquals(List.of(99,1,10,11,2,3,88), List.copyOf(customList));
    }

    @Test
    void mixedOps_indexedAndBulk() {
        CustomList<Integer> customList = new CustomList<>();
        customList.addAll(List.of(1, 2, 3));
        customList.add(1, 99);
        customList.addAll(2, List.of(100, 101));
        customList.remove(0);
        customList.set(3, 777);
        assertEquals(List.of(99,100,101,777,3), List.copyOf(customList));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_onEqualsExactObjectThatMatch_returns_true() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        assertEquals(customList, customList);
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_onEqualsNonMatchingObject_returns_false() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        assertNotEquals(customList, new HashSet<>());
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_andListOf_1_2_onEquals_withDifferentSizes_returns_false() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        CustomList<Integer> customListTwo = new CustomList<>(List.of(1, 2));
        assertNotEquals(customList, customListTwo);
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_andCustomListOf_1_2_3_onEquals_withExactMatch_returns_true() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        CustomList<Integer> customListTwo = new CustomList<>(List.of(1, 2, 3));
        assertEquals(customList, customListTwo);
    }

    @Test
    public void givenCustomLinkedList_empty_andCustomList_empty_onEquals_returns_true() {
        CustomList<Integer> customList = new CustomList<>();
        CustomList<Integer> customListTwo = new CustomList<>();
        assertEquals(customList, customListTwo);
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_andCustomListOf_1_2_3_4_onEquals_returns_false() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        CustomList<Integer> customListTwo = new CustomList<>(List.of(1, 2, 3,4));
        assertNotEquals(customList, customListTwo);
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_andCustomListOf_1_2_4_onEquals_differentContentSameSize_returns_false() {
        CustomList<Integer> list1 = new CustomList<>(List.of(1, 2, 3));
        CustomList<Integer> list2 = new CustomList<>(List.of(1, 2, 4));
        assertNotEquals(list1, list2);
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_onRetainAll_nullCollection_throws_nullPointerException() {
        CustomList<Integer> customList = new CustomList<>();
        assertThrows(NullPointerException.class, () -> customList.retainAll(null));
    }

    @Test
    public void givenEmptyCustomLinkedList_1_2_3_onRetainAll_emptyCollection_returnsTrue_andEmptiesCollection() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        Collection<Integer> empty = new ArrayList<>();
        assertTrue(customList.retainAll(empty));
        assertFalse(customList.contains(1));
        assertFalse(customList.contains(2));
        assertFalse(customList.contains(3));
        assertTrue(customList.isEmpty());
    }

    @Test
    public void givenCustomLinkedList_onRetainAll_emptyCollection_returnsFalse() {
        CustomList<Integer> customList = new CustomList<>();
        Collection<Integer> empty = new ArrayList<>();
        assertFalse(customList.retainAll(empty));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3__onRetainAll_withListOf_1_2_returnsTrue_andLeavesValues_1_2() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        Collection<Integer> retain = new ArrayList<>(List.of(1, 2));
        assertTrue(customList.retainAll(retain));
        assertTrue(customList.contains(1));
        assertTrue(customList.contains(2));
        assertFalse(customList.contains(3));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3__onRetainAll_withSetOf_1_2_returnsTrue_andLeavesValues_1_2() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        Collection<Integer> retain = new HashSet<>(List.of(1, 2));
        assertTrue(customList.retainAll(retain));
        assertTrue(customList.contains(1));
        assertTrue(customList.contains(2));
        assertFalse(customList.contains(3));
    }

    @Test
    public void givenEmptyCustomLinkedList_hashCode_returns_1() {
        assertEquals(1, new CustomList<>().hashCode());
    }

    @Test
    public void hashCode_shouldMatchJavaLinkedList() {
        List<Integer> custom = new CustomList<>(List.of(1, 2, 3));
        List<Integer> standard = new LinkedList<>(List.of(1, 2, 3));
        assertEquals(standard.hashCode(), custom.hashCode());
    }

    @Test
    public void givenEmptyCustomLinkedList_on_iterator_next_throws_noSuchElementException() {
        CustomList<Integer> customList = new CustomList<>();
        assertThrows(NoSuchElementException.class, () -> customList.iterator().next());
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_ListIterator_hasNext_returns_true() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        assertTrue(customList.listIterator().hasNext());
    }

    @Test
    public void givneCustomLinkedListOf_1_2_3_on_ListIterator_hasPrevious_returns_false() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        assertFalse(customList.listIterator().hasPrevious());
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_ListIterator_withIndexOf_negative_1_throws_IndexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> customList.listIterator(-1));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_ListIterator_withIndexOf_3_throws_IndexOutOfBoundsException() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> customList.listIterator(3));
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_ListIterator_hasPrevious_returns_false() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        assertFalse(customList.listIterator().hasPrevious());
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_next_ListIterator_hasPrevious_returns_true() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        ListIterator<Integer> listIterator = customList.listIterator();
        assertEquals(1, listIterator.next());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());
        assertEquals(2, listIterator.previous());
    }

    @Test
    public void givenCustomLinkedListOf_1_2_3_on_ListIterator_withIndex_1_returnsListIterator_withValues_2_3() {
        CustomList<Integer> customList = new CustomList<>(List.of(1, 2, 3));
        ListIterator<Integer> listIterator = customList.listIterator(1);
        assertEquals(2, listIterator.next());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());
        assertEquals(3, listIterator.previous());
    }

    @Test
    public void bulkRemove_callsReduce() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 99).forEach(customList::add);
        IntStream.range(0, 50).map(i -> 0).forEach(customList::remove);
        assertEquals(50, customList.get(0));
    }

    @Test
    public void bulkCollectionRemoveAll_callsReduce() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 99).forEach(customList::add);
        List<Integer> toRemove = IntStream.range(0, 50).boxed().toList();
        customList.removeAll(toRemove);
        assertEquals(50, customList.get(0));
    }

    @Test
    public void bulkCollectionRetainAll_callsReduce() {
        CustomList<Integer> customList = new CustomList<>();
        IntStream.range(0, 99).forEach(customList::add);
        List<Integer> toRetain = IntStream.range(0, 50).boxed().toList();
        customList.retainAll(toRetain);
        assertEquals(0, customList.get(0));
    }

    private void assertListEquals(CustomList<Integer> list, Integer... expected) {
        assertEquals(expected.length, list.size());
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], list.get(i));
    }
}