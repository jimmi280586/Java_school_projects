package data_structures.test.common;

import data_structures.interfaces.ISet;

public class SetTest {

    /**
     * In computer science, a set is an abstract data structure that can store certain values,
     * without any particular order, and no repeated values.
     *
     * http://en.wikipedia.org/wiki/Set_(abstract_data_type)
     *
     * @author Justin Wetherell <phishman3579@gmail.com>
     *
     * @param set Set to test.
     * @param name Name to use in debug.
     * @param data Test data.
     * @param invalid Invalid data which isn't in the data-structure.
     * @return True if the set passes it's invariants tests.
     */
    public static <T extends Comparable<T>> boolean testSet(ISet<T> set, String name,
                                                            T[] data, T invalid) {
        for (int i = 0; i < data.length; i++) {
            T item = data[i];
            boolean added = set.add(item);
            if (!set.validate() || (set.size() != i+1)) {
                System.err.println(name+" YIKES!! " + item + " caused a size mismatch.");
                Utils.handleError(set);
                return false;
            }
            if (!added || !set.contains(item)) {
                System.err.println(name+" YIKES!! " + item + " doesn't exists but has been added.");
                Utils.handleError(set);
                return false;
            }
        }

        boolean contains = set.contains(invalid);
        boolean removed = set.remove(invalid);
        if (contains || removed) {
            System.err.println(name+" invalidity check. contains=" + contains + " removed=" + removed);
            Utils.handleError(set);
            return false;
        }

        int size = set.size();
        for (int i = 0; i < size; i++) {
            T item = data[i];
            removed = set.remove(item);
            if (!set.validate() || (set.size() != data.length-(i+1))) {
                System.err.println(name+" YIKES!! " + item + " caused a size mismatch.");
                Utils.handleError(set);
                return false;
            }
            if (!removed || set.contains(item)) {
                System.err.println(name+" YIKES!! " + item + " still exists but it has been remove.");
                Utils.handleError(set);
                return false;
            }
        }

        // Add half, remove a quarter, add three-quarters, remove all
        int quarter = data.length/4;
        int half = data.length/2;
        for (int i = 0; i < half; i++) {
            T item = data[i];
            boolean added = set.add(item);
            if (!set.validate() || (set.size() != i+1)) {
                System.err.println(name+" YIKES!! " + item + " caused a size mismatch.");
                Utils.handleError(set);
                return false;
            }
            if (!added || !set.contains(item)) {
                System.err.println(name+" YIKES!! " + item + " doesn't exists but has been added.");
                Utils.handleError(set);
                return false;
            }
        }
        for (int i = (half-1); i >= quarter; i--) {
            T item = data[i];
            removed = set.remove(item);
            if (!set.validate() || (set.size() != i)) {
                System.err.println(name+" YIKES!! " + item + " caused a size mismatch.");
                Utils.handleError(set);
                return false;
            }
            if (!removed || set.contains(item)) {
                System.err.println(name+" YIKES!! " + item + " still exists but it has been remove.");
                Utils.handleError(set);
                return false;
            }
        }
        for (int i = quarter; i < data.length; i++) {
            T item = data[i];
            boolean added = set.add(item);
            if (!set.validate() || (set.size() != i+1)) {
                System.err.println(name+" YIKES!! " + item + " caused a size mismatch.");
                Utils.handleError(set);
                return false;
            }
            if (!added || !set.contains(item)) {
                System.err.println(name+" YIKES!! " + item + " doesn't exists but has been added.");
                Utils.handleError(set);
                return false;
            }
        }
        for (int i = data.length-1; i >= 0; i--) {
            T item = data[i];
            removed = set.remove(item);
            if (!set.validate() || (set.size() != i)) {
                System.err.println(name+" YIKES!! " + item + " caused a size mismatch.");
                Utils.handleError(set);
                return false;
            }
            if ((!removed || set.contains(item))) {
                System.err.println(name+" YIKES!! " + item + " still exists but it has been remove.");
                Utils.handleError(set);
                return false;
            }
        }

        if (set.size() != 0) {
            System.err.println(name+" YIKES!! a size mismatch.");
            Utils.handleError(set);
            return false;
        }

        return true;
    }
}
