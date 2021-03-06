package ru.javaops.webapp;

import ru.javaops.webapp.model.Resume;
import ru.javaops.webapp.storage.AbstractArrayStorage;
import ru.javaops.webapp.storage.SortedArrayStorage;

/**
 * Test for your ru.javaops.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final AbstractArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r4 = new Resume("uuid4");
        Resume r5 = new Resume("uuid5");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r5);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.update(r5);
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
