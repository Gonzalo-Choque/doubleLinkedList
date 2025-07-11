import datastructures.DoublyLinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoubleLinkedListTest {

    LinkedList<Integer> baseDLL = new DoublyLinkedList<>();

    /**
     * getFirst() tests (suggested: 2 points)
     */
    @Test(expected = NoSuchElementException.class)
    public void dll_1_getFirst_empty() {
        LinkedList<Integer> testDLL = baseDLL;
        testDLL.getFirst();
    }

    @Test
    public void dll_1_getFirst() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(3);
        Assert.assertEquals((int) testDLL.getFirst(), 3);

        testDLL.add(7);
        Assert.assertEquals((int) testDLL.getFirst(), 3);

        testDLL.add(-1);
        Assert.assertEquals((int) testDLL.getFirst(), 3);

        testDLL.addFirst(10);
        Assert.assertEquals((int) testDLL.getFirst(), 10);

        testDLL.addFirst(20);
        Assert.assertEquals((int) testDLL.getFirst(), 20);

        testDLL.remove();
        Assert.assertEquals((int) testDLL.getFirst(), 10);

        testDLL.removeLast();
        Assert.assertEquals((int) testDLL.getFirst(), 10);
    }

    /**
     * getLast() tests (suggested: 2 points)
     */
    @Test(expected = NoSuchElementException.class)
    public void dll_2_getLast_empty() {
        LinkedList<Integer> testDLL = baseDLL;
        testDLL.getLast();
    }

    @Test
    public void dll_2_getLast() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(3);
        Assert.assertEquals((int) testDLL.getLast(), 3);

        testDLL.add(7);
        Assert.assertEquals((int) testDLL.getLast(), 7);

        testDLL.add(-1);
        Assert.assertEquals((int) testDLL.getLast(), -1);

        testDLL.addFirst(10);
        Assert.assertEquals((int) testDLL.getLast(), -1);

        testDLL.addFirst(20);
        Assert.assertEquals((int) testDLL.getLast(), -1);

        testDLL.remove();
        Assert.assertEquals((int) testDLL.getLast(), -1);

        testDLL.removeLast();
        Assert.assertEquals((int) testDLL.getLast(), 7);
    }

    /**
     * removeFirst() tests (suggested: 2 points)
     */
    @Test(expected = NoSuchElementException.class)
    public void dll_3_removeFirst_empty() {
        LinkedList<Integer> testDLL = baseDLL;
        testDLL.getLast();
    }

    @Test
    public void dll_3_removeFirst() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(3);
        testDLL.add(5);
        testDLL.add(1);

        testDLL.removeFirst();
        Assert.assertEquals((int) testDLL.getFirst(), 5);

        testDLL.removeFirst();
        Assert.assertEquals((int) testDLL.getFirst(), 1);

        testDLL.addFirst(7);
        testDLL.addFirst(10);

        testDLL.removeFirst();
        Assert.assertEquals((int) testDLL.getFirst(), 7);
    }

    /**
     * removeLast() tests (suggested: 2 points)
     */
    @Test(expected = NoSuchElementException.class)
    public void dll_4_removeLast_empty() {
        LinkedList<Integer> testDLL = baseDLL;
        testDLL.removeLast();
    }

    @Test
    public void dll_4_removeLast() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(3);
        testDLL.add(5);
        testDLL.add(1);

        testDLL.removeLast();
        Assert.assertEquals((int) testDLL.getLast(), 5);

        testDLL.removeLast();
        Assert.assertEquals((int) testDLL.getLast(), 3);

        testDLL.addFirst(7);
        testDLL.addFirst(10);

        testDLL.removeLast();
        Assert.assertEquals((int) testDLL.getLast(), 7);
    }

    /**
     * addFirst() tests (suggested: 3 points)
     */
    @Test
    public void dll_5_addFirst() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.addFirst(1);
        Assert.assertEquals((int) testDLL.getFirst(), 1);

        testDLL.addFirst(2);
        Assert.assertEquals((int) testDLL.getFirst(), 2);

        testDLL.addFirst(3);
        Assert.assertEquals((int) testDLL.getFirst(), 3);

        testDLL.addFirst(4);
        Assert.assertEquals((int) testDLL.getFirst(), 4);
    }

    /**
     * addLast() tests (suggested: 3 points)
     */
    @Test
    public void dll_6_addLast() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.addLast(1);
        Assert.assertEquals((int) testDLL.getLast(), 1);

        testDLL.addLast(2);
        Assert.assertEquals((int) testDLL.getLast(), 2);

        testDLL.addLast(3);
        Assert.assertEquals((int) testDLL.getLast(), 3);

        testDLL.addLast(4);
        Assert.assertEquals((int) testDLL.getLast(), 4);
    }

    /**
     * contains() tests (suggested: 3 points)
     */
    @Test
    public void dll_7_contains() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertFalse(testDLL.contains(2));

        testDLL.add(1);
        Assert.assertTrue(testDLL.contains(1));

        testDLL.add(3);
        Assert.assertFalse(testDLL.contains(2));

        testDLL.add(5);
        testDLL.add(2);
        testDLL.add(1);

        Assert.assertTrue(testDLL.contains(1));
        Assert.assertTrue(testDLL.contains(3));
        Assert.assertTrue(testDLL.contains(5));
        Assert.assertTrue(testDLL.contains(2));
        Assert.assertTrue(testDLL.contains(1));
    }

    /**
     * size() tests (suggested: 2 points)
     */
    @Test
    public void dll_8_size() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertEquals(testDLL.size(), 0);

        testDLL.add(5);
        Assert.assertEquals(testDLL.size(), 1);

        testDLL.add(2);
        testDLL.add(1);
        Assert.assertEquals(testDLL.size(), 3);

        testDLL.removeFirst();
        Assert.assertEquals(testDLL.size(), 2);
    }

    /**
     * add() tests (suggested: 2 points)
     */
    @Test
    public void dll_9_add() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertTrue(testDLL.add(1));
        Assert.assertEquals((int) testDLL.getLast(), 1);

        Assert.assertTrue(testDLL.add(2));
        Assert.assertEquals((int) testDLL.getLast(), 2);

        Assert.assertTrue(testDLL.add(3));
        Assert.assertEquals((int) testDLL.getLast(), 3);

        Assert.assertTrue(testDLL.add(4));
        Assert.assertEquals((int) testDLL.getLast(), 4);
    }

    /**
     * remove() tests (suggested: 3 points)
     */
    @Test
    public void dll_10_remove() {
        LinkedList<Integer> testDLL = baseDLL;
        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(3);
        testDLL.add(4);
        testDLL.add(1);

        Assert.assertTrue(testDLL.remove(new Integer(1)));
        Assert.assertEquals((int) testDLL.getFirst(), 2);

        Assert.assertFalse(testDLL.remove(new Integer(10)));

        Assert.assertTrue(testDLL.remove(new Integer(1)));
        Assert.assertEquals((int) testDLL.getFirst(), 2);

        Assert.assertTrue(testDLL.remove(new Integer(2)));
        Assert.assertEquals((int) testDLL.getFirst(), 3);
    }

    /**
     * addAll() tests (suggested: 5 points)
     */
    @Test
    public void dll_11_addAll() {
        LinkedList<Integer> testDLL = baseDLL;
        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(3);
        testDLL.add(4);

        LinkedList<Integer> dllToBeAdded = new DoublyLinkedList<>();
        dllToBeAdded.add(5);
        dllToBeAdded.add(6);
        dllToBeAdded.add(7);
        dllToBeAdded.add(8);

        List<Integer> finalData = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        testDLL.addAll(dllToBeAdded);

        for (int i = 0; i < finalData.size(); i++) {
            Assert.assertEquals(testDLL.get(i), finalData.get(i));
        }
    }

    @Test
    public void dll_11_addAll_from_empty() {
        LinkedList<Integer> testDLL = baseDLL;

        //todo change to doubleLinkedList before push
        LinkedList<Integer> dllToBeAdded = new LinkedList<>();
        dllToBeAdded.add(5);
        dllToBeAdded.add(6);
        dllToBeAdded.add(7);
        dllToBeAdded.add(8);

        List<Integer> finalData = Arrays.asList(5, 6, 7, 8);

        testDLL.addAll(dllToBeAdded);

        for (int i = 0; i < finalData.size(); i++) {
            Assert.assertEquals(testDLL.get(i), finalData.get(i));
        }
    }

    /**
     * clear() tests (suggested: 2 points)
     */
    @Test
    public void dll_12_clear() {
        LinkedList<Integer> testDLL = baseDLL;
        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(3);

        testDLL.clear();

        Assert.assertTrue(testDLL.isEmpty());
    }

    /**
     * get() tests (suggested: 3 points)
     */
    @Test
    public void dll_13_get() {
        LinkedList<Integer> testDLL = baseDLL;
        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(3);

        Assert.assertEquals((int) testDLL.get(0), 1);
        Assert.assertEquals((int) testDLL.get(1), 2);
        Assert.assertEquals((int) testDLL.get(2), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void dll_13_get_empty() {
        LinkedList<Integer> testDLL = baseDLL;
        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(3);

        testDLL.get(3);
    }

    /**
     * set() tests (suggested: 2 points)
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void dll_14_set_empty() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.set(1, 3);
    }

    @Test
    public void dll_14_set() {
        LinkedList<Integer> testDLL = baseDLL;
        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(3);

        testDLL.set(1, 3);

        Assert.assertEquals((int) testDLL.get(1), 3);
    }

    /**
     * add() tests (suggested: 5 points)
     */
    @Test
    public void dll_14_add() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(2);
        testDLL.add(4);

        testDLL.add(1, 1);
        Assert.assertEquals((int) testDLL.get(1), 1);

        testDLL.add(3, 3);
        Assert.assertEquals((int) testDLL.get(3), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void dll_14_add_empty() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(2);
        testDLL.add(4);

        testDLL.add(10, 1);
    }

    /**
     * remove(int index) tests (suggested: 5 points)
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void dll_15_remove_empty() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.remove(10);
    }

    @Test
    public void dll_15_remove() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(1);
        testDLL.add(2);

        testDLL.remove(1);
        Assert.assertEquals(testDLL.size(), 2);

        Assert.assertEquals((int) testDLL.get(1), 2);
    }

    /**
     * indexOf tests (suggested: 3 points)
     */
    @Test
    public void dll_16_indexOf() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(1);

        Assert.assertEquals(testDLL.indexOf(1), 1);
        Assert.assertEquals(testDLL.indexOf(2), 2);

        Assert.assertEquals(testDLL.indexOf(10), -1);
    }

    @Test
    public void dll_16_indexOf_not_found() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);

        Assert.assertEquals(testDLL.indexOf(10), -1);
    }


    /**
     * lastIndexOf tests (suggested: 3 points)
     */
    @Test
    public void dll_17_lastIndexOf() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(1);
        testDLL.add(2);

        Assert.assertEquals(testDLL.lastIndexOf(1), 3);
        Assert.assertEquals(testDLL.lastIndexOf(2), 4);

        Assert.assertEquals(testDLL.indexOf(10), -1);
    }

    @Test
    public void dll_17_lastIndexOf_not_found() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);

        Assert.assertEquals(testDLL.indexOf(10), -1);
    }

    /**
     * peek tests (suggested: 2 points)
     */
    @Test
    public void dll_18_peek() {

        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(1);
        testDLL.add(2);

        Assert.assertEquals((int) testDLL.peek(), 0);
    }

    @Test
    public void dll_18_peek_empty() {

        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertNull(testDLL.peek());
    }

    /**
     * element tests (suggested: 2 points)
     */
    @Test
    public void dll_19_element() {

        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(1);
        testDLL.add(2);

        Assert.assertEquals((int) testDLL.element(), 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void dll_19_element_empty() {

        LinkedList<Integer> testDLL = baseDLL;

        testDLL.element();
    }

    /**
     * poll tests (suggested: 2 points)
     */
    @Test
    public void dll_20_poll_empty() {

        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertNull(testDLL.poll());
    }

    @Test
    public void dll_20_poll() {

        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(1);
        testDLL.add(2);

        Assert.assertEquals((int) testDLL.poll(), 0);

        Assert.assertEquals((int) testDLL.getFirst(), 1);

        Assert.assertEquals((int) testDLL.poll(), 1);

        Assert.assertEquals((int) testDLL.getFirst(), 2);
    }

    /**
     * remove tests (suggested: 2 points)
     */
    @Test(expected = NoSuchElementException.class)
    public void dll_21_remove_empty() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertNull(testDLL.remove());
    }

    @Test
    public void dll_21_remove() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(1);
        testDLL.add(2);

        Assert.assertEquals((int) testDLL.remove(), 0);

        Assert.assertEquals((int) testDLL.getFirst(), 1);

        Assert.assertEquals((int) testDLL.remove(), 1);

        Assert.assertEquals((int) testDLL.getFirst(), 2);
    }

    /**
     * offer tests (suggested: 2 points)
     */
    @Test
    public void dll_22_offer() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertTrue(testDLL.offer(0));
        Assert.assertEquals((int) testDLL.getLast(), 0);

        Assert.assertTrue(testDLL.offer(1));
        Assert.assertEquals((int) testDLL.getLast(), 1);

        Assert.assertTrue(testDLL.offer(2));
        Assert.assertEquals((int) testDLL.getLast(), 2);
    }


    /**
     * offerFirst tests (suggested: 2 points)
     */
    @Test
    public void dll_23_offerFirst() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertTrue(testDLL.offerFirst(0));
        Assert.assertEquals((int) testDLL.getFirst(), 0);

        Assert.assertTrue(testDLL.offerFirst(1));
        Assert.assertEquals((int) testDLL.getFirst(), 1);

        Assert.assertTrue(testDLL.offerFirst(2));
        Assert.assertEquals((int) testDLL.getFirst(), 2);
    }

    /**
     * offerLast tests (suggested: 2 points)
     */
    @Test
    public void dll_24_offerLast() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertTrue(testDLL.offerLast(0));
        Assert.assertEquals((int) testDLL.getLast(), 0);

        Assert.assertTrue(testDLL.offerLast(1));
        Assert.assertEquals((int) testDLL.getLast(), 1);

        Assert.assertTrue(testDLL.offerLast(2));
        Assert.assertEquals((int) testDLL.getLast(), 2);
    }

    /**
     * peekFirst tests (suggested: 2 points)
     */
    @Test
    public void dll_25_peekFirst_empty() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertNull(testDLL.peekFirst());
    }

    @Test
    public void dll_25_peekFirst() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(3);

        Assert.assertEquals((int) testDLL.peekFirst(), 1);
        Assert.assertEquals((int) testDLL.getFirst(), 1);
    }

    /**
     * peekLast tests (suggested: 2 points)
     */
    @Test
    public void dll_26_peekLast_empty() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertNull(testDLL.peekLast());
    }

    @Test
    public void dll_26_peekLast() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(3);

        Assert.assertEquals((int) testDLL.peekLast(), 3);
        Assert.assertEquals((int) testDLL.getLast(), 3);
    }

    /**
     * pollFirst tests (suggested: 2 points)
     */
    @Test
    public void dll_27_pollFirst_empty() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertNull(testDLL.pollFirst());
    }

    @Test
    public void dll_27_pollFirst() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(3);

        Assert.assertEquals((int) testDLL.pollFirst(), 1);
        Assert.assertEquals((int) testDLL.getFirst(), 2);
    }

    /**
     * pollLast tests (suggested: 2 points)
     */
    @Test
    public void dll_28_pollLast_empty() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertNull(testDLL.pollLast());
    }

    @Test
    public void dll28_pollLast() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(3);

        Assert.assertEquals((int) testDLL.pollLast(), 3);
        Assert.assertEquals((int) testDLL.getLast(), 2);
    }

    /**
     * push tests (suggested: 3 points)
     */
    @Test
    public void dll_29_push() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.push(0);
        Assert.assertEquals((int) testDLL.getFirst(), 0);

        testDLL.push(1);
        Assert.assertEquals((int) testDLL.getFirst(), 1);

        testDLL.push(2);
        Assert.assertEquals((int) testDLL.getFirst(), 2);
    }

    /**
     * pop tests (suggested: 3 points)
     */
    @Test
    public void dll_30_pop() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.push(0);
        testDLL.push(1);
        testDLL.push(2);


        Assert.assertEquals((int) testDLL.pop(), 2);
        Assert.assertEquals((int) testDLL.getFirst(), 1);

        Assert.assertEquals((int) testDLL.pop(), 1);
        Assert.assertEquals((int) testDLL.getFirst(), 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void dll_30_pop_empty() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.pop();
    }

    /**
     * removeFirstOccurrence tests (suggested: 3 points)
     */
    @Test
    public void dll_31_removeFirstOccurrence() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(0);

        Assert.assertTrue(testDLL.removeFirstOccurrence(0));

        Assert.assertEquals((int) testDLL.getFirst(), 1);
    }

    @Test
    public void dll_31_removeFirstOccurrence_no_index() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertFalse(testDLL.removeFirstOccurrence(0));
    }

    /**
     * removeLastOccurrence tests (suggested: 3 points)
     */
    @Test
    public void dll_32_removeLastOccurrence() {
        LinkedList<Integer> testDLL = baseDLL;

        testDLL.add(0);
        testDLL.add(1);
        testDLL.add(2);
        testDLL.add(0);

        Assert.assertTrue(testDLL.removeLastOccurrence(0));

        Assert.assertEquals((int) testDLL.getLast(), 2);
    }

    @Test
    public void dll_32_removeLastOccurrence_no_index() {
        LinkedList<Integer> testDLL = baseDLL;

        Assert.assertFalse(testDLL.removeFirstOccurrence(0));
    }


}
