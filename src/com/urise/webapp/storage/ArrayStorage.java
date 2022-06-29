package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (size == storage.length) {
            System.out.println("storage заполнен, сохранение нового резюме невозможно");
        } else if (index < size) {
            System.out.println("Элемент " + r + " уже есть в storage");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < size) {
            return storage[index];
        }
        System.out.println("Элемента " + uuid + " нет в storage");
        return null;
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < size) {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        } else {
            System.out.println("Элемента " + uuid + " нет в storage");
        }
        /*
        if (index < size) {
            size--;
            System.arraycopy(storage, index + 1, storage, index, size - index);
        } else {
            System.out.println("Элемента " + uuid + " нет в storage");
        }

         */
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < size) {
            storage[index] = resume;
        } else {
            System.out.println("Элементa " + resume + " нет в storage");
        }
    }

    private int findIndex(String s) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(s)) {
                return i;
            }
        }
        return size + 1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
